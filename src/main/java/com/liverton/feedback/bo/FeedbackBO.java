package com.liverton.feedback.bo;

public interface FeedbackBO {
	public void sendEmail(String customerEmail,String customerName, String customerPhoneNumber, String customerFeedback,String productName);
}
