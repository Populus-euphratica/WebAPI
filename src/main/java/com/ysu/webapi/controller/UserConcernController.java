package com.ysu.webapi.controller;

import com.github.pagehelper.PageInfo;
import com.ysu.webapi.pojo.API;
import com.ysu.webapi.pojo.UserConcern;
import com.ysu.webapi.service.UserConcernService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/userConcern")
public class UserConcernController {
    @Autowired
    private UserConcernService userConcernService;
    private int pageSize = 5;
//    //    根据指定的userConcern id查找对应的userConcern
//    @ApiOperation(value="通过id查找UserConcern", notes="输入UserConcern id，查询User，返回单个UserConcern对象")
//    @ApiImplicitParam(name = "id", value = "UserConcern类id", required = true, dataType = "int")
//    @GetMapping("/id")
//    public UserConcern selectUserConcernById(@RequestParam int id){
//        System.out.println("开始根据指定的userConcern id查找对应的userConcern！");
//        return userConcernService.selectUserConcernById(id);
//    }


    //    根据指定的userConcern userId查找对应的userConcern
    @ApiOperation(value = "通过id查找UserConcern对应的userConcern", notes = "输入UserConcern userId，查询User，返回对应的userConcern")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "UserConcern类userId", required = true, dataType = "int"),
            @ApiImplicitParam(name = "pageNum", value = "显示页数", required = true, dataType = "int")
    })
    @GetMapping("/userId")
    public PageInfo<API> selectUserConcernByUserId(@RequestParam int userId, @RequestParam int pageNum) {
        System.out.println("开始根据指定的userConcern userId查找对应的userConcern！");
        return userConcernService.selectUserConcernByUserId(userId, pageNum, pageSize);
    }


    @ApiOperation(value = "通过id查找UserConcern对应的userConcern", notes = "输入UserConcern userId，查询User，返回对应的userConcern")
    @ApiImplicitParam(name = "userId", value = "UserConcern类userId", required = true, dataType = "int")
    @GetMapping("/userId/all")
    public List<UserConcern> selectUserConcernByUserIdALL(int userId){
        System.out.println("开始根据指定的userConcern userId查找对应的userConcern不分页！");
        return userConcernService.selectUserConcernByUserIdALL(userId);
    }

    //    查找所有userConcern
    @ApiOperation(value = "查找所有UserConcern", notes = "查找所有UserConcern")
    @ApiImplicitParam(name = "pageNum", value = "显示页数", required = true, dataType = "int")
    @GetMapping("/")
    public PageInfo<UserConcern> selectUserConcernAll(@RequestParam int pageNum) {
        System.out.println("开始查找所有userConcern！");
        return userConcernService.selectUserConcernAll(pageNum, pageSize);
    }

    //    添加userConcern
    @ApiOperation(value = "添加UserConcern", notes = "添加UserConcern")
    @ApiImplicitParam(name = "userConcern", value = "UserConcern", required = true, dataType = "UserConcern")
    @PostMapping("/")
    public int addUserConcern(@RequestBody UserConcern userConcern) {
        System.out.println("开始添加userConcern！");
        return userConcernService.addUserConcern(userConcern);
    }


    //    删除指定id的userConcern
    @ApiOperation(value = "删除指定id的UserConcern", notes = "删除指定id的UserConcern")
    @ApiImplicitParam(name = "id", value = "UserConcern属性id", required = true, dataType = "int")
    @DeleteMapping("/id")
    public boolean deleteUserConcernById(@RequestParam int id) {
        System.out.println("开始删除指定id的userConcern！");
        return userConcernService.deleteUserConcernById(id);
    }

}
