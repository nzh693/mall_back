package com.manage.mall.service.imp;

import com.manage.mall.service.IEmailService;
import com.manage.mall.vo.Email;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;


@Service
public class EmailServiceImp implements IEmailService {


    private Logger logger= LoggerFactory.getLogger(EmailServiceImp.class);

    @Autowired
    JavaMailSenderImpl mailSender;//简单邮件发送    

    @Override
    public void sendSimpleMail(Email email) {
        MimeMessage message=mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper=new MimeMessageHelper(message,true);
            helper.setSubject(email.getTilte());//设置标题
            helper.setText(email.getBody() ,true);//是否为html
            helper.setTo(email.getReceiveEmail());//发送方
            helper.setFrom(email.getSenderEmail());//接收方
        } catch (MessagingException e) {
            logger.error("sendSimpleMail：邮件发送失败"+e);
        }
        mailSender.send(message);
    }


    // 带附件的邮件发送
    @Override
    public  void sendEmaliWithAttachment(Email email) throws MessagingException {
        MimeMessage message=mailSender.createMimeMessage();
        MimeMessageHelper helper=new MimeMessageHelper(message,true);
        helper.setSubject(email.getTilte());//设置标题
        helper.setText(email.getBody() ,true);//是否为html
        helper.setTo(email.getReceiveEmail());//发送方
        helper.setFrom(email.getSenderEmail());//接收方
        helper.addAttachment("这是证据.jpg",email.getFile());//添加附件 可以文件或者文件流
        mailSender.send(message);
    }
}
