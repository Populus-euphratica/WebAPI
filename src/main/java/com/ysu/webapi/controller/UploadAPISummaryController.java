package com.ysu.webapi.controller;

import com.ysu.webapi.pojo.UploadAPISummary;
import com.ysu.webapi.service.UploadAPISummaryService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/uploadSummary")
public class UploadAPISummaryController {

    @Autowired
    private UploadAPISummaryService apiSummaryService;

    //    根据指定的API版本id查找该版本的详细信息
    @ApiOperation(value = "根据APIVersionsId查找API版本的详细信息", notes = "根据指定的APISummary id查找对应的APISummary，返回APISummary")
    @ApiImplicitParam(name = "APIVersionsId", value = "UploadAPISummary类属性APIVersionsId", required = true, dataType = "int")
    @GetMapping("/APIVersionsId")
    public UploadAPISummary selectUploadAPISummaryDaoByAPIVersionsId(int APIVersionsId){
        return apiSummaryService.selectUploadAPISummaryDaoByAPIVersionsId(APIVersionsId);
    }

    //为指定的API和API版本添加该版本的详细信息
    @ApiOperation(value = "添加APISummary", notes = "输入APISummary对象，创建APISummary，返回true")
    @ApiImplicitParam(name = "apiSummary", value = "APISummary类详细实体apiSummary", required = true, dataType = "UploadAPISummary")
    @PostMapping("/")
    public boolean addAPISummary(UploadAPISummary apiSummary){
        return apiSummaryService.addUploadAPISummary(apiSummary);
    }

    //通过指定的版本信息id进行更新
    @ApiOperation(value = "更新指定id的APISummary版本", notes = "输入APISummary对象，更新APISummary，返回true")
    @ApiImplicitParam(name = "apiSummary", value = "APISummary类详细实体apiSummary", required = true, dataType = "UploadAPISummary")
    @PutMapping("/APIVersionsId")
    public boolean updateAPISummaryById(@RequestBody UploadAPISummary apiSummary){
        System.out.println("开始通过指定的版本信息id进行更新!");
//        System.out.println(json);
        return apiSummaryService.updateUploadAPISummaryByAPIVersionsId(apiSummary);
//        return true;
    }


    //    删除指定id的apisummary
    @ApiOperation(value = "删除APISummary", notes = "删除指定id的APISummary")
    @ApiImplicitParam(name = "id", value = "APISummary类id", required = true, dataType = "int")
    @DeleteMapping("/id")
    public boolean deleteUploadAPISummaryById(int id){
        return apiSummaryService.deleteUploadAPISummaryById(id);
    }

    //    删除指定APIId的apisummary
    @ApiOperation(value = "删除APISummary", notes = "删除指定id的APISummary")
    @ApiImplicitParam(name = "APIId", value = "APISummary类APIId", required = true, dataType = "int")
    @DeleteMapping("/APIId")
    public boolean deleteUploadAPISummaryByAPIId(int APIId){
        return apiSummaryService.deleteUploadAPISummaryByAPIId(APIId);
    }

    //    删除指定APIVersionsId的apisummary
    @ApiOperation(value = "删除APISummary", notes = "删除指定id的APISummary")
    @ApiImplicitParam(name = "APIVersionsId", value = "APISummary类APIVersionsId", required = true, dataType = "int")
    @DeleteMapping("/APIVersionsId")
    public boolean deleteUploadAPISummaryByAPIVersionsId(int APIVersionsId){
        return apiSummaryService.deleteUploadAPISummaryByAPIVersionsId(APIVersionsId);
    }
}
