package util;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail {

	
	private static final String FROM = "weboglasnik64@gmail.com";
	private static final String USERNAME = "weboglasnik64@gmail.com";
	private static final String PASSWORD = "tetrapak";
	private static final String HOST = "smtp.gmail.com";
	private static final String PORT = "587";
	
	public static boolean sendMail(String receiver, String subject, String mailText) {
		try {
			Properties props = new Properties();
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", HOST);
			props.put("mail.smtp.port", PORT);

			Session session = Session.getInstance(props,
			  new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(USERNAME, PASSWORD);
				}
			 });
			
			MimeMessage mimeMsg= new MimeMessage(session);
			
			mimeMsg.setSubject(subject,"utf-8");
			mimeMsg.setContent(mailText, "text/plain; charset=utf-8");
			
			mimeMsg.setFrom(new InternetAddress(FROM));
			mimeMsg.setRecipients(Message.RecipientType.TO, receiver);
			
			Transport.send(mimeMsg);
			
			System.out.println("Message succesfully sent "+(new Date()));
			return true;
		} catch (Exception e) {
			System.out.println("Error occurred: " + e.getMessage()+" "+(new Date()));
			return false;
		}
		
		
	}
	
}
