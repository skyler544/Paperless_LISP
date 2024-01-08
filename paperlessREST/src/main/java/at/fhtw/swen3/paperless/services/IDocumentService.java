package at.fhtw.swen3.paperless.services;

import at.fhtw.swen3.paperless.models.entity.DocumentEntity;
import at.fhtw.swen3.paperless.services.customDTOs.PostDocumentRequestDto;

import java.io.IOException;
import java.util.List;

public interface IDocumentService {
    DocumentEntity saveDocument(PostDocumentRequestDto postDocumentRequestDto);

    List<DocumentEntity> fetchAllDocuments();

    List<DocumentEntity> searchDocuments(String query) throws IOException;
}
