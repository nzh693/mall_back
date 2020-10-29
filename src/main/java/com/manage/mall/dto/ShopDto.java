package com.manage.mall.dto;

public class ShopDto {


    private long sId;
    private String sName;
    private String sOrder;
    private long sFloor;
    private double sSize;
    private String sState;
    private long sClerkCount;
    private String srCode;
    private double sPrice;//预售价
    private double sDealPrice;//成交价
    private long rId;
    private long cId;
    private RentUserDto rentUser;
    private ContractDto contract;


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


    public double getsSize() {
        return sSize;
    }

    public void setsSize(double sSize) {
        this.sSize = sSize;
    }

    public String getsState() {
        return sState;
    }

    public void setsState(String sState) {
        this.sState = sState;
    }

    public long getsFloor() {
        return sFloor;
    }

    public void setsFloor(long sFloor) {
        this.sFloor = sFloor;
    }

    public long getsClerkCount() {
        return sClerkCount;
    }

    public void setsClerkCount(long sClerkCount) {
        this.sClerkCount = sClerkCount;
    }

    public String getSrCode() {
        return srCode;
    }

    public void setSrCode(String srCode) {
        this.srCode = srCode;
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

    @Override
    public String toString() {
        return "ShopDto{" +
                "sId=" + sId +
                ", sName='" + sName + '\'' +
                ", sOrder='" + sOrder + '\'' +
                ", sFloor=" + sFloor +
                ", sSize=" + sSize +
                ", sState='" + sState + '\'' +
                ", sClerkCount=" + sClerkCount +
                ", srCode='" + srCode + '\'' +
                ", rId=" + rId +
                ", cId=" + cId +
                ", rentUser=" + rentUser +
                ", contract=" + contract +
                '}';
    }
}
