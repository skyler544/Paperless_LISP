package at.fhtw.swen3.paperless.services.messageQueue;

import at.fhtw.swen3.paperless.config.RabbitMQConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQService implements MessageQueueService {

    private final RabbitTemplate rabbit;

    private final Logger logger = LogManager.getLogger(RabbitMQService.class);

    @Autowired
    public RabbitMQService(RabbitTemplate rabbit) {
        this.rabbit = rabbit;
    }

    public void processMessage(String message) {

        rabbit.convertAndSend(RabbitMQConfig.PAPERLESS_REST_QUEUE, message);
        logger.info(String.format("[ Sent message to %s]", message));
    }

}
