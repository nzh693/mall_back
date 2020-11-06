package com.manage.mall.service.imp;

import com.manage.mall.dto.RentUserDto;
import com.manage.mall.dto.ShopDto;
import com.manage.mall.entitys.RentUser;
import com.manage.mall.entitys.Shop;
import com.manage.mall.mappers.IContractMapper;
import com.manage.mall.mappers.IRentUserMapper;
import com.manage.mall.mappers.IShopMapper;
import com.manage.mall.service.IShopService;
import com.manage.mall.vo.Page;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopServiceImp implements IShopService {

    @Autowired
    private IShopMapper shopMapper;

    @Autowired
    private IRentUserMapper rentUserMapper;


    @Override
    public Integer addShopGetId(Shop shop) {
        return shopMapper.addShopAndGetId(shop);
    }

    @Override
    public ShopDto getShopByID(Long id) {

        Shop shop = shopMapper.getShopById(id);
        if (shop.getrId()>=1){//查询租赁户
            RentUser rentUser = rentUserMapper.queryRentUserById(shop.getrId());
            if (rentUser!=null){
                RentUserDto rentUserDto = RentUserServiceImp.transformDto(rentUser);
                shop.setRentUser(rentUserDto);
            }
        }

        return transformDto(shop);
    }

    @Override
    public void updateShopRentUserByRId(Long rId) {
        shopMapper.updateShopByDelRentUser(rId);
    }

    @Override
    public void updateShop(Shop shop) {
          shopMapper.update(shop);
    }

    @Override
    public void delShopId(Long id) {
          shopMapper.delShop(id);
    }

    @Override
    public Page getShopPage(int pageIndex, int pageSize) {
        List<Shop> shops;
        Page<List<Shop>> page = new Page<>();
        int count = shopMapper.getCountAll();//总条目
        int toTalPage=count/pageSize+1;
        int sIndex=(pageIndex-1)*pageSize;//计算起始下标
        if (sIndex>=count){//超出查询范围
             return null;
        }
        shops= shopMapper.queryShopsByPage(sIndex, pageSize);
        page.Page(pageIndex,shops.size(),sIndex,count,toTalPage,shops);
        return page;
    }




    public static ShopDto transformDto(Shop shop){
        ShopDto shopDto = new ShopDto();
        BeanUtils.copyProperties(shop,shopDto);
        if (shop.getSrCode()==111){
            shopDto.setSrCode("饰品");
        }else if(shop.getSrCode()==211){
            shopDto.setSrCode("餐饮");
        }else {
            shopDto.setSrCode("娱乐");
        }
        if (shop.getsState()==1){
            shopDto.setsState("签约");
        }else {
            shopDto.setsState("空闲");
        }
        return shopDto;
    }

    public static Shop transformPo(ShopDto shopDto){
        Shop shop = new Shop();
        BeanUtils.copyProperties(shopDto,shop);
        if (shopDto.getSrCode()!=null && shopDto.getSrCode().equals("饰品")){
            shop.setSrCode(111);
        }else if(shopDto.getSrCode()!=null && shopDto.getSrCode().equals("餐饮")){
            shop.setSrCode(211);
        }else {
            shop.setSrCode(311);
        }
        if (shopDto.getsState()!=null && shopDto.getsState().equals("签约")){
            shop.setsState(1);
        }else {
            shop.setsState(0);
        }
        return shop;
    }




}
