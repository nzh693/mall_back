package com.manage.mall.mappers;

import com.manage.mall.dto.MonthAndCount;
import com.manage.mall.entitys.Contract;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import sun.util.resources.cldr.tr.CurrencyNames_tr;

import java.util.List;

public interface IContractMapper {


    /**
     * 根据页码要求获取合同页数据
     * @param start
     * @param limit
     * @return
     */
    @Select("select * from  contract where c_id limit #{start},#{limit}")
    public List<Contract> queryContractByPage(@Param("start") int start, @Param("limit") int  limit);

    /**
     * 根据id查询合同
     * @param id
     * @return
     */
    public Contract queryById(Long id);

    /**
     * 根据id逻辑删除合同信息
     * @param id
     */
    @Delete("update  contract set c_delete=1  where c_id=#{id}")
    public void delById(Long id);

    /**
     * 查询有效合同个数
     * @return
     */
    @Select("select count(*) from contract where c_delete !=-1 and r_id !=-1 and s_id!=-1 and c_state!=0")
    public Integer queryEffectiveCountAll();



    /**
     * 查询有效合同个数
     * @return
     */
    @Select("select count(*) from contract where c_delete !=-1 ")
    public Integer queryCountAll();


    /**
     * 新增
     * @param contract
     */
    public void addContract(Contract contract);

    /**
     * 生效合同计数
     * 状态值为 1
     * @return
     */
    @Select("select count(*) from contract c where c.c_state=1")
    public Integer queryContractStateEqulsEffect();

    /**
     * 逾期合同计数
     * 状态值：2
     * @return
     */
    @Select("select count(*) from contract c where c.c_state=2")
    public Integer queryContractStateEqulsBeyondDate();

    /**
     * 结算合同计数
     * 状态值为 0
     * @return
     */
    @Select("select count(*) from contract c where c.c_state=0")
    public Integer queryContractStateEqulsSettle();

    /**
     * 查询当年 1-12 月的合同签订情况
     * @return
     */
    @Select("SELECT MONTH(c.c_start_time) as month ,COUNT(*) as count from contract c where YEAR(c.c_start_time)=YEAR(NOW())  GROUP BY MONTH(c.c_start_time)")
    public List<MonthAndCount> queryStartDateByMonth();

    /**
     * 查询当年 1-12 月的合同结束情况
     * @return
     */
    @Select("SELECT MONTH(c.c_end_time) as month ,COUNT(*) as count from contract c where YEAR(c.c_end_time)=YEAR(NOW()) GROUP BY MONTH(c.c_end_time)")
    public List<MonthAndCount>  queryEndDateByMonth();

    /**
     * 查询当年 1-12 月 合同逾期的情况
     * @return
     */
    @Select("SELECT MONTH(c.c_end_time) as month ,COUNT(*) as count from contract c where c.c_state=0 GROUP BY MONTH(c.c_end_time)")
    public List<MonthAndCount> queryBeyondDateByMonth();

    /**
     * 检测合同是否到期
     * @param cId
     * @return
     */
    @Select("SELECT NOW()>(SELECT c_end_time from contract where c_id=#{cId})")
    public Integer isContractExpire(Long cId);

    /***
     * 更新合同的状态
     */
    @Select("update contract set c_state=2  where c_id in (SELECT * from (SELECT c.c_id as id from contract c where c.c_end_time >NOW() and c.c_state=1) as temp)")
    public void updateContractStateByEndTime();


}
