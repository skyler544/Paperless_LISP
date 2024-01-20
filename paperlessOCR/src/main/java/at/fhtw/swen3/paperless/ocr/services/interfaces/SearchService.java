package at.fhtw.swen3.paperless.ocr.services.interfaces;

import at.fhtw.swen3.paperless.ocr.entities.DocumentEntity;

import java.io.IOException;

public interface SearchService {

    void indexDocument(DocumentEntity document) throws IOException;

}
