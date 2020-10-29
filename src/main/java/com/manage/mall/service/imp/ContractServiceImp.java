package com.manage.mall.service.imp;

import com.manage.mall.dto.ContractDto;
import com.manage.mall.dto.RentUserDto;
import com.manage.mall.entitys.Contract;
import com.manage.mall.mappers.IContractMapper;
import com.manage.mall.service.IContractService;
import com.manage.mall.vo.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@Service
public class ContractServiceImp implements IContractService {


    @Autowired
    private IContractMapper contractMapper;

    @Override
    public Page getContractsByPage(@Param("curPage") Integer curPage, @Param("sizePage") Integer sizePage) {
        Page<List<ContractDto>> page = new Page<>();
        Integer sum=contractMapper.queryCountAll();//
        Integer sIndex=(curPage-1)*sizePage;//该页的起始位置
        Integer totalPage=sum%sizePage==0?sum/sizePage:sum/sizePage+1;//当前页码下总页数
        if (sIndex>sum){//超页
            return null;
        }
        List<Contract> contracts = contractMapper.queryContractByPage(sIndex, sizePage);
        List<ContractDto> contractDtos = transformList(contracts);
        page.Page(curPage,contracts.size(),sIndex,sum,totalPage,contractDtos);
        return page;
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public ContractDto getContractById(Long id) {
        return  transformDto(contractMapper.queryById(id));
    }

    @Override
    public void delContractById(Long id) {
       contractMapper.delById(id);
    }

    /**
     * 将合同对象PO实体转化为合同传输Dto实体
     * @param list
     * @return
     */
    public List<ContractDto> transformList(List<Contract> list){
        List<ContractDto> contractDtos = new LinkedList<>();
        for (Contract c:list){
            contractDtos.add(transformDto(c));
        }
        return contractDtos;
    }

    @Override
    public void addContract(Contract contract) {
      contractMapper.addContract(contract);
    }

    /**
     * 目前无法解析上传的合同文件，需要后期进行改进。暂时新增合同实体
     * @param file
     * @param path 服务器存储路径
     * @param saveFileName 服务器名称
     * @return
     */
    @Override
    public Contract resolveContractFile(MultipartFile file, String path,String saveFileName) {
        Contract contract = new Contract();
        contract.setRId(1);
        contract.setSId(1);
        contract.setCPayType(1);
        contract.setCState(2);
        contract.setCStartTime(new Timestamp(System.currentTimeMillis()));
        contract.setCEndTime(new Timestamp(System.currentTimeMillis()));
        contract.setCComment("暂无");
        contract.setCOrder(UUID.randomUUID().toString());
        contract.setCFixMoney(0);
        contract.setCMoney(3000);
        contract.setCSumTime(0);
        contract.setCFileName(file.getOriginalFilename());
        contract.setCPath(path+File.separator+saveFileName);
        return contract;
    }

    /**
     * 转化信息
     * @param c
     * @return
     */
    public static ContractDto transformDto(Contract c){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        ContractDto contractDto = new ContractDto();
        BeanUtils.copyProperties(c,contractDto);
        contractDto.setcEndTime(dateFormat.format(c.getCEndTime()));
        contractDto.setcStartTime(dateFormat.format(c.getCStartTime()));
        if (c.getCState()==1){
            contractDto.setcState("生效中");
        }else if(c.getCState()==2) {
            contractDto.setcState("逾期欠款");
        }else {
            contractDto.setcState("结算");
        }

        if (c.getCPayType()==1){
            contractDto.setcPayType("月付");
        }else if(c.getCPayType()==2){
            contractDto.setcPayType("季付");
        }else {
            contractDto.setcPayType("年付");

        }
        if (c.getRentUser()!=null){
            RentUserDto rentUserDto = RentUserServiceImp.transformDto(c.getRentUser());
            contractDto.setRentUser(rentUserDto);

        }
        return contractDto;
    }

    @Override
    public Boolean isContractExpire(Long cId) {
        Integer contractExpire = contractMapper.isContractExpire(cId);
        if (contractExpire==1){//当前时间大于合同结束时间=》合同超期
            return true;
        }
        return false;
    }
}
