package at.fhtw.swen3.paperless.services.minio;

import io.minio.BucketExistsArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;

import lombok.Getter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

@Component
public class MinioService implements DocumentStoreService {

    Logger logger = LogManager.getLogger(MinioService.class);

    private final String BUCKET_NAME = "documents";

    @Value("${paperless.minio.username}")
    private String minioUsername;

    @Value("${paperless.minio.password}")
    private String minioPassword;

    @Value("${paperless.minio.host}")
    private String minioHostname;

    @Value("${paperless.minio.port}")
    private int minioPort;

    @Getter
    private final MinioClient minioClient =
            MinioClient.builder()
                    .endpoint("http://" + minioHostname + ":" + minioPort)
                    .credentials(minioUsername, minioPassword)
                    .build();

    public MinioService() {
        // how many of these logging statements is too many? great logger by the way @Billojullo
        this.logger.info(String.format("Connecting to MinIO\n"));
        try {
            if (!this.minioClient.bucketExists(
                    BucketExistsArgs.builder().bucket(BUCKET_NAME).build()))
                this.createBucket(BUCKET_NAME);
        } catch (Exception e) {
            this.logger.error(String.format("Error initializing MinIO \n%s", e));
        }
    }

    private void createBucket(String name) {
        try {
            this.minioClient.makeBucket(MakeBucketArgs.builder().bucket(name).build());
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
                minioClient.putObject(
                        PutObjectArgs.builder()
                                .bucket(BUCKET_NAME)
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
