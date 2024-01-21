package at.fhtw.swen3.paperless.ocr.services;

import at.fhtw.swen3.paperless.ocr.config.RabbitMQConfig;
import at.fhtw.swen3.paperless.ocr.services.interfaces.DispatcherService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {
    final Logger logger = LogManager.getLogger(ConsumerService.class);

    private final DispatcherService dispatcherService;

    public ConsumerService(DispatcherService dispatcherService) {
        this.dispatcherService = dispatcherService;
    }

    @RabbitListener(queues = RabbitMQConfig.PAPERLESS_REST_QUEUE)
    public void receive(String message) {
        this.logger.info(String.format("Received a message over %s:\n%s",
            RabbitMQConfig.PAPERLESS_REST_QUEUE, message));

        dispatcherService.handleMessage(message);
    }
}
