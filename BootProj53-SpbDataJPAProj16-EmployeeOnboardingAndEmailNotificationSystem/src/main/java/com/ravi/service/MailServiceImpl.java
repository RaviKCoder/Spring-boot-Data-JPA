package com.ravi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ravi.entity.Employee;

@Component
public class MailServiceImpl implements IMailService {

	@Autowired
	private JavaMailSender mailSender;
	
	@Override
	public void sendMail(Employee emp) {
		
		String to=emp.getEmail();
		String subject="Welcome to the Company";
		String body=""" 
					
				Hello %s	
				Welcome to  %s department.
				We are glad to have you onboard!
				HR Team
				
				""".formatted(emp.getName(),emp.getDepartment());
		
		SimpleMailMessage mailMessage=new SimpleMailMessage();
		mailMessage.setTo(to);
		mailMessage.setSubject(subject);
		mailMessage.setText(body);
		
		mailSender.send(mailMessage);

	}

}
