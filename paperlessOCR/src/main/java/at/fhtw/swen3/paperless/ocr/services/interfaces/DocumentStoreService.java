package at.fhtw.swen3.paperless.ocr.services.interfaces;

import java.nio.file.Path;

public interface DocumentStoreService {
    Path retrieveFile(String path);
}
