package com.manage.mall.service.imp;

import com.manage.mall.dto.RentUserDto;
import com.manage.mall.entitys.RentUser;
import com.manage.mall.mappers.IRentUserMapper;
import com.manage.mall.service.IContractService;
import com.manage.mall.service.IRentUserService;
import com.manage.mall.vo.Page;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentUserServiceImp implements IRentUserService {

    @Autowired
    private IRentUserMapper rentUserMapper;

    @Autowired
    private IContractService contractService;



    @Override
    public RentUser isRentUserLoad(String acount, String password) {
        RentUser renter = rentUserMapper.queryRentUserByRentUser(acount, password);
        if (renter!=null){
            return renter;
        }
        return null;
    }

    @Override
    public void loginRentUser(RentUser rentUser) {
        rentUserMapper.save(rentUser);
    }

    @Override
    public void updateRentUser(RentUser rentUser) {
         rentUserMapper.updateRentUser(rentUser);
    }

    @Override
    public Boolean delRentUserById(Long cId,Long rId) {
        //合同到期后方可删除，结束时间大于当前时间

        Boolean contractExpire = contractService.isContractExpire(cId);
        if (contractExpire){//已经超期
            rentUserMapper.delRentUser(rId);
            return true;
        }
        return false;
    }

    @Override
    public Page getRentUsersByPage(Integer cur, Integer size) {
        int sIdnex = (cur - 1) * size;
        int count = rentUserMapper.queryCountRentUser();
        int totalPage = (count % size) != 0 ? count / size + 1 : count / size;
        List<RentUser> rentUsers = rentUserMapper.queryRentUserByPage(sIdnex, size);
        Page<List<RentUser>> page = new Page<>();
        page.Page(cur,size,sIdnex,count,totalPage,rentUsers);
        return page;
    }

    @Override
    public RentUserDto queryRentUserById(Long id) {
        return transformDto(rentUserMapper.queryRentUserById(id));
    }


    public static RentUserDto transformDto(RentUser rentUser){
        RentUserDto rentUserDto = new RentUserDto();
        BeanUtils.copyProperties(rentUser,rentUserDto);
        if (rentUser.getRPower()==1){
            rentUserDto.setrPower("一级权限");
        }else if(rentUser.getRPower()==2){
            rentUserDto.setrPower("二级权限");
        }else {
            rentUserDto.setrPower("三级权限");
        }
        return rentUserDto;
    }
}
