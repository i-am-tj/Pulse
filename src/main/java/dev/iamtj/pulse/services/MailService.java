package dev.iamtj.pulse.services;

import dev.iamtj.pulse.exceptions.SpringPulseException;
import dev.iamtj.pulse.models.Notification;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class MailService {
    private final JavaMailSender mailSender;
    private final MailContentBuilder mailContentBuilder;

    @Async
    public void sendMail(Notification notification) {
        MimeMessagePreparator messagePreparator = mimeMessage -> {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
            messageHelper.setFrom("pulse-org@gmail.com");
            messageHelper.setTo(notification.getRecipient());
            messageHelper.setSubject(notification.getSubject());
            messageHelper.setText(mailContentBuilder.build(notification.getBody()));
        };
        try {
            mailSender.send(messagePreparator);
            log.info("Activation email sent");
        } catch (MailException e) {
            throw new SpringPulseException("Exception occurred while sending mail to " + notification.getRecipient());
        }
    }
}
