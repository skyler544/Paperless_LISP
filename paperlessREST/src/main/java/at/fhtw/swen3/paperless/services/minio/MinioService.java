package at.fhtw.swen3.paperless.services.minio;

import at.fhtw.swen3.paperless.config.MinioConfig;

import io.minio.BucketExistsArgs;
import io.minio.MakeBucketArgs;
import io.minio.PutObjectArgs;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

@Component
public class MinioService implements DocumentStoreService {

    final Logger logger = LogManager.getLogger(MinioService.class);

    private final MinioConfig minioConfig;

    public MinioService(@Autowired MinioConfig minioConfig) {
        this.minioConfig = minioConfig;
        this.logger.info("Connecting to MinIO\n");
        try {
            if (!minioConfig
                    .getMinioClient()
                    .bucketExists(
                            BucketExistsArgs.builder().bucket(minioConfig.getBucketName()).build()))
                this.createBucket(minioConfig.getBucketName());
        } catch (Exception e) {
            this.logger.error(String.format("Error initializing MinIO \n%s", e));
        }
    }

    private void createBucket(String name) {
        try {
            minioConfig.getMinioClient().makeBucket(MakeBucketArgs.builder().bucket(name).build());
            this.logger.info(String.format("Creating bucket: %s\n", name));
        } catch (Exception e) {
            this.logger.error(String.format("Error creating bucket: %s\n%s", name, e));
        }
    }

    @Override
    public void handleFileUpload(MultipartFile document) {
        try {
            if (document.isEmpty()) {
                throw new Exception("Failed to store empty file.");
            }

            try (InputStream inputStream = document.getInputStream()) {
                minioConfig
                        .getMinioClient()
                        .putObject(
                                PutObjectArgs.builder()
                                        .bucket(minioConfig.getBucketName())
                                        .object(document.getOriginalFilename())
                                        .stream(inputStream, document.getSize(), -1)
                                        .build());
            }

            this.logger.info(
                    String.format(
                            "Uploading document to MinIO: %s\n", document.getOriginalFilename()));
        } catch (Exception e) {
            this.logger.error(
                    String.format(
                            "Error placing document: %s\n%s", document.getOriginalFilename(), e));
        }
    }
}
