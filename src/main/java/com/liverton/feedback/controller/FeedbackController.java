package com.liverton.feedback.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.liverton.entity.Feedback;
import com.liverton.entity.Product;
import com.liverton.feedback.bo.FeedbackBO;

@Controller
public class FeedbackController {

	@Autowired
	private FeedbackBO feedbackBO;

	@ModelAttribute("allProducts")
	public List<Product> populateProducts(){
		return Arrays.asList(Product.ALL);
	}
	
	@RequestMapping(value = { "/", "/welcome**" })
	public String defaultPage(ModelMap model) {
		Feedback feedback = new Feedback();
		model.addAttribute("feedback", feedback);
		return "/feedback";

	}

	@RequestMapping(value = "/submitFeedback", params = { "send" })
	public String submitFeedback(@ModelAttribute Feedback feedback,ModelMap model) {
		 feedbackBO.sendEmail(feedback.getCustomerEmail(),feedback.getCustomerName(),feedback.getCustomerPhoneNumber(),feedback.getCustomerFeedback(),feedback.getProduct());
		feedback = new Feedback();
		model.addAttribute("feedback", feedback);
		model.addAttribute("successMsg", "Thank you for the feedback");
		return "/feedback";
	}
}
