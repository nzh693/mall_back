package com.manage.mall.mappers;

import com.manage.mall.entitys.Assistant;
import com.manage.mall.entitys.Manager;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IAssistantMapper {

    /**
     * 查询数目
     * @return
     */
    @Select("select count(*) from assistant")
    public Integer queryCountAssistant();


    /**
     * 按页查询
     * @param sIndex
     * @param limit
     * @return
     */
    @Select("select * from assistant where a_id limit #{sIndex},#{limit}")
    public List<Assistant> queryAssistantByPage(@Param("sIndex") Integer sIndex, @Param("limit") Integer limit);

}
