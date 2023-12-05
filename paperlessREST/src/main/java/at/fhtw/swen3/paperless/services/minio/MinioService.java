package at.fhtw.swen3.paperless.services.minio;

import io.minio.BucketExistsArgs;
import io.minio.MakeBucketArgs;
import lombok.Getter;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.ObjectMapper;
import at.fhtw.swen3.paperless.models.entity.DocumentEntity;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.ByteArrayInputStream;

@Component
public class MinioService {

    Logger logger = LogManager.getLogger(MinioService.class);

    private final String BUCKET_NAME = "documents";

    // should not be modified, therefore final and directly initialized.
    // TODO maybe make a config class and inject it in the constructor instead
    @Getter
    private final MinioClient minioClient =
            MinioClient.builder().endpoint("http://minio:9000")
                    .credentials("paperless_minio", "paperless").build();

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

    public void putDocument(DocumentEntity document) {
        try {
            // serialized into json; do we need this really or can we just upload it somehow?
            ObjectMapper om = new ObjectMapper();
            String doc = om.writeValueAsString(document);
            var fileAsByteArray =
                    new ByteArrayInputStream(om.writeValueAsBytes(document));

            // this stream function is somewhat difficult to use; you need to give it either
            // an object size or a part size, but I don't see an easy way to find the actual size here
            this.minioClient.putObject(PutObjectArgs.builder().bucket(BUCKET_NAME)
                    .object(document.getTitle())
                    .stream(fileAsByteArray, doc.length(), -1).build());

            this.logger.info(String.format("Uploading document to MinIO: %s\n", doc));
        } catch (Exception e) {
            this.logger.error(String.format("Error placing document: %s\n%s",
                    document.getTitle(), e));
        }
    }

}
