package at.fhtw.swen3.paperless.ocr.services;

import at.fhtw.swen3.paperless.ocr.services.interfaces.DocumentDbStorageService;
import at.fhtw.swen3.paperless.ocr.services.interfaces.OcrExecutorService;
import com.fasterxml.jackson.databind.ObjectMapper;
import at.fhtw.swen3.paperless.ocr.entities.DocumentEntity;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.nio.file.Path;

@Service
public class OcrDispatcherService {
    Logger logger = LogManager.getLogger(OcrDispatcherService.class);

    private final MinioService minioService;

    private final OcrExecutorService ocrExecutorService;

    private final DocumentDbStorageService documentDbStorageService;

    public OcrDispatcherService(MinioService minioService, TesseractService tesseractService, DocumentPostgresService documentPostgresService) {
        this.minioService = minioService;
        this.ocrExecutorService = tesseractService;
        this.documentDbStorageService = documentPostgresService;
    }

    public void handleMessage(String message) {
        // deserialize message
        DocumentEntity document;
        var om = new ObjectMapper();
        try {
            document = om.readValue(message, DocumentEntity.class);
            this.logger.info(
                    String.format("Successfully parsed document: %s\n with id: %s", document.getTitle(), document.getId()));

            Path filePath = this.minioService.retrieveFile(document.getTitle());
            this.logger.info(String.format("File fetched from minIO and temporary stored in: %s", filePath));

            String parsedFileContent = this.ocrExecutorService.executeOcr(filePath.toFile());
            this.logger.info(String.format("File %s was successfully parsed.\n Content was: \n %s", filePath, parsedFileContent));

            documentDbStorageService.updateDocumentContent(document.getId(), parsedFileContent);
            this.logger.info(String.format("Successfully updated document content, for document id: %03d", document.getId()));

        } catch (Exception e) {
            this.logger
                    .error(String.format("An error occurred: %s\n", e));
        }

    }

}
