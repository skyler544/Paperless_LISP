package at.fhtw.swen3.paperless.services;

import at.fhtw.swen3.paperless.models.entity.DocumentEntity;
import at.fhtw.swen3.paperless.services.customDTOs.PostDocumentRequestDto;
import at.fhtw.swen3.paperless.services.document.DocumentService;
import at.fhtw.swen3.paperless.services.messageQueue.MessageQueueService;
import at.fhtw.swen3.paperless.services.minio.DocumentStoreService;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class DispatcherService implements IDispatcherService {

    final Logger logger = LogManager.getLogger(DispatcherService.class);

    private final DocumentService documentService;
    private final MessageQueueService mqService;
    private final DocumentStoreService minioService;

    @Autowired
    public DispatcherService(
            DocumentService documentService,
            MessageQueueService mqService,
            DocumentStoreService minioService) {
        this.documentService = documentService;
        this.mqService = mqService;
        this.minioService = minioService;
    }

    @Override
    public void handleDocument(MultipartFile file, PostDocumentRequestDto postDocRequestDto)
            throws JsonProcessingException {
        var mappedDocumentEntity = documentService.saveDocument(postDocRequestDto);

        this.logger.info(String.format("Uploading %s to Minio.", file.toString()));
        minioService.handleFileUpload(file);

        // send the entire document entity over
        this.logger.info(
                String.format(
                        "Submitting %s to the message queue.", mappedDocumentEntity.toString()));
        mqService.processMessage(new ObjectMapper().writeValueAsString(mappedDocumentEntity));
    }

    @Override
    public List<DocumentEntity> handleGetDocuments(String query) throws IOException {
        if (query == null || query.isEmpty()) {
            return this.documentService.fetchAllDocuments();
        } else {
            return this.documentService.searchDocuments(query);
        }
    }
}
