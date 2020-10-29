package com.manage.mall.service.imp;

import com.manage.mall.entitys.Manager;
import com.manage.mall.mappers.IManagerMapper;
import com.manage.mall.service.IManagerService;
import com.manage.mall.vo.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerServiceImp implements IManagerService {

    @Autowired
    private IManagerMapper managerMapper;

    @Override
    public void loginManager(Manager manager) {
        managerMapper.save(manager);
    }

    @Override
    public Page getManagersByPage(Integer cur, Integer size) {
        int sIdnex = (cur - 1) * size;
        int count = managerMapper.queryCountManager();
        int totalPage = (count % size) != 0 ? count / size + 1 : count / size;
        List<Manager> managers = managerMapper.queryManagerByPage(sIdnex, size);
        Page<List<Manager>> page = new Page<>();
        page.Page(cur,size,sIdnex,count,totalPage,managers);
        return page;
    }

    @Override
    public Manager isManagerLoad(String acount, String password) {

        Manager manager = managerMapper.queryManageByManage(acount, password);
        if (manager!=null){
            return  manager;
        }
        return null;
    }
}
