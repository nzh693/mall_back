package com.manage.mall.entitys;

import com.manage.mall.dto.ContractDto;
import com.manage.mall.dto.RentUserDto;

public class Shop {

  private long sId;
  private String sName;
  private String sOrder;
  private long sFloor;
  private double sSize;
  private long sState;
  private long sClerkCount;
  private long srCode;
  private double sPrice;//预售价
  private double sDealPrice;//成交价
  private long rId;
  private long cId;
  private RentUserDto rentUser;
  private ContractDto contract;

  public RentUserDto getRentUser() {
    return rentUser;
  }

  public void setRentUser(RentUserDto rentUser) {
    this.rentUser = rentUser;
  }

  public ContractDto getContract() {
    return contract;
  }

  public void setContract(ContractDto contract) {
    this.contract = contract;
  }

  public long getSId() {
    return sId;
  }

  public void setSId(long sId) {
    this.sId = sId;
  }


  public String getSName() {
    return sName;
  }

  public void setSName(String sName) {
    this.sName = sName;
  }


  public String getSOrder() {
    return sOrder;
  }

  public void setSOrder(String sOrder) {
    this.sOrder = sOrder;
  }


  public long getSFloor() {
    return sFloor;
  }

  public void setSFloor(long sFloor) {
    this.sFloor = sFloor;
  }


  public double getSSize() {
    return sSize;
  }

  public void setSSize(double sSize) {
    this.sSize = sSize;
  }


  public long getSState() {
    return sState;
  }

  public void setSState(long sState) {
    this.sState = sState;
  }


  public long getSClerkCount() {
    return sClerkCount;
  }

  public void setSClerkCount(long sClerkCount) {
    this.sClerkCount = sClerkCount;
  }


  public long getSrCode() {
    return srCode;
  }

  public void setSrCode(long srCode) {
    this.srCode = srCode;
  }


  public double getSPrice() {
    return sPrice;
  }

  public void setSPrice(double sPrice) {
    this.sPrice = sPrice;
  }


  public double getSDealPrice() {
    return sDealPrice;
  }

  public void setSDealPrice(double sDealPrice) {
    this.sDealPrice = sDealPrice;
  }


  public long getRId() {
    return rId;
  }

  public void setRId(long rId) {
    this.rId = rId;
  }


  public long getCId() {
    return cId;
  }

  public void setCId(long cId) {
    this.cId = cId;
  }

  public long getsId() {
    return sId;
  }

  public void setsId(long sId) {
    this.sId = sId;
  }

  public String getsName() {
    return sName;
  }

  public void setsName(String sName) {
    this.sName = sName;
  }

  public String getsOrder() {
    return sOrder;
  }

  public void setsOrder(String sOrder) {
    this.sOrder = sOrder;
  }

  public long getsFloor() {
    return sFloor;
  }

  public void setsFloor(long sFloor) {
    this.sFloor = sFloor;
  }

  public double getsSize() {
    return sSize;
  }

  public void setsSize(double sSize) {
    this.sSize = sSize;
  }

  public long getsState() {
    return sState;
  }

  public void setsState(long sState) {
    this.sState = sState;
  }

  public long getsClerkCount() {
    return sClerkCount;
  }

  public void setsClerkCount(long sClerkCount) {
    this.sClerkCount = sClerkCount;
  }

  public double getsPrice() {
    return sPrice;
  }

  public void setsPrice(double sPrice) {
    this.sPrice = sPrice;
  }

  public double getsDealPrice() {
    return sDealPrice;
  }

  public void setsDealPrice(double sDealPrice) {
    this.sDealPrice = sDealPrice;
  }

  public long getrId() {
    return rId;
  }

  public void setrId(long rId) {
    this.rId = rId;
  }

  public long getcId() {
    return cId;
  }

  public void setcId(long cId) {
    this.cId = cId;
  }
}
