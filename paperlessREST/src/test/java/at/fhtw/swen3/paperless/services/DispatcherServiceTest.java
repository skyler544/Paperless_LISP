package at.fhtw.swen3.paperless.services;

import at.fhtw.swen3.paperless.models.entity.DocumentEntity;
import at.fhtw.swen3.paperless.services.customDTOs.PostDocumentRequestDto;
import at.fhtw.swen3.paperless.services.document.DocumentService;
import at.fhtw.swen3.paperless.services.messageQueue.MessageQueueService;
import at.fhtw.swen3.paperless.services.minio.DocumentStoreService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ActiveProfiles("test")
@SpringBootTest
class DispatcherServiceTest {

    @Mock
    private DocumentService documentService;
    @Mock
    private MessageQueueService mqService;
    @Mock
    private DocumentStoreService minioService;
    @Mock
    private MultipartFile file;
    @Mock
    PostDocumentRequestDto postDocumentRequestDto;
    @InjectMocks
    private DispatcherService dispatcherService;

    private List<DocumentEntity> createTestDocumentEntities() {
        List<DocumentEntity> documentEntities = new ArrayList<>();

        DocumentEntity documentEntity1 = new DocumentEntity();
        documentEntity1.setId(1);
        documentEntity1.setCorrespondent(123);
        documentEntity1.setDocumentType(456);
        documentEntity1.setTitle("Test Document 1");
        documentEntity1.setContent("Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
        documentEntity1.setCreatedDate("2024-01-22");
        documentEntities.add(documentEntity1);

        DocumentEntity documentEntity2 = new DocumentEntity();
        documentEntity2.setId(2);
        documentEntity2.setCorrespondent(456);
        documentEntity2.setDocumentType(789);
        documentEntity2.setTitle("Test Document 2");
        documentEntity2.setContent("Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
        documentEntity2.setCreatedDate("2024-01-23");
        documentEntities.add(documentEntity2);

        return documentEntities;
    }

    @Test
    public void TestHandleGetDocuments() throws IOException {

        DocumentEntity documentEntity = new DocumentEntity();
        when(documentService.saveDocument(eq(postDocumentRequestDto))).thenReturn(documentEntity);

        doNothing().when(minioService).handleFileUpload(eq(file));

        ObjectMapper objectMapper = new ObjectMapper();
        String expectedJsonString = objectMapper.writeValueAsString(documentEntity);
        doNothing().when(mqService).processMessage(eq(expectedJsonString));

        dispatcherService.handleDocument(file, postDocumentRequestDto);

        verify(documentService, times(1)).saveDocument(any(PostDocumentRequestDto.class));
        verify(minioService, times(1)).handleFileUpload(eq(file));
        verify(mqService, times(1)).processMessage(eq(expectedJsonString));
    }

    @Test
    public void givenQueryIsNull_whenHandleDocuments_thenFetchAllDocuments() throws IOException {
        // Arrange
        List<DocumentEntity> expectedList = createTestDocumentEntities();
        when(documentService.fetchAllDocuments()).thenReturn(expectedList);

        // Act
        List<DocumentEntity> actualList = dispatcherService.handleGetDocuments(null);

        // Assert
        assertEquals(expectedList.size(), actualList.size());
    }

    @Test
    public void givenQueryIsNotNull_whenHandleDocumentsIsInvoked3Times_thenSearchDocsIsExecuted3Times() throws IOException {
        // Arrange
        String searchQuery = "test";

        // Act
        dispatcherService.handleGetDocuments(searchQuery);
        dispatcherService.handleGetDocuments(searchQuery);
        dispatcherService.handleGetDocuments(searchQuery);

        // Assert
        verify(documentService, times(3)).searchDocuments(searchQuery);
    }

    @Test
    public void givenQueryIsNull_whenHandleDocumentsIsInvoked3Times_thenFetchAllDocsIsExecuted3Times() throws IOException {
        // Arrange
        String searchQuery = null;

        // Act
        dispatcherService.handleGetDocuments(searchQuery);
        dispatcherService.handleGetDocuments(searchQuery);
        dispatcherService.handleGetDocuments(searchQuery);

        // Assert
        verify(documentService, times(3)).fetchAllDocuments();
    }

    @Test
    public void givenDispatcherService_whenHandleDocument_thenCallExpectedMethods() throws JsonProcessingException {
        // Arrange
        DocumentEntity mappedDocumentEntity = new DocumentEntity();
        when(documentService.saveDocument(postDocumentRequestDto)).thenReturn(mappedDocumentEntity);

        // Act
        dispatcherService.handleDocument(file, postDocumentRequestDto);

        // Assert
        verify(documentService, times(1)).saveDocument(postDocumentRequestDto);
        verify(minioService, times(1)).handleFileUpload(file);
        verify(mqService, times(1)).processMessage(any(String.class));

        dispatcherService.handleDocument(file, postDocumentRequestDto);
        dispatcherService.handleDocument(file, postDocumentRequestDto);

        verify(documentService, times(3)).saveDocument(postDocumentRequestDto);
        verify(minioService, times(3)).handleFileUpload(file);
        verify(mqService, times(3)).processMessage(any(String.class));

    }

}