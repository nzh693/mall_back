package com.manage.mall.service;

import com.manage.mall.entitys.Admin;

import java.util.List;

public interface IAdminService {

    /**
     * 获取所有的管理员
     * @return
     */
    public List<Admin> getAllAdmins();

    /**
     * 根据账户名查询
     * @param acount
     * @return
     */
    public Admin getAdminByAcount(String acount);

    /**
     * 管理员登录
     * @param acount
     * @param password
     * @return
     */
    public Admin isLoadSuccess(String acount,String password);

    /**
     * 注册管理员
     * @param admin
     */
    public void loginAdmin(Admin admin);

}
