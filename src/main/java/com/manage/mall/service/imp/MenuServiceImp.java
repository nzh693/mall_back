package com.manage.mall.service.imp;

import com.manage.mall.entitys.TMenu;
import com.manage.mall.mappers.IMenuMapper;
import com.manage.mall.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImp implements IMenuService {

    @Autowired
    private IMenuMapper menuMapper;



    @Override
    public List<TMenu> getAllMenuByAcountPower(int acountPower) {
        List<TMenu> homeMenu = menuMapper.getHomeMenu(acountPower);
        return homeMenu;
    }
}
