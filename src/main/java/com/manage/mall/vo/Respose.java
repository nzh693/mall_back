package com.manage.mall.vo;

public class Respose<T> {

    private String code;
    private String msg;
    private Integer count;
    private T data;
    private Object object;
    private String token;//请求验证

    private static Respose re=null;



    public static synchronized Respose bulid(){
        if (re==null){
            re= new Respose<Void>();
        }
        return re;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public static Respose getRe() {
        return re;
    }

    public static void setRe(Respose re) {
        Respose.re = re;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }



    public Respose Respose(String code, String msg, int count, T t) {
        setCount(count);
        setCode(code);
        setMsg(msg);
        setData(t);
        setObject(null);
        return re;
    }

    public Respose ResposeSuccess(int count, T t) {
        setCode("OK");
        setMsg("成功");
        setCount(count);
        setObject(null);
        setData(t);
        return re;
    }

    public Respose ResposeSuccess(int count,String msg, T t) {
        setCode("OK");
        setMsg(msg);
        setCount(count);
        setData(t);
        return re;
    }

    public Respose ResposeSuccess(String msg) {
        setCode("OK");
        setMsg(msg);
        setCount(0);
        setData(null);
        return re;
    }

    public Respose ResposeFailed(String msg) {
        setCode("NO");
        setMsg(msg);
        setObject(null);
        setCount(0);
        setData(null);
        return re;
    }



    @Override
    public String toString() {
        return "Respose{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", count=" + count +
                ", data=" + data +
                ", object=" + object +
                '}';
    }
}
