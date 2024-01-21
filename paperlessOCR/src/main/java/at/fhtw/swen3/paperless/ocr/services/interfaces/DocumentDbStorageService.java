package at.fhtw.swen3.paperless.ocr.services.interfaces;

public interface DocumentDbStorageService {
    void updateDocumentContent(Integer docId, String parsedDocumentContent);
}
