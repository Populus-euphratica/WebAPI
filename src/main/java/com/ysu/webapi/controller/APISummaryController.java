package com.ysu.webapi.controller;

import com.ysu.webapi.pojo.APISummary;
import com.ysu.webapi.service.APISummaryService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/apiSummary")
public class APISummaryController {

    @Autowired
    private APISummaryService apiSummaryService;

    //    根据指定的API版本id查找该版本的详细信息
    @ApiOperation(value = "根据APIVersionsId查找API版本的详细信息", notes = "根据指定的APISummary id查找对应的APISummary，返回APISummary")
    @ApiImplicitParam(name = "APIVersionsId", value = "APISummary类属性APIVersionsId", required = true, dataType = "int")
    @GetMapping("/APIVersionsId")
    public APISummary selectAPISummaryDaoByAPIVersionsId(int APIVersionsId){
        return apiSummaryService.selectAPISummaryDaoByAPIVersionsId(APIVersionsId);
    }

    //为指定的API和API版本添加该版本的详细信息
    @ApiOperation(value = "添加APISummary", notes = "输入APISummary对象，创建APISummary，返回true")
    @ApiImplicitParam(name = "apiSummary", value = "APISummary类详细实体apiSummary", required = true, dataType = "APISummary")
    @PostMapping("/")
    public boolean addAPISummary(APISummary apiSummary){
        return apiSummaryService.addAPISummary(apiSummary);
    }

    //通过指定的版本信息id进行更新
    @ApiOperation(value = "更新指定id的APISummary版本", notes = "输入APISummary对象，更新APISummary，返回true")
    @ApiImplicitParam(name = "apiSummary", value = "APISummary类详细实体apiSummary", required = true, dataType = "APISummary")
    @PutMapping("/APIVersionsId")
    public boolean updateAPISummaryById(@RequestBody APISummary apiSummary){
        System.out.println("开始通过指定的版本信息id进行更新!");
//        System.out.println(json);
        return apiSummaryService.updateAPISummaryByAPIVersionsId(apiSummary);
//        return true;
    }


    //    删除指定id的apisummary
    @ApiOperation(value = "删除APISummary", notes = "删除指定id的APISummary")
    @ApiImplicitParam(name = "id", value = "APISummary类id", required = true, dataType = "int")
    @DeleteMapping("/id")
    public boolean deleteAPISummaryById(int id){
        return apiSummaryService.deleteAPISummaryById(id);
    }

    //    删除指定APIId的apisummary
    @ApiOperation(value = "删除APISummary", notes = "删除指定id的APISummary")
    @ApiImplicitParam(name = "APIId", value = "APISummary类APIId", required = true, dataType = "int")
    @DeleteMapping("/APIId")
    public boolean deleteAPISummaryByAPIId(int APIId){
        return apiSummaryService.deleteAPISummaryByAPIId(APIId);
    }

    //    删除指定APIVersionsId的apisummary
    @ApiOperation(value = "删除APISummary", notes = "删除指定id的APISummary")
    @ApiImplicitParam(name = "APIVersionsId", value = "APISummary类APIVersionsId", required = true, dataType = "int")
    @DeleteMapping("/APIVersionsId")
    public boolean deleteAPISummaryByAPIVersionsId(int APIVersionsId){
        return apiSummaryService.deleteAPISummaryByAPIVersionsId(APIVersionsId);
    }
}
