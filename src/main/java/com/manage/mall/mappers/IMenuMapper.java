package com.manage.mall.mappers;

import com.manage.mall.entitys.TMenu;

import java.util.List;

public interface IMenuMapper {


    /**
     * 根据账户权限等级获取首页导航栏菜单
     * @param power
     * @return
     */
    public List<TMenu> getHomeMenu(int power);
}
