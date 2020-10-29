package com.manage.mall.controller;

import com.manage.mall.service.IAssistantService;
import com.manage.mall.vo.Page;
import com.manage.mall.vo.Respose;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/assistant")
public class IAssistantController {

    @Autowired
    private IAssistantService assistantService;

    /**
     * 分页查询店员
     * @return
     */
    @RequestMapping(path = "/page",method = RequestMethod.GET)
    public Respose getAssistantByPage( Integer curPage, Integer pageSize){
        Page page = assistantService.getAssistantsByPage(curPage, pageSize);
        return Respose.bulid().ResposeSuccess(1,page);
    }
}
