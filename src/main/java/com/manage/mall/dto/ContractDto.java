package com.manage.mall.dto;


/**
 * 合同传输实体
 */
public class ContractDto {

    private long cId;
    private String cOrder;
    private String cFileName;
    private String cPath;
    private String cStartTime;
    private String cEndTime;
    private long cSumTime;
    private double cMoney;
    private String cComment;
    private String cPayType;
    private String cState;
    private double cFixMoney;
    private long cDelete;//逻辑删除标志
    private long rId;
    private long sId;
    private RentUserDto rentUser;




    @Override
    public String toString() {
        return "ContractDto{" +
                "cId=" + cId +
                ", cOrder='" + cOrder + '\'' +
                ", cFileName='" + cFileName + '\'' +
                ", cPath='" + cPath + '\'' +
                ", cStartTime='" + cStartTime + '\'' +
                ", cEndTime='" + cEndTime + '\'' +
                ", cSumTime=" + cSumTime +
                ", cMoney=" + cMoney +
                ", cComment='" + cComment + '\'' +
                ", cPayType='" + cPayType + '\'' +
                ", cState='" + cState + '\'' +
                ", cFixMoney=" + cFixMoney +
                ", cDelete=" + cDelete +
                ", rId=" + rId +
                ", sId=" + sId +
                '}';
    }

    public RentUserDto getRentUser() {
        return rentUser;
    }

    public void setRentUser(RentUserDto rentUser) {
        this.rentUser = rentUser;
    }

    public String getcOrder() {
        return cOrder;
    }

    public void setcOrder(String cOrder) {
        this.cOrder = cOrder;
    }

    public String getcPayType() {
        return cPayType;
    }

    public void setcPayType(String cPayType) {
        this.cPayType = cPayType;
    }

    public String getcState() {
        return cState;
    }

    public void setcState(String cState) {
        this.cState = cState;
    }

    public long getcId() {
        return cId;
    }

    public void setcId(long cId) {
        this.cId = cId;
    }

    public String getcFileName() {
        return cFileName;
    }

    public void setcFileName(String cFileName) {
        this.cFileName = cFileName;
    }

    public String getcPath() {
        return cPath;
    }

    public void setcPath(String cPath) {
        this.cPath = cPath;
    }

    public String getcStartTime() {
        return cStartTime;
    }

    public void setcStartTime(String cStartTime) {
        this.cStartTime = cStartTime;
    }

    public String getcEndTime() {
        return cEndTime;
    }

    public void setcEndTime(String cEndTime) {
        this.cEndTime = cEndTime;
    }

    public long getcSumTime() {
        return cSumTime;
    }

    public void setcSumTime(long cSumTime) {
        this.cSumTime = cSumTime;
    }

    public double getcMoney() {
        return cMoney;
    }

    public void setcMoney(double cMoney) {
        this.cMoney = cMoney;
    }

    public String getcComment() {
        return cComment;
    }

    public void setcComment(String cComment) {
        this.cComment = cComment;
    }


    public double getcFixMoney() {
        return cFixMoney;
    }

    public void setcFixMoney(double cFixMoney) {
        this.cFixMoney = cFixMoney;
    }

    public long getcDelete() {
        return cDelete;
    }

    public void setcDelete(long cDelete) {
        this.cDelete = cDelete;
    }

    public long getrId() {
        return rId;
    }

    public void setrId(long rId) {
        this.rId = rId;
    }

    public long getsId() {
        return sId;
    }

    public void setsId(long sId) {
        this.sId = sId;
    }

}
