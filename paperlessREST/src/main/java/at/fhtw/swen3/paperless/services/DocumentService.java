package at.fhtw.swen3.paperless.services;

import at.fhtw.swen3.paperless.models.entity.DocumentEntity;
import at.fhtw.swen3.paperless.repositories.DocumentRepository;
import at.fhtw.swen3.paperless.services.customDTOs.PostDocumentRequestDto;
import at.fhtw.swen3.paperless.services.mapper.PostDocumentMapper;
import at.fhtw.swen3.paperless.services.messageQueue.MQService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class DocumentService {

    Logger logger = LogManager.getLogger(DocumentService.class);

    private final DocumentRepository documentRepository;

    private final MQService mqService;

    public DocumentService(DocumentRepository documentRepository, MQService mqService) {
        this.documentRepository = documentRepository;
        this.mqService = mqService;
    }

    public DocumentEntity saveDocument(PostDocumentRequestDto postDocumentRequestDto) {

        try {
            var result = PostDocumentMapper.INSTANCE.dtoToEntity(postDocumentRequestDto);
            documentRepository.save(result);
            mqService.processMessage(String.format("Save document with title %s", postDocumentRequestDto.getTitle()));
            return result;
        } catch (Exception e) {

            this.logger.error(String.format("Error saving document \n%s", e));
            throw e;

        }

    }
}
