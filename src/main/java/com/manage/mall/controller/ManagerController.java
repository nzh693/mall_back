package com.manage.mall.controller;

import com.manage.mall.service.IManagerService;
import com.manage.mall.vo.Page;
import com.manage.mall.vo.Respose;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("api/v1/manager")
public class ManagerController {

    @Autowired
    private IManagerService managerService;

    /**
     * 分页查询店员
     * @return
     */
    @RequestMapping(path = "/page",method = RequestMethod.GET)
    public Respose getRentUserByPage(Integer curPage, Integer pageSize){
        Page page = managerService.getManagersByPage(curPage, pageSize);
        return Respose.bulid().ResposeSuccess(1,page);
    }


}
