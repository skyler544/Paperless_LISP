package at.fhtw.swen3.paperless.ocr.services;

import at.fhtw.swen3.paperless.ocr.entities.DocumentEntity;
import at.fhtw.swen3.paperless.ocr.services.interfaces.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.nio.file.Path;

@Service
public class OcrDispatcherService implements DispatcherService {
    Logger logger = LogManager.getLogger(OcrDispatcherService.class);

    private final DocumentStoreService minioService;

    private final OcrExecutorService ocrExecutorService;

    private final DocumentDbStorageService documentDbStorageService;

    private final SearchService searchService;

    public OcrDispatcherService(DocumentStoreService minioService, TesseractService tesseractService, DocumentPostgresService documentPostgresService, SearchService searchService) {
        this.minioService = minioService;
        this.ocrExecutorService = tesseractService;
        this.documentDbStorageService = documentPostgresService;
        this.searchService = searchService;
    }

    @Override
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
            //we update the document with the new content, so that the search service can store it
            document.setContent(parsedFileContent);
            this.logger.info(String.format("File %s was successfully parsed.\n Content was: \n %s", filePath, parsedFileContent));

            documentDbStorageService.updateDocumentContent(document.getId(), parsedFileContent);
            this.logger.info(String.format("Successfully updated document content, for document id: %03d", document.getId()));

            searchService.indexDocument(document);
            this.logger.info(String.format("Successfully indexed document in search db with id: %03d", document.getId()));

        } catch (Exception e) {
            this.logger
                    .error(String.format("An error occurred: %s\n", e));
        }

    }

}
