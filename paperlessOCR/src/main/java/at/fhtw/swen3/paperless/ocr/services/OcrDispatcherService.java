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

    public void handleMessage(String message) {
        // deserialize message
        var om = new ObjectMapper();
        try {
            var document = om.readValue(message, DocumentEntity.class);
            this.logger.info(
                String.format("Successfully parsed document: %s\n", document.getTitle()));
        } catch (JsonProcessingException e) {
            this.logger
                .error(String.format("Could not parse document object, aborting.\n%s", e));
        }
        // log stuff
        // run OCR job
        // when it's done, persist the new content in the entity
    }
}
