package com.manage.mall.vo;

public class LoadVo<T> {

    /**
     *登录代码
     */
    private Integer loadCode;

    /**
     * 验证用户
     */
    private T loadObject;

    /**
     * 用户权限
     */
    private int userPower;

    public int getUserPower() {
        return userPower;
    }

    public void setUserPower(int userPower) {
        this.userPower = userPower;
    }

    public Integer getLoadCode() {
        return loadCode;
    }

    public void setLoadCode(Integer loadCode) {
        this.loadCode = loadCode;
    }

    public T getLoadObject() {
        return loadObject;
    }

    public void setLoadObject(T loadObject) {
        this.loadObject = loadObject;
    }

    @Override
    public String toString() {
        return "LoadVo{" +
                "loadCode=" + loadCode +
                ", loadObject=" + loadObject +
                ", userPower=" + userPower +
                '}';
    }
}
