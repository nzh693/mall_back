package com.manage.mall.service;

import com.manage.mall.dto.RentUserDto;
import com.manage.mall.entitys.RentUser;
import com.manage.mall.vo.Page;

import java.security.PublicKey;

public interface IRentUserService {

    /**
     * 租赁户登录
     * @param acount
     * @param password
     * @return
     */
    public RentUser isRentUserLoad(String acount, String password);

    /**
     * id查询租赁户
     * @param id
     * @return
     */
    public RentUserDto queryRentUserById(Long id);


    /**
     * 分页查询
     * @param cur
     * @param size
     * @return
     */
    public Page getRentUsersByPage(Integer cur, Integer size);


    /**
     * id删除租赁户
     * @param
     * @return
     */
    public Boolean delRentUserById(Long cId,Long rId);

    /**
     * 更新租赁户
     * @param rentUser
     */
    public void  updateRentUser(RentUser rentUser);

    /**
     * 注册租赁户
     * @param rentUser
     */
    public void loginRentUser(RentUser rentUser);



}
