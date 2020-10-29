package com.manage.mall.entitys;


public class Contract {

  private long cId;
  private String cOrder;
  private String cFileName;
  private String cPath;
  private java.sql.Timestamp cStartTime;
  private java.sql.Timestamp cEndTime;
  private long cSumTime;
  private double cMoney;
  private String cComment;
  private long cPayType;
  private long cState;
  private double cFixMoney;
  private long cDelete;
  private long rId;
  private long sId;
  private RentUser rentUser;

  public RentUser getRentUser() {
    return rentUser;
  }

  public void setRentUser(RentUser rentUser) {
    this.rentUser = rentUser;
  }

  public long getCId() {
    return cId;
  }

  public void setCId(long cId) {
    this.cId = cId;
  }


  public String getCOrder() {
    return cOrder;
  }

  public void setCOrder(String cOrder) {
    this.cOrder = cOrder;
  }


  public String getCFileName() {
    return cFileName;
  }

  public void setCFileName(String cFileName) {
    this.cFileName = cFileName;
  }


  public String getCPath() {
    return cPath;
  }

  public void setCPath(String cPath) {
    this.cPath = cPath;
  }


  public java.sql.Timestamp getCStartTime() {
    return cStartTime;
  }

  public void setCStartTime(java.sql.Timestamp cStartTime) {
    this.cStartTime = cStartTime;
  }


  public java.sql.Timestamp getCEndTime() {
    return cEndTime;
  }

  public void setCEndTime(java.sql.Timestamp cEndTime) {
    this.cEndTime = cEndTime;
  }


  public long getCSumTime() {
    return cSumTime;
  }

  public void setCSumTime(long cSumTime) {
    this.cSumTime = cSumTime;
  }


  public double getCMoney() {
    return cMoney;
  }

  public void setCMoney(double cMoney) {
    this.cMoney = cMoney;
  }


  public String getCComment() {
    return cComment;
  }

  public void setCComment(String cComment) {
    this.cComment = cComment;
  }


  public long getCPayType() {
    return cPayType;
  }

  public void setCPayType(long cPayType) {
    this.cPayType = cPayType;
  }


  public long getCState() {
    return cState;
  }

  public void setCState(long cState) {
    this.cState = cState;
  }


  public double getCFixMoney() {
    return cFixMoney;
  }

  public void setCFixMoney(double cFixMoney) {
    this.cFixMoney = cFixMoney;
  }


  public long getCDelete() {
    return cDelete;
  }

  public void setCDelete(long cDelete) {
    this.cDelete = cDelete;
  }


  public long getRId() {
    return rId;
  }

  public void setRId(long rId) {
    this.rId = rId;
  }


  public long getSId() {
    return sId;
  }

  public void setSId(long sId) {
    this.sId = sId;
  }

}
