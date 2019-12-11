
package com.novi.DiabloDemoDrop.utility;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author robert
 */
public class JavaMailUtil {
    
    public static void sendMail(String recepient) throws Exception {
        System.out.println("Preparing to send email");
        Properties properties = new Properties();
     
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        
        
        String myAccountEmail = "demodropapp@gmail.com";
        String password = "aH5C$bK*9lK";
                
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccountEmail, password);
            }
        });       
        
        Message message = prepareMessage(session, myAccountEmail, recepient);
        
        Transport.send(message);
        System.out.println("Message sent successfully");
    }
    
    private static Message prepareMessage(Session session, String myAccountEmail, String recepient) {
        try {
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(myAccountEmail));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
        message.setSubject("New Demo Drop!!");
        
        String htmlCode = "<h1>New Demo Drop</h1> <br/> <h2><b>Hi team, check the new demo now!!</b></h2>"
                + " <br/> <a href=\"https://www.dondiablo.com/\" target=\"_blank\"><h2><b>Check Demo</b></h2></a>";
        
        message.setContent(htmlCode, "text/html");
        return message;
        } catch (Exception ex) {
            // ....
        }
        return null;
    }
}
