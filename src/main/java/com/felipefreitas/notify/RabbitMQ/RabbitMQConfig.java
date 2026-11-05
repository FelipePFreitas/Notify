package com.felipefreitas.notify.RabbitMQ;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.JacksonJsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue enviarEmailQueue() {
        return new Queue("enviar-email-queue", true);
    }

    @Bean
       public MessageConverter messageConverter() {
           // Este é o cara que dita para o RabbitTemplate e @RabbitListener: "usem JSON!"
           return new JacksonJsonMessageConverter();
       }

}
