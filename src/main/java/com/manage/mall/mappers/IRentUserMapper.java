package com.manage.mall.mappers;

import com.manage.mall.entitys.Admin;
import com.manage.mall.entitys.RentUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface IRentUserMapper {


    @Select("select * from rent_user where r_email_address=#{acount} and r_password=#{password} limit 0,1")
    public RentUser queryRentUserByRentUser(@Param("acount") String acount, @Param("password")String password);

    /**
     * 根据id查询租赁户
     * @param id
     * @return
     */
    @Select("select * from rent_user where r_id=#{id}  limit 0,1")
    public RentUser queryRentUserById(Long id);


    @Select("select count(*) from rent_user")
    public Integer queryCountRentUser();

    /**
     * 按页查询
     * @param sIndex
     * @param limit
     * @return
     */
    @Select("select * from rent_user where r_id limit #{sIndex},#{limit}")
    public List<RentUser> queryRentUserByPage(@Param("sIndex") Integer sIndex, @Param("limit")Integer limit);


    @Select("delete  from rent_user where r_id=#{id}")
    public Integer delRentUser(Long id);

    /**
     * 全部更新
     * @param rentUser
     */
    @Update("update rent_user set r_name=#{rName},r_phone=#{rPhone},r_email_address=#{rEmailAddress},r_power=#{rPower}" +
            " where r_id=#{rId}")
    public void updateRentUser(RentUser rentUser);

    @Insert("insert into  rent_user  values(null,#{rName},#{rPhone},#{rEmailAddress},#{rPassword},#{rPower},-1,-1)")
    public void save(RentUser rentUser);





}
