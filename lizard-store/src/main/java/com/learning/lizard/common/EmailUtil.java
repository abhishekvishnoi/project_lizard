package com.learning.lizard.common;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailUtil {

	@Autowired
	private JavaMailSender mailSender;

	public String doSendEmail(HttpServletRequest request) {

		// takes input from e-mail form
		String recipientAddress = "abhishek.vishnoi@accenture.com";

		String subject = "subject test 1";

		String message1 = "This is a test message";

		SimpleMailMessage email = new SimpleMailMessage();

		email.setTo(recipientAddress); 
		email.setSubject(subject);
		email.setText(message1);


		 // sends the e-mail
        mailSender.send(email);
		

		// prints debug info
		System.out.println("To: " + recipientAddress);
		System.out.println("Subject: " + subject);
		System.out.println("Message: " + message1);

		// forwards to the view named "Result"
		return "Result";
	}

}
