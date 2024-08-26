package com.mail.sender;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class MailService {
   @Autowired
   private JavaMailSender mailSender;   

   public void mail(String to,String subject,String body ){

    SimpleMailMessage message= new SimpleMailMessage();
    message.setTo(to);
    message.setSubject(subject);
    message.setText(body);
    mailSender.send(message);
    System.out.println("sending");
     
   }
   public void mails(String to,String subject,String body,String attachment ) throws MessagingException{

   MimeMessage sender=mailSender.createMimeMessage();
   MimeMessageHelper helper=new MimeMessageHelper(sender,true);
   helper.setText(body);
   helper.setTo(to);
   helper.setSubject(subject);
   FileSystemResource res=new FileSystemResource(new File(attachment));
   helper.addAttachment(res.getFilename(), res);
   mailSender.send(sender);

    System.out.println("sending with attachment");
     
   }

   public void multiple(String[] to,String subject,String body,String attachment ) throws MessagingException{
      
   MimeMessage sender=mailSender.createMimeMessage();
   MimeMessageHelper helper=new MimeMessageHelper(sender,true);
   helper.setText(body);
   helper.setTo(to);
   helper.setSubject(subject);
   FileSystemResource res=new FileSystemResource(new File(attachment));
   helper.addAttachment(res.getFilename(), res);
   mailSender.send(sender);

    System.out.println("sending with attachment");


   }
}
