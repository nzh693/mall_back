package com.manage.mall.entitys;


public class Manager {

  private long mId;
  private String mName;
  private java.sql.Timestamp mStartTime;
  private java.sql.Timestamp mEndTime;
  private double mSalary;
  private long mClerkCount;
  private String mEmallAddress;
  private String mPassword;
  private long mPower;


  public long getMId() {
    return mId;
  }

  public void setMId(long mId) {
    this.mId = mId;
  }


  public String getMName() {
    return mName;
  }

  public void setMName(String mName) {
    this.mName = mName;
  }


  public java.sql.Timestamp getMStartTime() {
    return mStartTime;
  }

  public void setMStartTime(java.sql.Timestamp mStartTime) {
    this.mStartTime = mStartTime;
  }


  public java.sql.Timestamp getMEndTime() {
    return mEndTime;
  }

  public void setMEndTime(java.sql.Timestamp mEndTime) {
    this.mEndTime = mEndTime;
  }


  public double getMSalary() {
    return mSalary;
  }

  public void setMSalary(double mSalary) {
    this.mSalary = mSalary;
  }


  public long getMClerkCount() {
    return mClerkCount;
  }

  public void setMClerkCount(long mClerkCount) {
    this.mClerkCount = mClerkCount;
  }


  public String getMEmallAddress() {
    return mEmallAddress;
  }

  public void setMEmallAddress(String mEmallAddress) {
    this.mEmallAddress = mEmallAddress;
  }


  public String getMPassword() {
    return mPassword;
  }

  public void setMPassword(String mPassword) {
    this.mPassword = mPassword;
  }


  public long getMPower() {
    return mPower;
  }

  public void setMPower(long mPower) {
    this.mPower = mPower;
  }

}
