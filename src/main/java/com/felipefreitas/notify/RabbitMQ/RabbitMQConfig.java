package com.felipefreitas.notify.RabbitMQ;

import org.hibernate.type.format.jackson.Jackson3JsonFormatMapper;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue enviarEmailQueue() {
        return new Queue("enviar-email-queue", true);
    }

    @Bean
    public Jackson3JsonFormatMapper jackson3JsonFormatMapper() {
        return new Jackson3JsonFormatMapper();
    }

}
