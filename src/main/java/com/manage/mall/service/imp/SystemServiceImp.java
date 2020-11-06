package com.manage.mall.service.imp;

import com.aliyun.oss.OSS;
import com.aliyun.oss.common.utils.BinaryUtil;
import com.aliyun.oss.model.MatchMode;
import com.aliyun.oss.model.PolicyConditions;
import com.manage.mall.config.ConstantConfig;
import com.manage.mall.dto.MonthAndCount;
import com.manage.mall.entitys.Acount;
import com.manage.mall.entitys.Admin;
import com.manage.mall.entitys.Manager;
import com.manage.mall.entitys.RentUser;
import com.manage.mall.mappers.*;
import com.manage.mall.service.ISystemService;
import com.manage.mall.utils.JedisUtil;
import com.manage.mall.vo.LoadVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.system.ApplicationHome;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class SystemServiceImp implements ISystemService {

    Logger logger = LoggerFactory.getLogger(this.getClass());



    @Autowired
    private OSS oss;






    @Value("${oss.bucketName}")
    private   String bucketName;

    @Value("${spring.cloud.alicloud.access-key}")
    private   String accessKeyId;

    @Value("${spring.cloud.alicloud.oss.endpoint}")
    private String endPoint;




    @Autowired
    private IAdminMapper adminMapper;

    @Autowired
    private IAssistantMapper assistantMapper;

    @Autowired
    private IManagerMapper managerMapper;

    @Autowired
    private IRentUserMapper rentUserMapper;

    @Autowired
    private IContractMapper contractMapper;

    @Autowired
    private IShopMapper shopMapper;



    @Override
    public LoadVo load(Acount acount) {
        LoadVo lv;
        Admin admin = adminMapper.queryAdminByAdmin(acount.getAcount(), acount.getPassword());
        if (admin!=null){//账户名和密码进行登录
            lv=new LoadVo<Admin>();
            lv.setLoadObject(admin);
            lv.setUserPower((int) admin.getAPower());
            lv.setLoadCode(ConstantConfig.ADMIN_LOAD);
            return lv;
        }
        Manager manager = managerMapper.queryManageByManage(acount.getAcount(), acount.getPassword());
        if (manager!=null){//按邮箱地址进行登录
            lv=new LoadVo<Manager>();
            lv.setLoadObject(manager);
            lv.setUserPower((int) manager.getMPower());
            lv.setLoadCode(ConstantConfig.MANAGER_LOAD);
            return lv;
        }
        RentUser rentUser = rentUserMapper.queryRentUserByRentUser(acount.getAcount(), acount.getPassword());
        if (rentUser!=null){//租户按邮箱地址进行登录
            lv=new LoadVo<RentUser>();
            lv.setLoadObject(rentUser);
            lv.setUserPower((int) rentUser.getRPower());
            lv.setLoadCode(ConstantConfig.RentUser_LOAD);
            return lv;
        }
        return null;
    }

    @Override
    public Boolean uploadFile(String path, String fileName, MultipartFile file, HttpServletRequest request) {
        Boolean isSuccess;
        if (!file.isEmpty()){
            File saveFile=new File(path);
            if (!saveFile.exists()){
                saveFile.mkdirs();//文件夹不存在则创建
            }
            try {
                file.transferTo(new File(path,fileName));
            } catch (IOException e) {
                e.printStackTrace();
            }
            isSuccess=true;
        }
        else {
            isSuccess=false;
        }
        return isSuccess;
    }


    @Override
    public HashMap<String,HashMap<String,Integer>> statisticBasicData() {
        HashMap basicMap = new HashMap<String, HashMap<String, Integer>>();
        basicMap.put(ConstantConfig.RENTUSER_NAME,statisticRentUserMap());
        basicMap.put(ConstantConfig.SHOP_NAME,statisticShopMap());
        basicMap.put(ConstantConfig.CONTRACT_NAME,statisticContrasctMap());
        basicMap.put(ConstantConfig.STAFF_NAME,statisticStaffMap());
        return basicMap;
    }

    @Override
    public HashMap<String, Integer> statisticShopMap() {
        HashMap<String, Integer> shopMap = new HashMap<>();
        int total=shopMapper.getCountAll();
        int rent=shopMapper.queryShopCountRent();
        int free=total-rent;
        shopMap.put(ConstantConfig.SHOP_RENT,rent);
        shopMap.put(ConstantConfig.SHOP_TOTAL,total);
        shopMap.put(ConstantConfig.SHOP_FREE,free);
        return shopMap;
    }

    @Override
    public HashMap<String, Integer> statisticStaffMap() {
        HashMap<String, Integer> staffMap = new HashMap<>();
        staffMap.put(ConstantConfig.ADMIN_NAME,adminMapper.queryCountAdmin());
        staffMap.put(ConstantConfig.ASSISTANT_NAME,assistantMapper.queryCountAssistant());
        staffMap.put(ConstantConfig.MANGEER_NAME,managerMapper.queryCountManager());
        staffMap.put(ConstantConfig.RENTUSER_NAME,rentUserMapper.queryCountRentUser());
        return staffMap;
    }

    @Override
    public HashMap<String, Integer> statisticContrasctMap() {
        HashMap<String, Integer> contractMap = new HashMap<>();
        contractMap.put(ConstantConfig.CONTRACT_STATE_NORMAL,contractMapper.queryContractStateEqulsEffect());
        contractMap.put(ConstantConfig.CONTRACT_STATE_BEYOND,contractMapper.queryContractStateEqulsBeyondDate());
        contractMap.put(ConstantConfig.CONTRACT_TOTAL,contractMapper.queryEffectiveCountAll());
        contractMap.put(ConstantConfig.CONTRACT_STATE_SETTLE,contractMapper.queryContractStateEqulsSettle());
        return contractMap;
    }

    @Override
    public HashMap<String, Integer> statisticRentUserMap() {
        HashMap<String, Integer> rentUserMap = new HashMap<>();
        rentUserMap.put(ConstantConfig.RENTUSER_NAME,rentUserMapper.queryCountRentUser());
        return rentUserMap;
    }

    @Override
    public HashMap<String,int[]> statisticEcharData() {
        HashMap<String, int[]> echarMap = new HashMap<>();
        List<MonthAndCount> statList = contractMapper.queryStartDateByMonth();
        List<MonthAndCount> endList = contractMapper.queryEndDateByMonth();
        List<MonthAndCount> beyondList = contractMapper.queryBeyondDateByMonth();
//        //转化为Map
//        Map<String, Integer> eMap = endList.stream().collect(Collectors.toMap(MonthAndCount::getMonth, MonthAndCount::getCount
//                , (k1, k2) -> k2));
//        Map<String, Integer> sMap = statList.stream().collect(Collectors.toMap(MonthAndCount::getMonth,
//                MonthAndCount::getCount,(k1,k2)->k2));
        int[] sArr = transformArray(statList);
        int[] eArr = transformArray(endList);
        int[] bArr = transformArray(beyondList);
        echarMap.put(ConstantConfig.ECHAR_CONTRACT_START_TIME,sArr);
        echarMap.put(ConstantConfig.ECHAR_CONTRACT_END_TIME,eArr);
        echarMap.put(ConstantConfig.ECHAR_CONTRACT_BEYOND_TIME,bArr);
        return echarMap;
    }

    @Override
    public HashMap<String,HashMap<String,Integer>> statisticData() {
        ArrayList<HashMap<String, Integer>> list = new ArrayList<>();
        HashMap<String, HashMap<String, Integer>> basicData = statisticBasicData();
        return basicData;
    }

    /**
     * 将查询出的月份：数量 转化为数组 对应
     * @param list
     * @return
     */
    public int[] transformArray(List<MonthAndCount> list){
        int[] arr=new int[12];
        for (MonthAndCount n : list) {
           arr[Integer.valueOf(n.getMonth())-1]=n.getCount();
        }
        return arr;
    }


    /**
     * 创建并返回系统存储文件的目录
     * @return
     */
    public String getFileSavePath(){
        ApplicationHome home = new ApplicationHome(getClass());
        File sysfile = home.getSource();
        String path = sysfile.getParentFile().toString()+File.separator+"saveFile";
        File file = new File(path);
        if (!file.exists()){
            file.mkdir();
            file.mkdirs();
        }
        return path;
    }

    @Override
    public String createToken(String acount) {
        String token=null;
        token = UUID.randomUUID().toString()+acount;
        Jedis jedis = JedisUtil.getJedis();
        try {
            jedis.set(token,acount);
            jedis.expire(token,60*30);//过期时间为30分钟
        } catch (Exception e) {
            e.printStackTrace();
        }
        return token;
    }

    @Override
    public boolean verifyToken(String token) {
        Jedis jedis = JedisUtil.getJedis();
        String re = jedis.get(token);
        if (re!=null){
            return  true;
        }
        return false;
    }

    @Override
    @Scheduled(cron = "0  0  0 * * *")
    public void updateContractState() {
        contractMapper.updateContractStateByEndTime();
    }

    @Override
    public void destroyToken(String token) {
        Jedis jedis = JedisUtil.getJedis();
        jedis.del(token);
    }


    @Override
    public Map<String, String> uploadOnClient(MultipartFile file) {
        String host = "https://" + bucketName + "." + endPoint; // host的格式为 bucketname.endpoint
        String formatDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        String dir = formatDate + "/"; // 用户上传文件时指定的前缀。
        Map<String, String> respMap = new LinkedHashMap<String, String>();
        try {
            long expireTime = 30;
            long expireEndTime = System.currentTimeMillis() + expireTime * 1000;
            Date expiration = new Date(expireEndTime);
            PolicyConditions policyConds = new PolicyConditions();
            policyConds.addConditionItem(PolicyConditions.COND_CONTENT_LENGTH_RANGE, 0, 1048576000);
            policyConds.addConditionItem(MatchMode.StartWith, PolicyConditions.COND_KEY, dir);

            String postPolicy = oss.generatePostPolicy(expiration, policyConds);
            byte[] binaryData = postPolicy.getBytes("utf-8");
            String encodedPolicy = BinaryUtil.toBase64String(binaryData);
            String postSignature = oss.calculatePostSignature(postPolicy);

            respMap.put("accessid", accessKeyId);
            respMap.put("policy", encodedPolicy);
            respMap.put("signature", postSignature);
            respMap.put("dir", dir);
            respMap.put("host", host);
            respMap.put("expire", String.valueOf(expireEndTime / 1000));

        } catch (Exception e) {
            // Assert.fail(e.getMessage());
            logger.error(e.getMessage());
        } finally {
            oss.shutdown();
            logger.debug(new Date().getTime() + "上传文件：" + file.getName());
        }

        return respMap;
    }

    @Override
    public Boolean uploadOnServer(MultipartFile file) {
        Boolean isSuceess=false;
        try {
            oss.putObject(bucketName,file.getOriginalFilename(),file.getInputStream());
            isSuceess=true;
        } catch (IOException e) {
            logger.error("文件上传错误"+e.getMessage());
        }finally {
            oss.shutdown();
        }
        return isSuceess;
    }
}
