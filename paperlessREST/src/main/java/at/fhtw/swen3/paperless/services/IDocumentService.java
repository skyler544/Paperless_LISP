package at.fhtw.swen3.paperless.services;

import at.fhtw.swen3.paperless.services.customDTOs.PostDocumentRequestDto;

public interface IDocumentService {
    void saveDocument(PostDocumentRequestDto postDocumentRequestDto);
}
