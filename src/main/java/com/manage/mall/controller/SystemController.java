package com.manage.mall.controller;

import com.manage.mall.dto.ContractDto;
import com.manage.mall.entitys.*;
import com.manage.mall.service.*;
import com.manage.mall.service.imp.EmailServiceImp;
import com.manage.mall.utils.DealString;
import com.manage.mall.vo.Email;
import com.manage.mall.vo.LoadVo;
import com.manage.mall.vo.Respose;
import org.apache.commons.io.FileUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("api/v1/common")
@RestController
@CrossOrigin
public class SystemController {

    @Autowired
    private ISystemService systemService;

    @Autowired
    private IMenuService menuService;

    @Autowired
    private IContractService contractService;

    @Autowired
    private IManagerService managerService;

    @Autowired
    private IRentUserService rentUserService;

    @Autowired
    private IAdminService adminService;

    @Autowired
    private EmailServiceImp emailServiceImp;

    private  static  final String LOGIN_TYPE_ADMIN="admin";
    private  static  final String LOGIN_TYPE_MANAGER="manager";
    private  static  final String LOGIN_TYPE_RENTUSEER="rentuser";


    /**
     * 注册
     *
     * @param acount
     */
    @RequestMapping("/login")
    public Respose login(Acount acount) {
        Respose re = new Respose();
        if (acount.getType().equals(LOGIN_TYPE_ADMIN)){
            Admin admin = new Admin();
            admin.setAAcount(acount.getAcount());
            admin.setAPassword(acount.getPassword());
            admin.setAPower(Long.valueOf(acount.getPower()));
            admin.setAEmail(acount.getEmail());
            adminService.loginAdmin(admin);
        }else if(acount.getType().equals(LOGIN_TYPE_MANAGER)) {
            Manager manager = new Manager();
            manager.setMName(acount.getAcount());
            manager.setMEmallAddress(acount.getEmail());
            manager.setMPower(Long.valueOf(acount.getPower()));
            manager.setMPassword(acount.getPassword());
            managerService.loginManager(manager);
        } else {
            RentUser rentUser = new RentUser();
            rentUser.setRName(acount.getAcount());
            rentUser.setREmailAddress(acount.getEmail());
            rentUser.setRPassword(acount.getPassword());
            rentUser.setRPower(Long.valueOf(acount.getPower()));
            rentUserService.loginRentUser(rentUser);
        }
        String EmailBody="";
        if (LOGIN_TYPE_ADMIN.equals(acount.getType())){
            EmailBody="<h4>Weclome to Regist</h4>" + "<h5>账 户 名 : <span>"+acount.getAcount()+"</span></h5>" +
                    "<h5>账户密码 : <span>"+acount.getPassword()+"</span></h5>";
        }
        else {
             EmailBody="<h4>Weclome to Regist</h4>" + "<h5>登录账户 : <span>"+acount.getEmail()+"</span></h5>" +
                    "<h5>账户密码 : <span>"+acount.getPassword()+"</span></h5>"+
                     "<h5>登录链接 : <a href='http://193.112.195.243:8020/'>"+"点我登录"+"</a></h5>"
             ;
        }
        Email email = Email.buildSystemEmail("注册账户",EmailBody, acount.getEmail());
        emailServiceImp.sendSimpleMail(email);
        return re.ResposeSuccess("注册成功");
    }

    /**
     * 用户登录
     *
     * @param acount
     */
    @RequestMapping("/load")
    public Respose load(Acount acount) {
        Respose re = new Respose<List>();
        re.setCode("Ok");
        LoadVo loadInfo = systemService.load(acount);
        if (loadInfo == null) {//登录失败
            re.ResposeFailed("登录失败");
        } else {
            String token = systemService.createToken(acount.getAcount());
            re.setToken(token);//
            if (loadInfo.getLoadCode() == 1) {
                Admin admin = (Admin) loadInfo.getLoadObject();
                re.setObject(admin);
            }
            if (loadInfo.getLoadCode() == 2) {
                Manager manager = (Manager) loadInfo.getLoadObject();
                re.setObject(manager);
            }
            if (loadInfo.getLoadCode() == 3) {
                RentUser rentUser = (RentUser) loadInfo.getLoadObject();
                re.setObject(rentUser);
            }
            //将菜单获取分离出来
            List<TMenu> menus = menuService.getAllMenuByAcountPower((int) loadInfo.getUserPower());
            re.ResposeSuccess(menus.size(), "登录成功", menus);
            System.out.println("*************-------------:"+menus.toArray().toString());

        }
        return re;
    }

