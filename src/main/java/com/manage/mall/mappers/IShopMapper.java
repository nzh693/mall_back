package com.manage.mall.mappers;

import com.manage.mall.entitys.Shop;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IShopMapper {

    /**
     * 新增一个店铺
     * @param shop
     */
    public int addShopAndGetId(Shop shop);

    /**
     * 根据id删除一个店铺
     * @param id
     */
    @Delete("update shop set r_id=-1,c_id=-1 where s_id=#{id}")
    public void delShop(Long id);

    /**
     * 查询总条目
     * @return
     */
    @Select("select count(*) from shop")
    public int getCountAll();

    /**
     * 根据起始位置和偏移量进行查询
     * @param sIndex 数据库下标从0开始
     * @param limit
     * @return
     */
    @Select("select * from shop where s_id limit #{sIndex},#{limit}")
    public List<Shop> queryShopsByPage(@Param("sIndex") int sIndex, @Param("limit") int limit);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @Select("select * from shop where s_id=#{id} limit 0,1")
    public Shop getShopById(Long id);

    /**
     * 更新商铺信息
     * @param shop
     */
    @Update("update shop set s_name=#{sName},s_state=#{sState},sr_code=#{srCode},s_size=#{sSize},s_price=#{sPrice} where s_id=#{sId}")
    public void update(Shop shop);


    @Select("select count(*) from shop where r_id !=-1 and c_id!=-1")
    public Integer  queryShopCountRent();


    @Update("update shop s set s.c_id=-1 , s.r_id=-1,s.s_state=0 where s.r_id=#{rId}")
    public void updateShopByDelRentUser(Long rId);






}
