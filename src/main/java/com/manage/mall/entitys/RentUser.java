package com.manage.mall.entitys;


public class RentUser {

  private long rId;
  private String rName;
  private String rPhone;
  private String rEmailAddress;
  private String rPassword;
  private long rPower;
  private long sId;
  private long cId;


  public long getRId() {
    return rId;
  }

  public void setRId(long rId) {
    this.rId = rId;
  }


  public String getRName() {
    return rName;
  }

  public void setRName(String rName) {
    this.rName = rName;
  }


  public String getRPhone() {
    return rPhone;
  }

  public void setRPhone(String rPhone) {
    this.rPhone = rPhone;
  }


  public String getREmailAddress() {
    return rEmailAddress;
  }

  public void setREmailAddress(String rEmailAddress) {
    this.rEmailAddress = rEmailAddress;
  }


  public String getRPassword() {
    return rPassword;
  }

  public void setRPassword(String rPassword) {
    this.rPassword = rPassword;
  }


  public long getRPower() {
    return rPower;
  }

  public void setRPower(long rPower) {
    this.rPower = rPower;
  }


  public long getSId() {
    return sId;
  }

  public void setSId(long sId) {
    this.sId = sId;
  }


  public long getCId() {
    return cId;
  }

  public void setCId(long cId) {
    this.cId = cId;
  }

  @Override
  public String toString() {
    return "RentUser{" +
            "rId=" + rId +
            ", rName='" + rName + '\'' +
            ", rPhone='" + rPhone + '\'' +
            ", rEmailAddress='" + rEmailAddress + '\'' +
            ", rPassword='" + rPassword + '\'' +
            ", rPower=" + rPower +
            ", sId=" + sId +
            ", cId=" + cId +
            '}';
  }
}
