package at.fhtw.swen3.paperless.ocr.services;

import at.fhtw.swen3.paperless.ocr.entities.DocumentEntity;
import at.fhtw.swen3.paperless.ocr.services.interfaces.*;
import co.elastic.clients.elasticsearch.core.IndexRequest;
import co.elastic.clients.util.ObjectBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.sourceforge.tess4j.TesseractException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.OffsetDateTime;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;

@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class OcrDispatcherServiceTest {

    @Mock
    MinioService documentStoreService;

    @Mock
    TesseractService ocrExecutorService;

    @Mock
    DocumentPostgresService documentDbStorageService;

    @Mock
    ElasticSearchService searchService;

    @InjectMocks
    OcrDispatcherService dispatcherService;

    @Test
    public void testHandleMessageMethodsCalled() throws TesseractException, IOException {



        //given
        DocumentEntity doc = new DocumentEntity();
        String docContent = "Doc content";
        doc.setContent(docContent);
        String docTitle = "title.pdf";
        doc.setTitle(docTitle);
        doc.setCreatedDate(OffsetDateTime.now().toString());
        Integer docId = 1;
        doc.setId(docId);
        String receivedMessage = new ObjectMapper().writeValueAsString(doc);
        Path filePath = Paths.get(docTitle);

        //overwrite mock behaviour to avoid NRE
        Mockito.when(documentStoreService.retrieveFile(anyString())).thenReturn(filePath);
        Mockito.when(ocrExecutorService.executeOcr(any(File.class))).thenReturn(docContent);

        //when
        this.dispatcherService.handleMessage(receivedMessage);

        //then
        //verify minio service correctly called
        Mockito.verify(documentStoreService, Mockito.times(1)).retrieveFile(filePath.toString());

        //verify ocr service correctly called
        Mockito.verify(ocrExecutorService, Mockito.times(1)).executeOcr(any(File.class));

        //verify document update in db service is correctly called
        Mockito.verify(documentDbStorageService, Mockito.times(1)).updateDocumentContent(docId, docContent);

        //verify searchService is correctly called
        Mockito.verify(searchService, Mockito.times(1)).indexDocument(any(DocumentEntity.class));


    }

}