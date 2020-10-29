package com.manage.mall.entitys;


public class Recruit {

  private long rId;
  private String rTitle;
  private String rDesc;
  private java.sql.Timestamp rEndTime;
  private String rPhone;
  private long sId;


  public long getRId() {
    return rId;
  }

  public void setRId(long rId) {
    this.rId = rId;
  }


  public String getRTitle() {
    return rTitle;
  }

  public void setRTitle(String rTitle) {
    this.rTitle = rTitle;
  }


  public String getRDesc() {
    return rDesc;
  }

  public void setRDesc(String rDesc) {
    this.rDesc = rDesc;
  }


  public java.sql.Timestamp getREndTime() {
    return rEndTime;
  }

  public void setREndTime(java.sql.Timestamp rEndTime) {
    this.rEndTime = rEndTime;
  }


  public String getRPhone() {
    return rPhone;
  }

  public void setRPhone(String rPhone) {
    this.rPhone = rPhone;
  }


  public long getSId() {
    return sId;
  }

  public void setSId(long sId) {
    this.sId = sId;
  }

}
