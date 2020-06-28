package scaa.wardrobe.email;

import org.springframework.stereotype.Service;
import scaa.wardrobe.model.WardrobeUser;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Service
public class EmailService {

    public void sendEmail(WardrobeUser wardrobeUser, EmailType emailType) {
        String username = "scaviacmhlanga@gmail.com";
        String password = "rumbiescar11";
        String to = wardrobeUser.getEmail();
        String customerName = wardrobeUser.getUsername();

        Properties prop = new Properties();
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.starttls.required", "false");
        prop.put("mail.transport.protocol", "smtp");
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");

        Session session = Session.getInstance(prop, new SMTPAuthenticator(username, password));

        try {
            MimeMessage message = new MimeMessage(session);
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(emailType.NOTIFICATION);
            message.setText("Hello " + customerName.toUpperCase()
                    + ", "+ emailType.NOTIFICATION_MESSAGE_BODY);

            Transport.send(message);
            System.out.println("message sent successfully....");

        } catch (MessagingException mex) {
            throw new RuntimeException(mex);
        }

    }
}