    @RequestMapping(path = "/logout", method = RequestMethod.DELETE)
    public Respose logout(String name,HttpServletRequest request) {

        String token=request.getHeader("token");
        systemService.destroyToken(token);
        return Respose.bulid().ResposeSuccess("退出成功");
    }

    /**
     * 根据账户权限等级获取菜单
     *
     * @param power
     * @return
     */
    @RequestMapping("getHomeMenus")
    public Respose getHomeMenus(int power) {
        List<TMenu> menus = menuService.getAllMenuByAcountPower(power);
        return Respose.bulid().ResposeSuccess(menus.size(), "获取菜单", menus);
    }

    /**
     * 在后端上传合同文件至服务器本地
     *
     * @param file
     * @param request
     * @return
     */
    @RequestMapping(path = "/uploadFile")
    public Respose uploadFile(@RequestParam("file") MultipartFile file, HttpServletRequest request) {

        String fileSavePath = systemService.getFileSavePath();//文件存储路径
        String fileName = DealString.createFileName(file.getOriginalFilename(), "#");
        //上传文件
        Boolean isSuccess = systemService.uploadFile(fileSavePath, fileName, file, request);
        Contract contract=null;
        if (isSuccess){ //解析到数据库
            contract= contractService.resolveContractFile(file, fileSavePath,fileName);
            if (contract!=null){
                contractService.addContract(contract);
            }
        }

        return Respose.bulid().ResposeSuccess("上传成功！");
    }

    /**
     * 在服务器上传合同文件至阿里云
     *
     * @param file
     * @param request
     * @return
     */
    @RequestMapping(path = "/uploadFile/server")
    public Respose uploadFileOnServerToOSS(@RequestParam("file") MultipartFile file, HttpServletRequest request) {

        //路径需要改成阿里云的访问路径
        String fileSavePath = systemService.getFileSavePath();//文件存储路径
        String fileName = DealString.createFileName(file.getOriginalFilename(), "#");
        //上传文件
        Boolean isUpload = systemService.uploadOnServer(file);
        Contract contract=null;
        if (isUpload){ //解析到数据库
            contract= contractService.resolveContractFile(file, fileSavePath,fileName);
            if (contract!=null){
                contractService.addContract(contract);
            }
        }
        return Respose.bulid().ResposeSuccess("上传成功");
    }


    /**
     * 获取上传签名
     * @param file
     * @param request
     * @return
     */
    @RequestMapping(path = "/getPolicy")
    public Respose uploadFileOnClientToOSS(@RequestParam("file") MultipartFile file, HttpServletRequest request) {

        String fileSavePath = "阿里云路径";//文件存储路径
        //上传文件
        Map map = systemService.uploadOnClient(file);
        Contract contract=null;
        if (map!=null && map.size()>0){ //解析到数据库
            contract= contractService.resolveContractFile(file, fileSavePath,file.getOriginalFilename());
            if (contract!=null){
                contractService.addContract(contract);
            }
        }
        return Respose.bulid().ResposeSuccess(1,"获取成功",map);
    }







    /**
     * 根据合同id下载合同文件
     * @param id
     * @return
     */
    @RequestMapping(path ="download")
    public ResponseEntity<byte[]> downloadResume(@Param("id") Long id) throws UnsupportedEncodingException {
        ContractDto contract = contractService.getContractById(id);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        String filename = new String(new String(contract.getcFileName()).getBytes(Charset.forName("utf-8")), "iso-8859-1");//中文文件名乱码问题
        httpHeaders.setContentDispositionFormData("name",filename);

        File file = new File(contract.getcPath());
        ResponseEntity<byte[]> responseEntity = null;
        try {
            responseEntity = new ResponseEntity<>(FileUtils.readFileToByteArray(file), httpHeaders, HttpStatus.CREATED);
        } catch (IOException e) {
            System.out.println("下载文件出错啦 :"+e);
        }
        return responseEntity;
    }

    /**
     * 查新统计页的数据
     * @return
     */
    @RequestMapping(path = "getStatisticData",method = RequestMethod.GET)
    public Respose getbasicData(){
        HashMap data = systemService.statisticData();
        return Respose.bulid().ResposeSuccess(data.size(),data);
    }


    @RequestMapping(path = "getStatisticEcharData",method = RequestMethod.GET)
    public Respose getStatisticEcharData(){
        HashMap data = systemService.statisticEcharData();
        return Respose.bulid().ResposeSuccess(data.size(),data);
    }








}
