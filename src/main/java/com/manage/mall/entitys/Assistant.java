package com.manage.mall.entitys;


public class Assistant {

  private long aId;
  private String aName;
  private double aSalary;
  private String aJobDesc;
  private String aJobName;
  private String aPhone;
  private String aEmallAddress;
  private long mId;
  private long sId;


  public long getAId() {
    return aId;
  }

  public void setAId(long aId) {
    this.aId = aId;
  }


  public String getAName() {
    return aName;
  }

  public void setAName(String aName) {
    this.aName = aName;
  }


  public double getASalary() {
    return aSalary;
  }

  public void setASalary(double aSalary) {
    this.aSalary = aSalary;
  }


  public String getAJobDesc() {
    return aJobDesc;
  }

  public void setAJobDesc(String aJobDesc) {
    this.aJobDesc = aJobDesc;
  }


  public String getAJobName() {
    return aJobName;
  }

  public void setAJobName(String aJobName) {
    this.aJobName = aJobName;
  }


  public String getAPhone() {
    return aPhone;
  }

  public void setAPhone(String aPhone) {
    this.aPhone = aPhone;
  }


  public String getAEmallAddress() {
    return aEmallAddress;
  }

  public void setAEmallAddress(String aEmallAddress) {
    this.aEmallAddress = aEmallAddress;
  }


  public long getMId() {
    return mId;
  }

  public void setMId(long mId) {
    this.mId = mId;
  }


  public long getSId() {
    return sId;
  }

  public void setSId(long sId) {
    this.sId = sId;
  }

  @Override
  public String toString() {
    return "Assistant{" +
            "aId=" + aId +
            ", aName='" + aName + '\'' +
            ", aSalary=" + aSalary +
            ", aJobDesc='" + aJobDesc + '\'' +
            ", aJobName='" + aJobName + '\'' +
            ", aPhone='" + aPhone + '\'' +
            ", aEmallAddress='" + aEmallAddress + '\'' +
            ", mId=" + mId +
            ", sId=" + sId +
            '}';
  }
}
