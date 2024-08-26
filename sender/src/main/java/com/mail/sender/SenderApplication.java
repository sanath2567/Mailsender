package com.mail.sender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import jakarta.mail.MessagingException;

@SpringBootApplication
public class SenderApplication {

	@Autowired
	private MailService mailService;

	public static void main(String[] args) {
		SpringApplication.run(SenderApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void trigger() throws MessagingException {
		// mailService.mail("sriramsanath002@gmail.com", "springmailsender", "spring
		// boot mail server sender");
		// mailService.mails("sriramsanath002@gmail.com", "springmailsenderattachment",
		// "spring boot mail server sender attachment",
		// "c://Users//Dell//Downloads//WhatsApp Image 2024-08-20 at 8.41.10 PM.jpeg");

		String[] to = { "sriramsanath002@gmail.com", "sriramsanath842@gmail.com" };
		String subject = "Subject: SpringBoot Application";
		String text = "This email is sent to multiple recipients when the application is ready.";
		String attachment = "c://Users//Dell//Downloads//demofile.jpg";

		try {
			mailService.multiple(to, subject, text, attachment);
			System.out.println("Email sent successfully to multiple recipients.");
		} catch (MessagingException e) {
			e.printStackTrace();
			System.out.println("Error while sending email.");
		}

	}

	

}
