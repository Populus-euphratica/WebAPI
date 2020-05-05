package com.ysu.webapi.controller;

import com.ysu.webapi.pojo.API;
import com.ysu.webapi.pojo.History;
import com.ysu.webapi.service.HistoryService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/history")
public class HistoryController {
    @Autowired
    private HistoryService historyService;

    //    根据用户id和历史记录进行推荐
    @ApiOperation(value = "根据用户id和历史记录进行推荐对应的API", notes = " 根据用户id和历史记录进行推荐，返回List<API>")
    @ApiImplicitParam(name = "userId", value = "查询值", required = true, dataType = "String")
    @GetMapping("/userId")
    public List<API> selectByUserId(@RequestParam String userId){
        System.out.println("开始根据用户id和历史记录进行推荐!");
        return historyService.selectByUserId(userId);
    }

    //添加历史记录
    @ApiOperation(value = "添加历史记录", notes = " 添加历史记录")
    @ApiImplicitParam(name = "history", value = "History的实体对象history", required = true, dataType = "History")
    @PostMapping("/")
    public boolean addHistory(@RequestBody History history){
        System.out.println("开始添加历史记录!");
        return historyService.addHistory(history);
    }
}
