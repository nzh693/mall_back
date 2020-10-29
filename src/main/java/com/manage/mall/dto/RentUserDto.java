package com.manage.mall.dto;

public class RentUserDto {


    private long rId;
    private String rName;
    private String rEmailAddress;
    private String rPhone;
    private long sId;
    private long cId;
    private String rPower;

    public long getrId() {
        return rId;
    }

    public void setrId(long rId) {
        this.rId = rId;
    }

    public String getrName() {
        return rName;
    }

    public void setrName(String rName) {
        this.rName = rName;
    }

    public String getrEmailAddress() {
        return rEmailAddress;
    }

    public void setrEmailAddress(String rEmailAddress) {
        this.rEmailAddress = rEmailAddress;
    }

    public String getrPhone() {
        return rPhone;
    }

    public void setrPhone(String rPhone) {
        this.rPhone = rPhone;
    }

    public long getsId() {
        return sId;
    }

    public void setsId(long sId) {
        this.sId = sId;
    }

    public long getcId() {
        return cId;
    }

    public void setcId(long cId) {
        this.cId = cId;
    }

    public String getrPower() {
        return rPower;
    }

    public void setrPower(String rPower) {
        this.rPower = rPower;
    }
}
