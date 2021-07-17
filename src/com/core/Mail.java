package com.core;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

public class Mail {
	
	public static void sendMail(String bodyofmail,String AdressMail) throws MessagingException {
		final String username = "jeudiuspouchon@gmail.com";
		final String password = "pouchy1234";
		String fromEmail = "jeudiuspouchon@gmail.com";
		String toEmail = AdressMail;
		
		Properties properties = new Properties();
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
		
		Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username,password);
			}
		});
		
		MimeMessage msg = new MimeMessage(session);
		
		try {
			msg.setFrom(new InternetAddress(fromEmail));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
			msg.setSubject("Subject");
			msg.setText(bodyofmail);
			Transport.send(msg);
			JOptionPane.showMessageDialog(null,"Mail send with success to : "+AdressMail);
		} catch (MessagingException e) {
			JOptionPane.showMessageDialog(null,"Mail error");
		}
	}

	

	
	

	
	
	 
}
