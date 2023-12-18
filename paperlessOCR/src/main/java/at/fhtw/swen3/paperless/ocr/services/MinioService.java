package at.fhtw.swen3.paperless.ocr.services;

import io.minio.GetObjectArgs;
import io.minio.MinioClient;
import lombok.Getter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

@Service
public class MinioService {
    Logger logger = LogManager.getLogger(MinioService.class);
    private final String BUCKET_NAME = "documents";

    @Getter
    private final MinioClient minioClient =
        MinioClient.builder().endpoint("http://minio:9000")
            .credentials("paperless_minio", "paperless").build();

    public Path retrieveFile(String path) {
        this.logger.info(String.format("Retrieving file: %s\n", path));

        try (InputStream stream =
            minioClient.getObject(GetObjectArgs
                .builder()
                .bucket(BUCKET_NAME)
                .object(path)
                .build())) {
            // Read the stream
            Path outputPath = Path.of("/", BUCKET_NAME, path);
            Files.createDirectories(outputPath.getParent());
            Files.copy(
                stream,
                outputPath,
                StandardCopyOption.REPLACE_EXISTING);
            this.logger.info(String.format("Successfully retrieved file: %s\n",
                outputPath.getFileName()));
            return outputPath;
        } catch (Exception e) {
            this.logger.info(String.format("Failed to retrieve file: %s\n", path));
            throw new RuntimeException(e);
        }
    }

}
