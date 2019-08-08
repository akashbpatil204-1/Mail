package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import javax.mail.MessagingException;

import java.io.IOException;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private JavaMailSender javaMailSender;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws MessagingException, IOException {

		System.out.println("Sending Email...");

		sendEmail();
		// sendEmailWithAttachment();

		System.out.println("OTP Sent");

	}

	void sendEmail() {
		// System.out.println("send Mail method");

		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo("divyasaivyshnavi.mamidi@publicissapient.com");
		msg.setSubject("OTP For Forgot Password");
		String otp = String.valueOf((long) (Math.random() * 9000) + 1000);
		msg.setText("Your OTP is :" + otp);

		javaMailSender.send(msg);

	}

}