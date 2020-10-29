package com.manage.mall.controller;

import com.manage.mall.dto.ContractDto;
import com.manage.mall.entitys.Contract;
import com.manage.mall.service.IContractService;
import com.manage.mall.vo.Page;
import com.manage.mall.vo.Respose;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 合同管理接口
 */
@RestController
@CrossOrigin
@RequestMapping("api/v1/contract")
public class ContractController {

    @Autowired
    private IContractService contractService;

    /**
     * 按页获取合同
     * @param curPage 页码
     * @param sizePage 页大小
     * @return
     */
    @RequestMapping(path = "page",method = RequestMethod.GET)
    public Respose getAllContracts(@Param("curPage") Integer curPage,@Param("sizePage") Integer sizePage){
        Respose<Page> respose = new Respose<>();
        Page page = contractService.getContractsByPage(curPage, sizePage);
        if (page==null){
            respose.ResposeFailed("数据获取页码超过总页啦");
        }else {
            respose.ResposeSuccess(page.getPageSize(),page);
        }

        return respose;
    }

    /**
     * 根据id获取合同详情
     * @param id
     * @return
     */
    @RequestMapping(path = "get",method = RequestMethod.GET)
    public Respose getContractById(@Param("id") Long id){
        Respose<ContractDto> respose = new Respose<>();
        ContractDto contract = contractService.getContractById(id);
        respose.ResposeSuccess(1,contract);
        return respose;
    }

    @RequestMapping(path = "del",method = RequestMethod.POST)
    public Respose delContractById(@Param("id") Long id){
        Respose<Contract> respose = new Respose<>();
        contractService.delContractById(id);
        respose.ResposeSuccess("删除成功");
        return respose;
    }

}
