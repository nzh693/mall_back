package com.manage.mall.service;

import com.manage.mall.vo.Email;

import javax.mail.MessagingException;

public interface IEmailService {

    /**
     * 发送邮件（不带附件）
     * @param email
     */
    public void sendSimpleMail(Email email);

    /**
     * 带附件的发送
     * @param email
     * @throws MessagingException
     */
    public  void sendEmaliWithAttachment(Email email) throws MessagingException;
}
