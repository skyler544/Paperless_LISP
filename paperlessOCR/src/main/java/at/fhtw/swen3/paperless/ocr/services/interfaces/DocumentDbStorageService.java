package at.fhtw.swen3.paperless.ocr.services.interfaces;

public interface DocumentDbStorageService {
    public void updateDocumentContent(Integer docId, String parsedDocumentContent);
}
