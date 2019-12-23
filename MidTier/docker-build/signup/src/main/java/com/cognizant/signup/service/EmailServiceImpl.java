package com.cognizant.signup.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailServiceImpl implements EmailService{

	private JavaMailSender javaMailSender;
	 
    @Autowired
    public EmailServiceImpl(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }
	@Override
	public void send(String from, String to, String title, String body) {
		// TODO Auto-generated method stub
		System.out.println("email send start ****");
		MimeMessage message = this.javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(message);
        try {
            if (from != null) {
                mimeMessageHelper.setFrom(from);
            }
            mimeMessageHelper.setSubject(title);
            mimeMessageHelper.setText(body);
            mimeMessageHelper.setTo(to);
            this.javaMailSender.send(message);
        } catch (MessagingException messageException) {
           
            throw new RuntimeException(messageException);
        }
	}

}