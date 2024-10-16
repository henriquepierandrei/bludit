package com.pierandrei.bludit.Service;

import com.pierandrei.bludit.Model.User;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EmailService {
    private final JavaMailSender javaMailSender;


    public void sendEmail(String to, User userModel, UUID idCampaign) {
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setTo(userModel.getEmail());
            helper.setSubject("Recuperação de Senha!");


            String htmlContent = "";




            helper.setText(htmlContent, true);

            javaMailSender.send(message);

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

}
