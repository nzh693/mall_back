package com.manage.mall.entitys;


public class MallPaid {

  private long spId;
  private String spName;
  private double spAmount;
  private String spDesc;
  private java.sql.Timestamp spTime;
  private String spSpace;


  public long getSpId() {
    return spId;
  }

  public void setSpId(long spId) {
    this.spId = spId;
  }


  public String getSpName() {
    return spName;
  }

  public void setSpName(String spName) {
    this.spName = spName;
  }


  public double getSpAmount() {
    return spAmount;
  }

  public void setSpAmount(double spAmount) {
    this.spAmount = spAmount;
  }


  public String getSpDesc() {
    return spDesc;
  }

  public void setSpDesc(String spDesc) {
    this.spDesc = spDesc;
  }


  public java.sql.Timestamp getSpTime() {
    return spTime;
  }

  public void setSpTime(java.sql.Timestamp spTime) {
    this.spTime = spTime;
  }


  public String getSpSpace() {
    return spSpace;
  }

  public void setSpSpace(String spSpace) {
    this.spSpace = spSpace;
  }

  @Override
  public String toString() {
    return "MallPaid{" +
            "spId=" + spId +
            ", spName='" + spName + '\'' +
            ", spAmount=" + spAmount +
            ", spDesc='" + spDesc + '\'' +
            ", spTime=" + spTime +
            ", spSpace='" + spSpace + '\'' +
            '}';
  }
}
