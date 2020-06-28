package scaa.wardrobe.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import scaa.wardrobe.commons.exception.CouldNotSendMessageException;
import scaa.wardrobe.model.WardrobeUser;
import scaa.wardrobe.service.WardrobeServiceInterface;
import scaa.wardrobe.service.WardrobeUserServiceInterface;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.List;
import java.util.Properties;

@Service
public class EmailService {
    @Autowired
    private WardrobeServiceInterface wardrobeServiceInterface;

    @Autowired
    private WardrobeUserServiceInterface wardrobeUserServiceInterface;

    private List<WardrobeUser> getEmails() {
        return wardrobeUserServiceInterface.getUsers();
    }

    private Properties emailSetUp() {
        Properties prop = new Properties();
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.starttls.required", "false");
        prop.put("mail.transport.protocol", "smtp");
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("username", "scaviacmhlanga@gmail.com");
        prop.put("password", "rumbiescar11");

        return prop;
    }

    @Transactional
    public void sendEmail() {
        Session session = Session.getInstance(emailSetUp(),
                new SMTPAuthenticator(emailSetUp().getProperty("username"), emailSetUp().getProperty("password")));

        for (WardrobeUser wardrobeUser : getEmails()) {
            try {
                MimeMessage message = new MimeMessage(session);
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(wardrobeUser.getEmail()));
                message.setSubject(EmailType.NOTIFICATION);
                message.setText("Hello " + wardrobeUser.getUsername().toUpperCase()
                        + ", " + EmailType.NOTIFICATION_MESSAGE_BODY);

                Transport.send(message);
            } catch (MessagingException mex) {
                throw new CouldNotSendMessageException("An error occured please contact admin", mex);
            }
        }

    }
}
