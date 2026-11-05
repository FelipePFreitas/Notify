package com.felipefreitas.notify.mail;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service

public class JavaEmailService {

    private final MailSender mailSender;
    private final String remetente;

    public JavaEmailService(MailSender mailSender,
                            @Value(("${spring.mail.username}"))
                            String remetente) {
        this.mailSender = mailSender;
        this.remetente = remetente;
    }

    @RabbitListener(queues = "enviar-email-queue")
    public void enivarEmail(String email) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(remetente);
        message.setTo(email);
        message.setSubject("Cadastro realizado com sucesso !!");
        message.setText("Seu cadastro foi realizado com sucesso, seja bem vindo a nossa plataforma");
        mailSender.send(message);
    }
}
