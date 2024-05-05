package at.fhtw.swen3.paperless.config;

import io.minio.MinioClient;

import lombok.Getter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
public class MinioConfig {
    private final String bucketName = "documents";
    private final MinioClient minioClient;
    private final String minioEndpoint;

    public MinioConfig(
            @Value("${paperless.minio.username}") String minioUsername,
            @Value("${paperless.minio.password}") String minioPassword,
            @Value("${paperless.minio.host}") String minioHostname,
            @Value("${paperless.minio.port}") int minioPort) {

        minioEndpoint = "http://" + minioHostname + ":" + minioPort;

        this.minioClient =
                MinioClient.builder()
                        .endpoint(minioEndpoint)
                        .credentials(minioUsername, minioPassword)
                        .build();
    }
}
