package com.liverton.util;

import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

public class EmailSender {
	private MailSender mailSender;
	private SimpleMailMessage simpleMailMessage;
	
	public void setSimpleMailMessage(SimpleMailMessage simpleMailMessage) {
		this.simpleMailMessage = simpleMailMessage;
	}

	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}
	
	public void sendMail(String customerName, String customerEmail,String customerPhoneNumber, String customerFeedback,String productName) {

		SimpleMailMessage message = new SimpleMailMessage(simpleMailMessage);
		
		message.setText(String.format(
				simpleMailMessage.getText(),productName, customerName, customerEmail,customerPhoneNumber,customerFeedback));

		mailSender.send(message);
		
	}
}
