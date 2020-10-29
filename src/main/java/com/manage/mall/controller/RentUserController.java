package com.manage.mall.controller;

import com.manage.mall.dto.RentUserDto;
import com.manage.mall.entitys.RentUser;
import com.manage.mall.service.IRentUserService;
import com.manage.mall.service.IShopService;
import com.manage.mall.vo.Page;
import com.manage.mall.vo.Respose;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/v1/rentuser")
public class RentUserController {

    @Autowired
    private IRentUserService rentUserService;

    @Autowired
    private IShopService shopService;





    /**
     * 根据租赁户id获取
     * @param id
     * @return
     */
    @RequestMapping(path = "/get",method = RequestMethod.GET)
    public Respose getRentUser(@Param("id") Long id){
        Respose<RentUserDto> respose = new Respose<>();
        RentUserDto rentUserDto = rentUserService.queryRentUserById(id);
        respose.ResposeSuccess(1,rentUserDto);
        return respose;
    }


    /**
     * 分页查询租赁户
     * @return
     */
    @RequestMapping(path = "/page",method = RequestMethod.GET)
    public Respose getRentUserByPage(@Param("curPage") Integer curPage,@Param("pageSize") Integer pageSize){
        Page page = rentUserService.getRentUsersByPage(curPage, pageSize);
        return Respose.bulid().ResposeSuccess(1,page);
    }

    /**
     * 根据租赁户id 删除已到期的合同中的租赁户
     * @param rId
     * @param cId
     * @return
     */
    @RequestMapping(path = "/delete",method = RequestMethod.POST)
    public Respose delRentUser(@Param("rId") Long rId,@Param("cId") Long cId){

        Boolean isDel = rentUserService.delRentUserById(cId, rId);
        if (isDel){
            shopService.updateShopRentUserByRId(rId);
            return Respose.bulid().ResposeSuccess("删除成功");
        }
        return Respose.bulid().ResposeFailed("合同未到期，无法删除");

    }

    /**
     * 更新
     * @param rentuser
     * @return
     */
    @RequestMapping(path = "/update",method = RequestMethod.POST)
    public Respose updateRentUser(@RequestBody RentUser rentuser){
        rentUserService.updateRentUser(rentuser);
        return Respose.bulid().ResposeSuccess("删除成功");
    }






}
