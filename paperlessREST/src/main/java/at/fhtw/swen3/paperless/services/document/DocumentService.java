package at.fhtw.swen3.paperless.services.document;

import at.fhtw.swen3.paperless.models.entity.DocumentEntity;
import at.fhtw.swen3.paperless.repositories.DocumentRepository;
import at.fhtw.swen3.paperless.services.dto.Document;
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

    public DocumentEntity saveDocument(Document document) {
        try {
            var mappedDocumentEntity = PostDocumentMapper.INSTANCE.dtoToEntity(document);
            documentRepository.save(mappedDocumentEntity);

            return mappedDocumentEntity;
        } catch (Exception e) {
            this.logger.error(String.format("Error saving document \n%s", e));
            throw e;
        }
    }

    public List<DocumentEntity> fetchAllDocuments() {
        return this.documentRepository.findAll();
    }

    public List<DocumentEntity> searchDocuments(String query) throws IOException {
        return this.searchService.searchDocumentsByQuery(query);
    }
}
