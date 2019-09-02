package scaa.wardrobe.service;

import org.springframework.stereotype.Service;
import scaa.wardrobe.model.User;

import javax.annotation.Resource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Service
public class EmailService {

    @Resource(name = "java:/jboss/mail/gmail")
    private Session session;

    public void thankYouForRegistering(User user) {
        String to = user.getEmail();
        String username = user.getUsername();

        // compose the message
        try {
            MimeMessage message = new MimeMessage(session);
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("Registration successful");
            message.setText("Thank you " + username.toUpperCase()
                    + " for registering on WardrobeandMenu system. Now you can start keeping track of your clothes and checking daily tips on what to wear from your wardrobe,"
                    + " below is an attached pdf with tips to help you get started and about the application.");

            // Send message
            Transport.send(message);
            System.out.println("message sent successfully....");

        } catch (MessagingException mex) {
            throw new RuntimeException(mex);
        }
    }

    public void clothingAddedNotification(User user) {
        String to = user.getEmail();
        String username = user.getUsername();

        // compose the message
        try {
            MimeMessage message = new MimeMessage(session);
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("Clothing successfully added");
            message.setText("Thank you " + username.toUpperCase()
                    + " for registering on WardrobeandMenu system. Now you can start keeping track of your clothes and checking daily tips on what to wear from your wardrobe,"
                    + " below is an attached pdf with tips to help you get started and about the application.");

            // Send message
            Transport.send(message);
            System.out.println("message sent successfully....");

        } catch (MessagingException mex) {
            throw new RuntimeException(mex);
        }
    }
}
