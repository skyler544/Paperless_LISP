package at.fhtw.swen3.paperless.config;

import io.minio.MinioClient;

import lombok.Getter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MinioConfig {
    @Getter private final String bucketName = "documents";
    @Getter private MinioClient minioClient;
    @Getter private String minioEndpoint;

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
