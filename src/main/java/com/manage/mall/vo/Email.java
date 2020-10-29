package com.manage.mall.vo;

import java.io.File;


public class Email {

    private String tilte;
    private String body;
    private String senderEmail;
    private String receiveEmail;
    private File file;
    private static Email email=null;

    private static final String PUBLIC_EMAIL="mall_666_nzh@163.com";

    private Email(){};

    public static synchronized Email buildSystemEmail(String tilte,String text,String receiveEmail){

         synchronized (Email.class){
             if (email==null){
                 email=new Email();
             }
         }
        email.setSenderEmail(PUBLIC_EMAIL);
        email.setTilte(tilte);
        email.setBody(text);
        email.setReceiveEmail(receiveEmail);
        return email;
    }


    public static synchronized Email buildSystemEmailWithFile(String tilte,String text,String receiveEmail,File file){
        synchronized (Email.class){
            if (email==null){
                email=new Email();
            }
        }
        email.setSenderEmail(PUBLIC_EMAIL);
        email.setTilte(tilte);
        email.setBody(text);
        email.setReceiveEmail(receiveEmail);
        email.setFile(file);
        return email;
    }

    public String getTilte() {
        return tilte;
    }

    public void setTilte(String tilte) {
        this.tilte = tilte;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getSenderEmail() {
        return senderEmail;
    }

    public void setSenderEmail(String senderEmail) {
        this.senderEmail = senderEmail;
    }

    public String getReceiveEmail() {
        return receiveEmail;
    }

    public void setReceiveEmail(String receiveEmail) {
        this.receiveEmail = receiveEmail;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    @Override
    public String toString() {
        return "Email{" +
                "tilte='" + tilte + '\'' +
                ", body='" + body + '\'' +
                ", senderEmail='" + senderEmail + '\'' +
                ", receiveEmail='" + receiveEmail + '\'' +
                ", file=" + file +
                '}';
    }
}
