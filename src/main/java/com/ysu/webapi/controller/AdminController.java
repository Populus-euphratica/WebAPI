package com.ysu.webapi.controller;


import com.ysu.webapi.pojo.Admin;
import com.ysu.webapi.service.AdminService;
import io.swagger.annotations.ApiImplicitParam;
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

    @ApiOperation(value="添加管理员", notes="输入Admin对象，创建管理员，返回true")
    @ApiImplicitParam(name = "admin", value = "管理员类详细实体admin", required = true, dataType = "Admin")
    @PostMapping("/")
    public boolean addAdmin(@RequestBody Admin admin){
        System.out.println("开始添加管理员!");
        return adminService.addAdmin(admin);
    }


    @ApiOperation(value="更新管理员", notes="输入Admin对象，更新管理员，返回true")
    @ApiImplicitParam(name = "admin", value = "管理员类详细实体admin", required = true, dataType = "Admin")
    @PutMapping("/")
    public boolean updateAdmin(@RequestBody Admin admin){
        System.out.println("开始更新指定管理员信息！");
        return adminService.updateAdmin(admin);
    }

    @ApiOperation(value="查找全部管理员", notes="返回所有Admin对象")
    @GetMapping("/all")
    public List<Admin> selectAllAdmin(){
        System.out.println("开始查找所有管理员！");
        return adminService.selectAllAdmin();
    }

    @ApiOperation(value="按照管理员ID查找管理员", notes="输入管理员ID ，查询管理员，返回单个Admin对象")
    @ApiImplicitParam(name = "id", value = "管理员Id", required = true, paramType = "query", dataType = "int")
    @GetMapping("/id")
    public Admin selectByIdAdmin(@RequestParam int id){
        System.out.println("开始查找指定管理员！");
        return adminService.selectByIdAdmin(id);
    }

    @ApiOperation(value="验证登陆", notes="输入管理员账号，查询管理员，返回单个Admin对象")
    @ApiImplicitParam(name = "admin1", value = "管理员类详细实体admin", required = true, dataType = "Admin")
    @PostMapping("/login")
    public boolean loginAdmin(@RequestBody Admin admin1){
        System.out.println("开始匹配指定管理员账号密码是否正确！");
        Admin admin=adminService.selectByEmailAdmin(admin1.getEmail());
        if (admin.getPassword().equals(admin1.getPassword())){
            System.out.println("admin账号正确");
            return true;
        }
        return false;
    }

    @PostMapping("/loginVerify")
    public void loginVAdmin(@RequestParam String ticket,@RequestParam String randstr,@RequestParam String userIp){
        try{
            Credential cred = new Credential("AKID35u74I52Wo33TdtCb8QTHq9C3efdxr89", "xpRRBgwxlKly2rQlqjOxHQKyNWQ4f2FC");

            HttpProfile httpProfile = new HttpProfile();
            httpProfile.setEndpoint("captcha.tencentcloudapi.com");

            ClientProfile clientProfile = new ClientProfile();
            clientProfile.setHttpProfile(httpProfile);

            CaptchaClient client = new CaptchaClient(cred, "", clientProfile);

            String params = "{\"CaptchaType\":9,\"Ticket\":"+ticket+",\"UserIp\":"+userIp+",\"Randstr\":"+randstr+",\"CaptchaAppId\":2029808606,\"AppSecretKey\":\"0p6q41uiVBWdE9dQhvuvTZw**\"}";
            DescribeCaptchaResultRequest req = DescribeCaptchaResultRequest.fromJsonString(params, DescribeCaptchaResultRequest.class);

            DescribeCaptchaResultResponse resp = client.DescribeCaptchaResult(req);

            System.out.println(DescribeCaptchaResultRequest.toJsonString(resp));
        } catch (TencentCloudSDKException e) {
            System.out.println(e.toString());
        }

    }


}
