package com.ysu.webapi.controller;

import com.github.pagehelper.PageInfo;
import com.ysu.webapi.pojo.UserInfo;
import com.ysu.webapi.service.UserInfoService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping(value = "/api/userInfo")
public class UserInfoController {
    @Autowired
    private UserInfoService userInfoService;
    private int pageSize=5;
    //    根据指定的userInfo id查找对应的userInfo
    @ApiOperation(value="通过id查找UserInfo", notes="输入UserInfo id，查询User，返回单个UserInfo对象")
    @ApiImplicitParam(name = "id", value = "UserInfo类id", required = true, dataType = "int")
    @GetMapping("/id")
    public UserInfo selectUserInfoById(@RequestParam int id){
        return userInfoService.selectUserInfoById(id);
    }


    //    根据指定的userInfo id查找对应的userConcern
    @ApiOperation(value="通过id查找UserInfo对应的userConcern", notes="输入UserInfo id，查询User，返回对应的userConcern")
    @ApiImplicitParam(name = "id", value = "UserInfo类id", required = true, dataType = "int")
    @GetMapping("/concern/id")
    public String selectUserInfoByIdToConcern(int id){
        return userInfoService.selectUserInfoByIdToConcern(id);
    }

    //    根据指定的userInfo id查找对应的userUpload
    @ApiOperation(value="通过id查找UserInfo对应的userUpload", notes="输入UserInfo id，查询User，返回对应的userUpload")
    @ApiImplicitParam(name = "id", value = "UserInfo类id", required = true, dataType = "int")
    @GetMapping("/upload/id")
    public String selectUserInfoByIdToUpload(int id){
        return userInfoService.selectUserInfoByIdToUpload(id);
    }

    //    查找所有userInfo
    @ApiOperation(value="查找所有UserInfo", notes="查找所有UserInfo")
    @ApiImplicitParam(name = "pageNum", value = "显示页数", required = true, dataType = "int")
    @GetMapping("/")
    public PageInfo<UserInfo> selectUserInfoAll(@RequestParam int pageNum){
        return userInfoService.selectUserInfoAll(pageNum, pageSize);
    }





    //    更新userInfo Concern信息
    @ApiOperation(value="更新UserInfo", notes="输入UserInfo对象，更新UserInfo concern，返回true")
    @ApiImplicitParam(name = "userInfo", value = "UserInfo类详细实体userInfo", required = true, dataType = "UserInfo")
    @PutMapping("/concern")
    public boolean updateUserInfoConcern(@RequestBody UserInfo userInfo){
        return userInfoService.updateUserInfoConcern(userInfo);
    }

    //    更新userInfo Upload信息
    @ApiOperation(value="更新UserInfo", notes="输入UserInfo对象，更新UserInfo upload，返回true")
    @ApiImplicitParam(name = "userInfo", value = "UserInfo类详细实体userInfo", required = true, dataType = "UserInfo")
    @PutMapping("/upload")
    public boolean updateUserInfoUpload(@RequestBody UserInfo userInfo){
        return userInfoService.updateUserInfoUpload(userInfo);
    }
}