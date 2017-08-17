package com.liverton.feedback.bo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.liverton.util.EmailSender;

@Service("feedbackBOImpl")
public class FeedbackBOImpl implements FeedbackBO {
	public void sendEmail(String customerEmail, String customerName, String customerPhoneNumber,
			String customerFeedback,String productName) {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Mail.xml");

		
		EmailSender emailSender = (EmailSender) context.getBean("emailSender");
		emailSender.sendMail(customerEmail, customerName, customerPhoneNumber, customerFeedback,productName);
	}
}
