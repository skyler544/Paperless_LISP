package at.fhtw.swen3.paperless.ocr.config;

import org.mockito.Mockito;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.context.annotation.*;

//An extra configuration for the testing spring boot context is required
//so that the "normal" config is not needed
@Profile("test")
@Configuration
@Import(RabbitMQConfig.class)
public class RabbitMockConfig {

    @Bean
    @Primary
    public AmqpAdmin amqpAdmin() {
        return Mockito.mock(AmqpAdmin.class);
    }

    @Bean
    @Primary
    public RabbitMessagingTemplate rabbitMessagingTemplate() {
        return Mockito.mock(RabbitMessagingTemplate.class);
    }

}
