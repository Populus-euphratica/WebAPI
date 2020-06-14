package com.ysu.webapi.controller;


import com.ysu.webapi.pojo.Admin;
import com.ysu.webapi.service.AdminService;
import com.ysu.webapi.service.ApplyForAdminService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.common.profile.HttpProfile;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;

import com.tencentcloudapi.captcha.v20190722.CaptchaClient;

import com.tencentcloudapi.captcha.v20190722.models.DescribeCaptchaResultRequest;
import com.tencentcloudapi.captcha.v20190722.models.DescribeCaptchaResultResponse;


@RestController
@RequestMapping(value = "/api/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;


    @ApiOperation(value = "添加管理员", notes = "输入Admin对象，创建管理员，返回true")
    @ApiImplicitParam(name = "admin", value = "管理员类详细实体admin", required = true, dataType = "Admin")
    @PostMapping("/")
    public boolean addAdmin(@RequestBody Admin admin) {
        System.out.println("开始添加管理员!");
        return adminService.addAdmin(admin);
    }


    //    更新管理员用户名
    @ApiOperation(value = "更新管理员用户名", notes = "输入Admin对象 name,id，更新管理员用户名，返回true")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "管理员Id", required = true, paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "name", value = "管理员name", required = true, paramType = "query", dataType = "String")
    })
    @PutMapping("/name/id")
    boolean updateAdminName(@RequestParam String name,@RequestParam int id){
        System.out.println("开始更新管理员名!");
        return adminService.updateAdminName(name, id);
    }

    //    更新管理员密码
    @ApiOperation(value = "更新管理员密码", notes = "输入Admin对象 password id，更新管理员密码，返回true")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "管理员Id", required = true, paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "password", value = "管理员password", required = true, paramType = "query", dataType = "String")
    })
    @PutMapping("/password/id")
    boolean updateAdminPassword(@RequestParam String password,@RequestParam int id){
        System.out.println("开始更新管理员密码!");
        return adminService.updateAdminPassword(password, id);
    }
    @ApiOperation(value = "查找全部管理员", notes = "返回所有Admin对象")
    @GetMapping("/all")
    public List<Admin> selectAllAdmin() {
        System.out.println("开始查找所有管理员！");
        return adminService.selectAllAdmin();
    }

    @ApiOperation(value = "按照管理员ID查找管理员", notes = "输入管理员ID ，查询管理员，返回单个Admin对象")
    @ApiImplicitParam(name = "id", value = "管理员Id", required = true, paramType = "query", dataType = "int")
    @GetMapping("/id")
    public Admin selectByIdAdmin(@RequestParam int id) {
        System.out.println("开始查找指定管理员！");
        return adminService.selectByIdAdmin(id);
    }


    //    按照账号查询指定用户
    @ApiOperation(value = "按照管理员email查找管理员", notes = "输入管理员email ，查询管理员，返回单个Admin对象")
    @ApiImplicitParam(name = "email", value = "管理员email", required = true, paramType = "query", dataType = "String")
    @GetMapping("/email")
    public Admin selectByEmailAdmin(@RequestParam String email) {
        return adminService.selectByEmailAdmin(email);
    }

    @ApiOperation(value = "验证登陆", notes = "输入管理员账号，查询管理员，返回单个Admin对象")
    @ApiImplicitParam(name = "admin1", value = "管理员类详细实体admin", required = true, dataType = "Admin")
    @PostMapping("/login")
    public boolean loginAdmin(@RequestBody Admin admin1) {
        System.out.println("开始匹配指定管理员账号密码是否正确！");
        Admin admin = adminService.selectByEmailAdmin(admin1.getEmail());
        if (admin.getPassword().equals(admin1.getPassword())) {
            System.out.println("admin账号正确");
            return true;
        }
        return false;
    }


    //     获取未读消息总和
    @ApiOperation(value = "获取未读消息总和", notes = "获取未读消息总和，返回int类型总数")
    @GetMapping("/message/sum")
    public int selectMessageSum() {
        return adminService.selectMessageSum();
    }

    //更新申请状态及添加管理员
    @ApiOperation(value = "更新申请状态及添加管理员", notes = "输入Admin对象及ApplyForAdmin类属性decide，id，创建管理员，返回true")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "ApplyForAdmin类详属性id", required = true, dataType = "int"),
            @ApiImplicitParam(name = "admin", value = "管理员类详细实体admin", required = true, dataType = "Admin")
    })
    @PostMapping("/apply")
    public boolean updateApplyAndAddAdmin(@RequestParam int id, @RequestBody Admin admin) {
        System.out.println("开始更新申请状态及添加管理员！");
        return adminService.updateApplyAndAddAdmin(id,admin);
    }


    @PostMapping("/loginVerify")
    public void loginVAdmin(@RequestParam String ticket, @RequestParam String randstr, @RequestParam String userIp) {
        try {
            Credential cred = new Credential("xxxx", "xxxx");

            HttpProfile httpProfile = new HttpProfile();
            httpProfile.setEndpoint("captcha.tencentcloudapi.com");

            ClientProfile clientProfile = new ClientProfile();
            clientProfile.setHttpProfile(httpProfile);

            CaptchaClient client = new CaptchaClient(cred, "", clientProfile);

            String params = "{\"CaptchaType\":9,\"Ticket\":" + ticket + ",\"UserIp\":" + userIp + ",\"Randstr\":" + randstr + ",\"CaptchaAppId\":xxxxxx,\"AppSecretKey\":\"xxxxx**\"}";
            DescribeCaptchaResultRequest req = DescribeCaptchaResultRequest.fromJsonString(params, DescribeCaptchaResultRequest.class);

            DescribeCaptchaResultResponse resp = client.DescribeCaptchaResult(req);

            System.out.println(DescribeCaptchaResultRequest.toJsonString(resp));
        } catch (TencentCloudSDKException e) {
            System.out.println(e.toString());
        }

    }


}
