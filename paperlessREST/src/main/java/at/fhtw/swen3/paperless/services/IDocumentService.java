package at.fhtw.swen3.paperless.services;

import at.fhtw.swen3.paperless.models.entity.DocumentEntity;
import at.fhtw.swen3.paperless.services.customDTOs.PostDocumentRequestDto;

public interface IDocumentService {
    DocumentEntity saveDocument(PostDocumentRequestDto postDocumentRequestDto);
}
