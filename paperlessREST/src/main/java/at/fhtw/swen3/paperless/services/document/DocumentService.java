package at.fhtw.swen3.paperless.services.document;

import at.fhtw.swen3.paperless.models.entity.DocumentEntity;
import at.fhtw.swen3.paperless.repositories.DocumentRepository;
import at.fhtw.swen3.paperless.services.customDTOs.PostDocumentRequestDto;
import at.fhtw.swen3.paperless.services.mapper.PostDocumentMapper;
import at.fhtw.swen3.paperless.services.search.SearchService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class DocumentService implements IDocumentService {
    final Logger logger = LogManager.getLogger(DocumentService.class);

    private final DocumentRepository documentRepository;

    private final SearchService searchService;

    public DocumentService(DocumentRepository documentRepository, SearchService searchService) {
        this.documentRepository = documentRepository;
        this.searchService = searchService;
    }

    @Override
    public DocumentEntity saveDocument(PostDocumentRequestDto postDocumentRequestDto) {
        try {
            var mappedDocumentEntity =
                    PostDocumentMapper.INSTANCE.dtoToEntity(postDocumentRequestDto);
            documentRepository.save(mappedDocumentEntity);

            return mappedDocumentEntity;
        } catch (Exception e) {
            this.logger.error(e.getMessage());
            this.logger.error(String.format("Error saving document \n%s", e));
            throw e;
        }
    }

    @Override
    public List<DocumentEntity> fetchAllDocuments() {
        return this.documentRepository.findAll();
    }

    @Override
    public List<DocumentEntity> searchDocuments(String query) throws IOException {
        return this.searchService.searchDocumentsByQuery(query);
    }
}
