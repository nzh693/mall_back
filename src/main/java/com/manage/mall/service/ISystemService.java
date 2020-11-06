package com.manage.mall.service;


import com.manage.mall.entitys.Acount;
import com.manage.mall.vo.LoadVo;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ISystemService<T> {

    /**
     * 账户登录,依次校验管理员、运营经理、租赁户账户
     * @param acount
     * @return
     */
    public LoadVo<T> load(Acount acount);

    /**
     * 上传文件到服务器
     * @param path
     * @param fileName
     * @param file
     * @param request
     * @return
     */
    public Boolean uploadFile(String path, String fileName, MultipartFile file, HttpServletRequest request);


    /**
     * 获取oss签名返回，前端传送到oss
     * @param file
     * @return
     */
    public Map<String,String> uploadOnClient(MultipartFile file);


    /**
     * 在服务器将文件上传
     * @param file
     */
    public Boolean uploadOnServer(MultipartFile file);



    /***
     * 创建并返回存储文件的目录
     * @return
     */
    public String getFileSavePath();

    /**
     * 汇总： 员工，商铺，合同，租赁户， 店铺统计表,员工统计表
     * @return
     */
    public HashMap<String,HashMap<String,Integer>> statisticData();

    /**
     * 返回统计的基本数据：员工，商铺，合同，租赁户
     * @return
     */
    public HashMap<String,HashMap<String,Integer>>  statisticBasicData();

    /**
     * 返回店铺统计表,员工统计表，
     * 数组统计
     * @return
     */
    public HashMap<String,int[]> statisticEcharData();

    /**
     * 统计店铺数据
     * @return
     */
    public Map<String,Integer> statisticShopMap();

    /**
     * 统计职员数据
     * @return
     */
    public Map<String,Integer> statisticStaffMap();

    /**
     * 统计合同数据
     * @return
     */
    public Map<String,Integer> statisticContrasctMap();

    /**
     * 统计租赁户数据
     * @return
     */
    public Map<String,Integer> statisticRentUserMap();

    /**
     * 从redis服务器验证用户的token是否存在
     * @param token
     * @return
     */
    public boolean verifyToken(String token);

    /**
     * 生成token并存储到redis中
     * @param acount
     * @return
     */
    public String createToken(String acount);


    /**
     * 从 redis 服务器销毁 token
     * @param token
     * @return
     */
    public void destroyToken(String token);

    /**
     * 定时任务：根据合同的结束时间修改合同的状态
     */
    public void  updateContractState();














}
