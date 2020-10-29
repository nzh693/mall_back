package com.manage.mall.entitys;


public class FinancialShop {

  private long fId;
  private java.sql.Timestamp fStartTime;
  private java.sql.Timestamp fEndTime;
  private double fOutMoney;
  private double fSale;
  private double fProfit;
  private long sId;


  public long getFId() {
    return fId;
  }

  public void setFId(long fId) {
    this.fId = fId;
  }


  public java.sql.Timestamp getFStartTime() {
    return fStartTime;
  }

  public void setFStartTime(java.sql.Timestamp fStartTime) {
    this.fStartTime = fStartTime;
  }


  public java.sql.Timestamp getFEndTime() {
    return fEndTime;
  }

  public void setFEndTime(java.sql.Timestamp fEndTime) {
    this.fEndTime = fEndTime;
  }


  public double getFOutMoney() {
    return fOutMoney;
  }

  public void setFOutMoney(double fOutMoney) {
    this.fOutMoney = fOutMoney;
  }


  public double getFSale() {
    return fSale;
  }

  public void setFSale(double fSale) {
    this.fSale = fSale;
  }


  public double getFProfit() {
    return fProfit;
  }

  public void setFProfit(double fProfit) {
    this.fProfit = fProfit;
  }


  public long getSId() {
    return sId;
  }

  public void setSId(long sId) {
    this.sId = sId;
  }

}
