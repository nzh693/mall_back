package com.manage.mall.mappers;

import com.manage.mall.entitys.Manager;
import com.manage.mall.entitys.RentUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IManagerMapper {

    @Select("select * from manager where m_emall_address=#{acount} and m_password=#{password} limit 0,1")
    public Manager queryManageByManage(@Param("acount") String acount, @Param("password") String password);

    @Select("select count(*) from manager")
    public Integer queryCountManager();

    /**
     * 按页查询
     * @param sIndex
     * @param limit
     * @return
     */
    @Select("select * from manager where m_id limit #{sIndex},#{limit}")
    public List<Manager> queryManagerByPage(@Param("sIndex") Integer sIndex,@Param("limit") Integer limit);


    @Insert("insert into  manager  values(null,#{mName},#{mStartTime},#{mEndTime},#{mSalary},#{mClerkCount},#{mEmallAddress},#{mPower})")
    public void save(Manager manager);

}
