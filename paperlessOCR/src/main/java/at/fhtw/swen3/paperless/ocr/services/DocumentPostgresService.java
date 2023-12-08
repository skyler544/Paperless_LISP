package at.fhtw.swen3.paperless.ocr.services;

import at.fhtw.swen3.paperless.ocr.repositories.DocumentRepository;
import at.fhtw.swen3.paperless.ocr.services.interfaces.DocumentDbStorageService;
import org.springframework.stereotype.Service;

@Service
public class DocumentPostgresService implements DocumentDbStorageService {

    private final DocumentRepository documentRepository;

    public DocumentPostgresService(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    @Override
    public void updateDocumentContent(Integer docId, String parsedDocumentContent) {

        documentRepository.updateDocumentContentById(parsedDocumentContent, docId);

    }

}
