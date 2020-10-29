package com.manage.mall.service;

import com.manage.mall.dto.ShopDto;
import com.manage.mall.entitys.Shop;
import com.manage.mall.vo.Page;

public interface IShopService {

    /**
     * 新增一个商铺并返回其id
     * @param shop
     * @return
     */
    public Integer addShopGetId(Shop shop);

    /**
     * 根据商铺id进行删除
     * @param id
     */
    public void delShopId(Long id);

    /**
     * 分页查询店铺
     * @param pageIndex 请求页数
     * @param pageSize 请求页大小
     * @return
     */
    public Page getShopPage(int pageIndex,int pageSize);

    /**
     * 根据id查询商铺
     * @param id
     * @return
     */
    public ShopDto getShopByID(Long id);

    /**
     * 更新商铺信息
     * @param shop
     */
    public void updateShop(Shop shop);

    /**
     * 匹配商铺表中的 rid 将rid，cid 改为闲置状态;
     *
     * @param rId
     */
    public void updateShopRentUserByRId(Long rId);



}
