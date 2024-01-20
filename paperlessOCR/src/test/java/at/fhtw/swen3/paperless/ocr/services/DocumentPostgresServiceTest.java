package at.fhtw.swen3.paperless.ocr.services;

import at.fhtw.swen3.paperless.ocr.repositories.DocumentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class DocumentPostgresServiceTest {

    @Mock
    private DocumentRepository documentRepository;

    @InjectMocks
    private DocumentPostgresService documentPostgresService;

    @Test
    public void whenDocumentUpdatedRepositoryCalled() {
        //when
        documentPostgresService.updateDocumentContent(1, "blabla");

        //then
        Mockito.verify(documentRepository, Mockito.times(1)).updateDocumentContentById("blabla", 1);

    }

}