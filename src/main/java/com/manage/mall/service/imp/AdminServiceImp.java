package com.manage.mall.service.imp;

import com.manage.mall.entitys.Admin;
import com.manage.mall.mappers.IAdminMapper;
import com.manage.mall.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImp  implements IAdminService {

    @Autowired
    private IAdminMapper adminMapper;

    @Override
    public Admin isLoadSuccess(String acount, String password) {
        Admin admin = adminMapper.queryAdminByAdmin(acount, password);
        if (admin!=null){
            return admin;
        }
        return null;
    }

    @Override
    public List<Admin> getAllAdmins() {
        List<Admin> admins = adminMapper.queryAllAdmins();
        return admins;
    }

    @Override
    public Admin getAdminByAcount(String acount) {

        return null;
    }

    @Override
    public void loginAdmin(Admin admin) {
        adminMapper.save(admin);
    }
}
