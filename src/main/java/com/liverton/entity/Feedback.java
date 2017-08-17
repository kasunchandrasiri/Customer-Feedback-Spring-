package com.liverton.entity;

//import org.springmodules.validation.bean.conf.loader.annotation.handler.Min;
//import org.springmodules.validation.bean.conf.loader.annotation.handler.NotNull;

public class Feedback {
	
	//@NotNull
	private String customerEmail;
	//@NotNull
	private String customerName;
	//@NotNull
	//@Min(10)
	private String customerPhoneNumber;
	//@NotNull
	private String customerFeedback;
	//@NotNull
	private String product ;
	
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerPhoneNumber() {
		return customerPhoneNumber;
	}
	public void setCustomerPhoneNumber(String customerPhoneNumber) {
		this.customerPhoneNumber = customerPhoneNumber;
	}
	public String getCustomerFeedback() {
		return customerFeedback;
	}
	public void setCustomerFeedback(String customerFeedback) {
		this.customerFeedback = customerFeedback;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}

	
}
