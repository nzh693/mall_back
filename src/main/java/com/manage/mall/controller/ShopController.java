package com.manage.mall.controller;

import com.manage.mall.dto.ShopDto;
import com.manage.mall.entitys.Shop;
import com.manage.mall.service.IShopService;
import com.manage.mall.service.imp.ShopServiceImp;
import com.manage.mall.utils.MyBeanUtil;
import com.manage.mall.vo.Page;
import com.manage.mall.vo.Respose;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("api/v1/shop")
public class ShopController {

    @Autowired
    private IShopService shopService;

    /**
     * 修改
     */
    @RequestMapping("/updateShop")
    public Respose updateShop(@RequestBody ShopDto shopDataForm) {

        Shop shop = ShopServiceImp.transformPo(shopDataForm);
        shopService.updateShop(shop);
        return Respose.bulid().ResposeSuccess("修改成功");
    }

    /**
     * 新增
     */
    @RequestMapping("/addShop")
    public Respose addShop(@RequestBody ShopDto shopDataForm) {
        Shop shop = ShopServiceImp.transformPo(shopDataForm);
        boolean isEmpty = MyBeanUtil.allFieldIsNULL(shop);
        if (isEmpty) {
            return Respose.bulid().ResposeFailed("无法新增空数据");
        }
        shopService.addShopGetId(shop);
        return Respose.bulid().ResposeSuccess("新增成功");
    }

    /**
     * 删除
     */
    @RequestMapping("/delShop")
    public Respose delShop(@Param("id") Long id) {
        Respose<Void> re = new Respose<>();
        shopService.delShopId(id);
        re.ResposeSuccess("删除成功");
        return re;
    }

    /**
     * 按页获取商铺
     *
     * @param curPage
     * @param sizePage
     * @return
     */
    @RequestMapping("/getShopByPage")
    public Respose getShopByPage(@Param("curPage") Integer curPage, @Param("sizePage") Integer sizePage) {
        Respose<Page> respose = new Respose<>();
        Page shopPage = shopService.getShopPage(curPage, sizePage);
        if (shopPage == null) {
            respose.ResposeFailed("查询超过页码最大值");
            return respose;
        }
        respose.ResposeSuccess(shopPage.getPageSize(), shopPage);
        return respose;
    }

    /**
     * 根据商铺id查询商铺
     *
     * @param id
     * @return
     */
    @RequestMapping("/getShopDetailById")
    public Respose getShopDetailById(@Param("id") Long id) {
        ShopDto shop = shopService.getShopByID(id);
        return Respose.bulid().ResposeSuccess(1, shop);
    }

}
