package com.ysu.webapi.controller;

import com.ysu.webapi.pojo.APIInfo;
import com.ysu.webapi.service.APIInfoService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(value = "/api/apiInfo")
public class APIInfoController {

    @Autowired
    private APIInfoService apiInfoService;

    //    根据指定的APIInfo id查找对应的APIInfo
    @ApiOperation(value="查找APIInfo", notes="根据指定的API id查找对应的APIInfo，返回APIInfo")
    @ApiImplicitParam(name = "id", value = "APIInfo类属性id", required = true, dataType = "int")
    @GetMapping("/id")
    public APIInfo selectAPIInfoById(@RequestParam int id){
       return apiInfoService.selectAPIInfoById(id);
    }



    //    查找所有APIInfo
    @ApiOperation(value="查找全部APIInfo", notes="返回所有APIInfo对象")
    @GetMapping("/all")
    public List<APIInfo> selectAllAPIInfo(){
        return apiInfoService.selectAllAPIInfo();
    }

    //    更新指定apiId的APIInfo clickNum
    @ApiOperation(value="更新APIInfo clickNum", notes="输入API id，更新APIInfo，返回true")
    @ApiImplicitParam(name = "id", value = "APIInfo类属性id", required = true, dataType = "int")
    @PutMapping("/id/clickNum")
    public boolean updateAPIInfoClickNum(@RequestParam int id){
        System.out.println("开始更新指定apiId的APIInfo clickNum!");
        return apiInfoService.updateAPIInfoClickNum(id);
    }

    //    更新指定apiId的APIInfo collectionNum
    @ApiOperation(value="更新APIInfo collectionNum", notes="输入API id，更新APIInfo，返回true")
    @ApiImplicitParam(name = "id", value = "APIInfo类属性id", required = true, dataType = "int")
    @PutMapping("/id/collectionNum")
    public boolean updateAPIInfoCollectionNum(@RequestParam int id){
        System.out.println("开始更新指定apiId的APIInfo collectionNum!");
        return apiInfoService.updateAPIInfoCollectionNum(id);
    }

}
