package com.ysu.webapi.controller;

import com.ysu.webapi.pojo.APINews;
import com.ysu.webapi.service.APINewsService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

public class APINewsController  {

    private APINewsService apiNewsService;

    //    根据指定的APINews id查找对应的APINews
    @ApiOperation(value="查找APINews", notes="输入APINews id，查询APINews，返回单个APINews对象")
    @ApiImplicitParam(name = "id", value = "管理员类详细实体admin", required = true, dataType = "int")
    @GetMapping("/")
    public APINews selectAPINewsById(int id){

    }

}
