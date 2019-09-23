package scaa.wardrobe.service;

import javax.mail.Session;
import java.util.Properties;

public class EmailService {

    public void thankYouForRegistering() {
        String sender = "scaviacmhlanga@gmail.com";
        String username = "scaviacmhlanga@gmail.com";
        String password = "rumbiescar11";

        Properties prop = new Properties();
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "false");
        prop.put("mail.smtp.starttls.required", "false");
        prop.put("mail.transport.protocol", "smtp");
        prop.put("mail.smtp.host", "gmail.com");
        prop.put("mail.smtp.port", "");

        Session session = Session.getInstance(prop, new SMTPAuthenticator(username,password));


    }
}
