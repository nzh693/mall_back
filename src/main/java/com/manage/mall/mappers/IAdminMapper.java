package com.manage.mall.mappers;


import com.manage.mall.entitys.Admin;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface IAdminMapper {

    @Select("select * from admin")
    public List<Admin> queryAllAdmins();

    @Select("select * from admin where a_acount=#{acount} and a_password=#{password} limit 0,1")
    public Admin queryAdminByAdmin(@Param("acount") String acount,@Param("password") String password);

    @Select("select count(*) from admin")
    public Integer queryCountAdmin();

    @Insert("insert into  admin values(null,#{aAcount},#{aPassword},#{aPower},#{aEmail})")
    public void save(Admin admin);


}
