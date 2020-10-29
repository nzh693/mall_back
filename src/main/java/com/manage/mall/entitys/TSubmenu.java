package com.manage.mall.entitys;


public class TSubmenu {

  private long sId;
  private String sName;
  private String sPath;
  private String sIconpath;
  private long sMenuid;
  private long sPower;

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

  public String getsPath() {
    return sPath;
  }

  public void setsPath(String sPath) {
    this.sPath = sPath;
  }

  public String getsIconpath() {
    return sIconpath;
  }

  public void setsIconpath(String sIconpath) {
    this.sIconpath = sIconpath;
  }

  public long getsMenuid() {
    return sMenuid;
  }

  public void setsMenuid(long sMenuid) {
    this.sMenuid = sMenuid;
  }

  public long getsPower() {
    return sPower;
  }

  public void setsPower(long sPower) {
    this.sPower = sPower;
  }

  @Override
  public String toString() {
    return "TSubmenu{" +
            "sId=" + sId +
            ", sName='" + sName + '\'' +
            ", sPath='" + sPath + '\'' +
            ", sIconpath='" + sIconpath + '\'' +
            ", sMenuid=" + sMenuid +
            ", sPower=" + sPower +
            '}';
  }
}
