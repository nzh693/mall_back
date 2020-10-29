package com.manage.mall.service;

import com.manage.mall.dto.ContractDto;
import com.manage.mall.entitys.Contract;
import com.manage.mall.vo.Page;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Service
public interface IContractService {

    /**
     * 根据页码获取合同页
     * @param curPage
     * @param sizePage
     * @return
     */
    public Page getContractsByPage(Integer curPage,Integer sizePage);

    /**
     * 根据id获取合同
     * @param id
     * @return
     */
    public ContractDto getContractById(Long id);

    /**
     * 根据id逻辑删除合同
     * @param id
     */
    public void delContractById(Long id);

    /**
     * 保存合同实体
     * @param contract
     */
    public void addContract(Contract contract);

    /**
     * 解析上传的合同，生成合同实体
     * @param file
     * @param path 服务器存储路径
     * @param saveFileName 服务器名称
     * @return
     */
    public Contract resolveContractFile(MultipartFile file, String path,String saveFileName);

    /**
     * 检测合同是否到期
     * @param cId
     * @return
     */
    public Boolean isContractExpire(Long cId);





}
