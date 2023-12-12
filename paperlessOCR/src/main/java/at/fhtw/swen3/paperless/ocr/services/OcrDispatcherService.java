package at.fhtw.swen3.paperless.ocr.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import at.fhtw.swen3.paperless.ocr.config.RabbitMQConfig;
import at.fhtw.swen3.paperless.ocr.entities.DocumentEntity;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Service
public class OcrDispatcherService {
    Logger logger = LogManager.getLogger(OcrDispatcherService.class);

    private final MinioService minioService;

    public OcrDispatcherService(MinioService minioService) {
        this.minioService = minioService;
    }

    public void handleMessage(String message) {
        // deserialize message
        DocumentEntity document;
        var om = new ObjectMapper();
        try {
            document = om.readValue(message, DocumentEntity.class);
            this.logger.info(
                String.format("Successfully parsed document: %s\n", document.getTitle()));

        this.minioService.retrieveFile(document.getTitle());
        } catch (Exception e) {
            this.logger
                .error(String.format("An error occurred: %s\n", e));
        }
        // TODO run OCR job
        // TODO persist content in the entity
    }
}
