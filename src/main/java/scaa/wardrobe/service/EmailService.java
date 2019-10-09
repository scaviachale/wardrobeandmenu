package scaa.wardrobe.service;

import scaa.wardrobe.model.WardrobeUser;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EmailService {

    public static void sendEmail(WardrobeUser wardrobeUser) {
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
            message.setSubject("Cloth saved successfully____");
            message.setText("Thank you " + customerName.toUpperCase()
                    + " for registering with us. Now you can start calculating and saving your financial projections,"
                    + " below is an attached pdf with tips to help you get started and about the application.");

            Transport.send(message);
            System.out.println("message sent successfully....");

        } catch (MessagingException mex) {
            throw new RuntimeException(mex);
        }

    }
}
