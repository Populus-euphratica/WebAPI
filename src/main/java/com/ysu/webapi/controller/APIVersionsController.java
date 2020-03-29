package com.ysu.webapi.controller;

import com.ysu.webapi.pojo.APISummary;
import com.ysu.webapi.pojo.APIVS;
import com.ysu.webapi.pojo.APIVersions;
import com.ysu.webapi.service.APIVersionsService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/apiVersions")
public class APIVersionsController {

    @Autowired
    private APIVersionsService apiVersionsService;

    //    根据id查找API版本
    @ApiOperation(value = "根据id查找API版本", notes = "根据指定的APIVersions id查找对应的API版本，返回API版本")
    @ApiImplicitParam(name = "id", value = "APIVersions类属性id", required = true, dataType = "int")
    @GetMapping("/id")
    public APIVersions selectAPIVersionsById(int id){
        System.out.println("开始根据id查找API版本！");
        return apiVersionsService.selectAPIVersionsById(id);
    }

    //    根据APIId查找API版本
    @ApiOperation(value = "根据APIId查找API版本", notes = "根据指定的APIVersions APIId查找对应的API版本，返回API版本")
    @ApiImplicitParam(name = "APIId", value = "APIVersions类属性APIId", required = true, dataType = "int")
    @GetMapping("/APIId")
    public List<APIVersions> selectAPIVersionsByAPIId(@RequestParam int APIId){
        System.out.println("开始根据APIId查找API版本！");
        return apiVersionsService.selectAPIVersionsByAPIId(APIId);
    }

    //    添加API版本
    @ApiOperation(value = "添加API版本", notes = "输入API版本对象，创建APIVersions，返回true")
    @ApiImplicitParam(name = "apivs", value = "APIVS类是由APIVersions和APISummary组成的", required = true, dataType = "APIVS")
    @PostMapping("/")
    public boolean addAPIVersions(@RequestBody APIVS apivs){
        System.out.println("开始添加API版本！");
        return apiVersionsService.addAPIVersions(apivs.getApiVersions(),apivs.getApiSummary());
    }

    //    更新指定id的API版本
    @ApiOperation(value = "更新指定id的APIVersions版本", notes = "输入APIVersions对象，更新APIVersions，返回true")
    @ApiImplicitParam(name = "apivs", value = "APIVS类是由APIVersions和APISummary组成的", required = true, dataType = "APIVS")
    @PutMapping("/id")
    public boolean updateAPIVersions(@RequestBody APIVS apivs){
        System.out.println("开始更新指定id的API版本！");
        System.out.println(apivs.getApiSummary().getPrimaryCategory());
        System.out.println(apivs.getApiSummary().getAPIVersionsId());
        return apiVersionsService.updateAPIVersions(apivs.getApiVersions(),apivs.getApiSummary());
    }

    //    删除指定id的API版本
    @ApiOperation(value = "删除APIVersions", notes = "删除指定id的APIVersions")
    @ApiImplicitParam(name = "id", value = "APIVersions类id", required = true, dataType = "int")
    @DeleteMapping("/id")
    public boolean deleteAPIVersionsById(int id,String logo){
        System.out.println("开始删除指定id的API版本！");
        return apiVersionsService.deleteAPIVersionsById(id,logo);
    }

    //    删除指定APIId的API版本
    @ApiOperation(value = "删除APIId", notes = "删除指定id的APIId")
    @ApiImplicitParam(name = "id", value = "APIId类id", required = true, dataType = "int")
    @DeleteMapping("/APIId")
    public boolean deleteAPIVersionsByAPIId(int APIId){
        System.out.println("删除指定APIId的API版本！");
        return apiVersionsService.deleteAPIVersionsByAPIId(APIId);
    }
}
