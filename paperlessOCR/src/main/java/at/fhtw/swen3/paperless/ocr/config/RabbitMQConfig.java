package at.fhtw.swen3.paperless.ocr.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
    public static final String PAPERLESS_REST_QUEUE = "PAPERLESS_REST";

    @Bean
    public Queue paperlessQueue() {
        return new Queue(PAPERLESS_REST_QUEUE, false);
    }

    @Value("${paperless.rabbitMq.username}")
    private String rabbitMqUsername;

    @Value("${paperless.rabbitMq.password}")
    private String rabbitMqPwd;


    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory("rabbitmq");
        connectionFactory.setUsername(this.rabbitMqUsername);
        connectionFactory.setPassword(this.rabbitMqPwd);
        return connectionFactory;
    }

    @Bean
    public RabbitTemplate rabbitTemplate() {
        return new RabbitTemplate(connectionFactory());
    }
}
