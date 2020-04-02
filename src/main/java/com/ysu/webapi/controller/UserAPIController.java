package com.ysu.webapi.controller;

import com.github.pagehelper.PageInfo;
import com.ysu.webapi.pojo.API;
import com.ysu.webapi.pojo.UserAPI;
import com.ysu.webapi.service.UserAPIService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/userAPI")
public class UserAPIController {
    private int pageSize=5;
    @Autowired
    private UserAPIService userAPIService;


    @ApiOperation(value = "根据用户id查找用户上传的api", notes = "根据用户id查找用户上传的api")
    @ApiImplicitParam(name = "userId", value = "API类详细实体api", required = true, dataType = "int")
    @GetMapping("/")
    public PageInfo<API> selectUserAPIByUserId(int userId, int pageNum){
        return userAPIService.selectUserAPIByUserId(userId,pageNum,pageSize);
    }
}
