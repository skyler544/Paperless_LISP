package at.fhtw.swen3.paperless.ocr.services;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import at.fhtw.swen3.paperless.ocr.config.RabbitMQConfig;

@Component
public class ConsumerService {
    // TODO integrate Logger

    @RabbitListener(queues = RabbitMQConfig.PAPERLESS_REST_QUEUE)
    public void receive(String message) {
        try {
            System.out.println(String.format("Received a message over %s:\n%s",
                    RabbitMQConfig.PAPERLESS_REST_QUEUE, message));
        } catch (Exception e) {
            System.out.println(String.format("Error occurred: %s\n", e));
        }
    }
}
