package com.manage.mall.service;

import com.manage.mall.entitys.Admin;
import com.manage.mall.entitys.Manager;
import com.manage.mall.vo.Page;

public interface IManagerService {

    /**
     * 运营经理登录
     * @param acount
     * @param password
     * @return
     */
    public Manager isManagerLoad(String acount, String password);


    /**
     * 分页查询
     * @param cur
     * @param size
     * @return
     */
    public Page getManagersByPage(Integer cur, Integer size);


    /**
     * 注册运营经理
     * @param manager
     */
    public void loginManager(Manager manager);

}
