package com.manage.mall.service;

import com.manage.mall.entitys.Acount;
import com.manage.mall.entitys.TMenu;

import java.util.List;

public interface IMenuService {

    /**
     * 根据账户权限级别获取菜单
     * @param acountPower
     * @return
     */
    public List<TMenu> getAllMenuByAcountPower(int  acountPower);
}
