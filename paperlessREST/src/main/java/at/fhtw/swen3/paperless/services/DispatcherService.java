package at.fhtw.swen3.paperless.services;

import at.fhtw.swen3.paperless.services.customDTOs.PostDocumentRequestDto;
import at.fhtw.swen3.paperless.services.messageQueue.MQService;
import at.fhtw.swen3.paperless.services.minio.MinioService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class DispatcherService implements IDispatcherService {

    Logger logger = LogManager.getLogger(DispatcherService.class);

    private final DocumentService documentService;
    private final MQService mqService;
    private final MinioService minioService;

    @Autowired
    public DispatcherService(DocumentService documentService, MQService mqService,
            MinioService minioService) {
        this.documentService = documentService;
        this.mqService = mqService;
        this.minioService = minioService;
    }

    @Override
    public void handleDocument(MultipartFile file, PostDocumentRequestDto postDocRequestDto) {
       var mappedDocumentEntity = documentService.saveDocument(postDocRequestDto);
        minioService.handleFileUpload(file);

        // TODO: figure out what the exact content of the message should be
        mqService.processMessage(String.format("[ID: %d]\n[Name: %s]", mappedDocumentEntity.getId(), mappedDocumentEntity.getTitle()));
    }

}
