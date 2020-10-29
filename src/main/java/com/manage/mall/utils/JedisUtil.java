package com.manage.mall.utils;



import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.ResourceBundle;

public class JedisUtil {
    private static JedisPool jedisPool=null;
    private static String host="";
    private static int    port;
    private static int    maxTotal;
    private static int    maxIdle;//最大活动连接数
    private static int    timeOut;

    static {
        ResourceBundle bundle=ResourceBundle.getBundle("redis");
        host= bundle.getString("redis.host").toString();
        port=Integer.parseInt(bundle.getString("redis.port"));
        maxTotal=Integer.parseInt(bundle.getString("redis.maxTotal"));
        maxIdle=Integer.parseInt(bundle.getString("redis.maxIdle"));
        timeOut=Integer.parseInt(bundle.getString("redis.timeOut"));
        JedisPoolConfig jedisPoolConfig=new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(maxTotal);
        jedisPoolConfig.setMaxIdle(maxIdle);
        jedisPoolConfig.setTestOnBorrow(false);
        jedisPoolConfig.setTestOnReturn(true);
        jedisPoolConfig.setTestWhileIdle(true);
        jedisPool=new JedisPool(jedisPoolConfig,host,port,timeOut);
    }




    public static Jedis getJedis(){
        return jedisPool.getResource();
    }

    public static void close( Jedis jedis){
        try {
            if (jedis!=null){
                jedisPool.close();
            }
        } catch (Exception e){
            System.out.println("释放资源异常");
        }
    }




}
