package at.fhtw.swen3.paperless.services;

import at.fhtw.swen3.paperless.models.entity.DocumentEntity;
import at.fhtw.swen3.paperless.repositories.DocumentRepository;
import at.fhtw.swen3.paperless.services.customDTOs.PostDocumentRequestDto;
import at.fhtw.swen3.paperless.services.mapper.PostDocumentMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class DocumentService {

    Logger logger = LogManager.getLogger(DocumentService.class);

    private final DocumentRepository documentRepository;

    public DocumentService(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    public DocumentEntity saveDocument(PostDocumentRequestDto postDocumentRequestDto) {

        try {
            var result = PostDocumentMapper.INSTANCE.dtoToEntity(postDocumentRequestDto);
            documentRepository.save(result);
            return result;
        } catch (Exception e) {

            this.logger.error(String.format("Error saving document \n%s", e));
            throw e;

        }

    }
}
