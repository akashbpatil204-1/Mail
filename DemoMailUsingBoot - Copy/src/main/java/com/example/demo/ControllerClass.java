package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControllerClass {

	@Autowired
	private JavaMailSender javaMailSender;

	
	@RequestMapping("/")
	public String greet() {
		return "Mail.jsp";
	}
	
	@RequestMapping(value="/mail",method=RequestMethod.POST)
	public String mail(@RequestParam("email") String email) {
		System.out.println(email);
		sendEmail(email);
		return "sent.jsp";
	}
	
	public void sendEmail(String email) {
		// System.out.println("send Mail method");

		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo(email);
		msg.setSubject("OTP For Forgot Password");
		String otp = String.valueOf((long) (Math.random() * 9000) + 1000);
		msg.setText("Your OTP is :" + otp);

		javaMailSender.send(msg);

	}
}
