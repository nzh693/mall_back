package com.manage.mall.entitys;

/**
 * 账户
 */
public class Acount {

    private String acount;
    private String password;
    private String email;
    private String type;
    private String power;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public Acount(String acount, String password) {
        this.acount = acount;
        this.password = password;
    }

    public String getAcount() {
        return acount;
    }

    public void setAcount(String acount) {
        this.acount = acount;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Acount{" +
                "acount='" + acount + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", type='" + type + '\'' +
                ", power='" + power + '\'' +
                '}';
    }
}
