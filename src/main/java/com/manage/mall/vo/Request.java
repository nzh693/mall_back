package com.manage.mall.vo;

public class Request<T> {

    private String smg;
    private Object object;
    private T data;

    public String getSmg() {
        return smg;
    }

    public void setSmg(String smg) {
        this.smg = smg;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Request{" +
                "smg='" + smg + '\'' +
                ", object=" + object +
                ", data=" + data +
                '}';
    }
}
