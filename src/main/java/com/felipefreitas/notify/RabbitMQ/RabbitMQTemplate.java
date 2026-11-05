package com.felipefreitas.notify.RabbitMQ;

import com.felipefreitas.notify.dto.ClientEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
@RequiredArgsConstructor
public class RabbitMQTemplate {
    private final RabbitTemplate rabbitTemplate;

    @Async
    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void handleClienteCriadoEvent(ClientEvent dto) {
        rabbitTemplate.convertAndSend("enviar-email-queue", dto.email());
    }
}
