package at.fhtw.swen3.paperless.ocr.services;

import io.minio.GetObjectArgs;
import io.minio.GetObjectResponse;
import io.minio.MinioClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.nio.file.Path;
import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class MinioServiceTest {

    @Autowired
    private MinioService minioService;

    @MockBean
    private MinioClient minioClient;

    @Test
    public void whenFileNameGivenCorrectPathReturned() {

        try {

            //Given
            String path = "test-path";
            String bucketName = "bucket";
            Path expectedPath = Path.of("/", bucketName, path);
            GetObjectResponse expectedResponse = new GetObjectResponse(null, bucketName, "region", "object", null);

            //Mock behaviour of minioClient
            Mockito.when(minioClient.getObject(Mockito.any(GetObjectArgs.class)))
                    .thenReturn(expectedResponse);

            //Mock behaviour of minioService
            Mockito.when(minioService.retrieveFile(path)).thenReturn(expectedPath);

            // When
            Path pathAsPath = minioService.retrieveFile(path);

            // Then
            assertEquals(pathAsPath, expectedPath);
        } catch (Exception e) {
            System.out.printf(e.getMessage());
            throw new RuntimeException(e);
        }

    }

}