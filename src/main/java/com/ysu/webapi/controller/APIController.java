package com.ysu.webapi.controller;

import com.github.pagehelper.PageInfo;
import com.ysu.webapi.pojo.API;
import com.ysu.webapi.service.APIService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.ysu.webapi.WebapiApplication.pageSize;


@RestController
@RequestMapping(value = "/api/api")
public class APIController {
    @Autowired
    private APIService apiService;

    //    根据指定的API id查找对应的API
    @ApiOperation(value="查找API", notes="根据指定的API id查找对应的API，返回API")
    @ApiImplicitParam(name = "id", value = "API类属性id", required = true, dataType = "int")
    @GetMapping("/id")
    public API selectAPIById(@RequestParam int id){
        System.out.println("开始根据指定的API id查找对应的API！");
        return apiService.selectAPIById(id);
    }

    //    根据指定的API name查找对应的API
    @ApiOperation(value="查找API", notes="根据指定的API name查找对应的API，返回API")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "API类属性name", required = true, dataType = "String"),
            @ApiImplicitParam(name = "pageNum", value = "显示页数", required = true, dataType = "int")
    })
    @GetMapping("/name")
    public PageInfo<API> selectAPIByName(@RequestParam String name,@RequestParam int pageNum){
        System.out.println("开始根据指定的API name查找对应的API！");
        return apiService.selectAPIByName(name,pageNum,pageSize);
    }

    //    根据指定的API category查找对应的API
    @ApiOperation(value="查找API", notes="根据指定的API category查找对应的API，返回API")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "category", value = "API类属性category", required = true, dataType = "String"),
            @ApiImplicitParam(name = "pageNum", value = "显示页数", required = true, dataType = "int")
    })
    @GetMapping("/category")
    public PageInfo<API> selectAPIByCategory(@RequestParam String category,@RequestParam int pageNum){
        System.out.println("开始根据指定的API category查找对应的API！");
        return apiService.selectAPIByCategory(category,pageNum,pageSize);
    }



    // 全部匹配
    @ApiOperation(value="全部匹配查找API", notes="根据指定的val启用全部匹配从name和category中模糊匹配查找对应的API，返回符合的API")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "val", value = "查询值", required = true, dataType = "String"),
            @ApiImplicitParam(name = "pageNum", value = "显示页数", required = true, dataType = "int")
    })
    @GetMapping("/all")
    public PageInfo<API> selectAPIByAll(String val,int pageNum){
        System.out.println("开始根据指定的val启用全部匹配从name和category中模糊匹配查找对应的API！");
        return apiService.selectAPIByAll(val,pageNum,pageSize);
    }





    //    查找所有API
    @ApiOperation(value="查找所有API", notes="查找所有API")
    @ApiImplicitParam(name = "pageNum", value = "显示页数", required = true, dataType = "int")
    @GetMapping("/")
    public PageInfo<API> selectAllAPI(@RequestParam int pageNum){
        System.out.println("开始查找所有API！");
        return apiService.selectAllAPI(pageNum,pageSize);
    }

    //     添加api
    @ApiOperation(value="添加API", notes="输入API对象，创建API，返回true")
    @ApiImplicitParam(name = "api", value = "API类详细实体api", required = true, dataType = "API")
    @PostMapping("/")
    public boolean addAPI(@RequestBody API api){
        System.out.println("开始添加api！");
        return apiService.addAPI(api);
    }

    //    更新指定id的API
    @ApiOperation(value="更新API", notes="输入API对象，更新API，返回true")
    @ApiImplicitParam(name = "api", value = "API类详细实体api", required = true, dataType = "API")
    @PutMapping("/id")
    public boolean updateAPI(@RequestBody API api){
        System.out.println("开始更新指定id的API！");
        return apiService.updateAPI(api);
    }

    //    删除指定id的API
    @ApiOperation(value="删除API", notes="删除指定id的API")
    @ApiImplicitParam(name = "id", value = "API类id", required = true, dataType = "int")
    @DeleteMapping("/id")
    public boolean deleteAPIById(@RequestParam String id){
        System.out.println("开始删除指定id的API！");
        return apiService.deleteAPIById(id);
    }
}
