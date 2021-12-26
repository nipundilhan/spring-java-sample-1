package com.example.EmailTest1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SendEmailService {
	
    @Autowired
    JavaMailSender mailSender;
    
	public void sendEmail() {
		System.out.println("sending mail");
		SimpleMailMessage mailToBeSend = new SimpleMailMessage();
		mailToBeSend.setFrom("dilhanajmn@12gmail.com");
		mailToBeSend.setTo("nipundilhanjayarathne@gmail.com");
		mailToBeSend.setSubject("test mail");
		mailToBeSend.setText("this is test mail");
		mailSender.send(mailToBeSend);
		System.out.println("mail send");
	}

}
