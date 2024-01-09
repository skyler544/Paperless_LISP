package at.fhtw.swen3.paperless.ocr.services.interfaces;

import java.nio.file.Path;

public interface DocumentStoreService {
    public Path retrieveFile(String path);
}
