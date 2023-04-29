package com.api.stock.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class RecuperarSenhaServiceTest {

    @Mock
    private JavaMailSenderImpl mailSender;

    @InjectMocks
    private RecuperarSenhaService passwordRecoveryService;
    @BeforeEach
    void initMocks() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    public void testSendPasswordRecoveryEmail() {
        String toEmail = "test@example.com";
        String subject = "Test email";
        String messageBody = "Test message";

        ReflectionTestUtils.setField(passwordRecoveryService, "fromEmail", "from@example.com");
        ReflectionTestUtils.setField(passwordRecoveryService, "fromSenha", "password");


        assertDoesNotThrow(()-> passwordRecoveryService.sendPasswordRecoveryEmail(toEmail, subject, messageBody));



    }
}
