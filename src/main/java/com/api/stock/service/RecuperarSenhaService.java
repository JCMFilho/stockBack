package com.api.stock.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service
public class RecuperarSenhaService {

    @Value("${acesso.email}")
    private String fromEmail;
    @Value("${acesso.senha}")
    private String fromSenha;
    private final SimpleMailMessage message;

    public RecuperarSenhaService() {

        this.message = new SimpleMailMessage();
    }

    public void sendPasswordRecoveryEmail(String toEmail, String subject, String messageBody) {
        try {
            JavaMailSenderImpl mailSender = buildMailSender();
            message.setTo(toEmail);
            message.setSubject(subject);
            message.setText(messageBody);
            mailSender.send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private JavaMailSenderImpl buildMailSender(){
        System.out.println(fromEmail);
        System.out.println(fromSenha);
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);
        mailSender.setUsername(fromEmail);
        mailSender.setPassword(fromSenha);

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");
        return mailSender;
    }
}
