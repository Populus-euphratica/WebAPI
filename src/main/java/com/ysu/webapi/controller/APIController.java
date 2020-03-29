package com.ysu.webapi.controller;

import com.github.pagehelper.PageInfo;
import com.ysu.webapi.pojo.API;
import com.ysu.webapi.pojo.APISummary;
import com.ysu.webapi.pojo.APIVersions;
import com.ysu.webapi.service.APIService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/api/api")
public class APIController {
    @Autowired
    private APIService apiService;

    //    根据指定的API id查找对应的API
    @ApiOperation(value = "查找API", notes = "根据指定的API id查找对应的API，返回API")
    @ApiImplicitParam(name = "id", value = "API类属性id", required = true, dataType = "int")
    @GetMapping("/id")
    public API selectAPIById(@RequestParam int id) {
        System.out.println("开始根据指定的API id查找对应的API！");
        return apiService.selectAPIById(id);
    }

    //    根据指定的API name查找对应的API
    @ApiOperation(value = "查找API", notes = "根据指定的API name查找对应的API，返回API")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "API类属性name", required = true, dataType = "String"),
            @ApiImplicitParam(name = "pageNum", value = "显示页数", required = true, dataType = "int")
    })
    @GetMapping("/name")
    public PageInfo<API> selectAPIByName(@RequestParam String name, @RequestParam int pageNum, @RequestParam int pageSize) {
        System.out.println("开始根据指定的API name查找对应的API！");
        return apiService.selectAPIByName(name, pageNum, pageSize);
    }

    //    根据指定的API category查找对应的API
    @ApiOperation(value = "查找API", notes = "根据指定的API category查找对应的API，返回API")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "category", value = "API类属性category", required = true, dataType = "String"),
            @ApiImplicitParam(name = "pageNum", value = "显示页数", required = true, dataType = "int")
    })
    @GetMapping("/category")
    public PageInfo<API> selectAPIByCategory(@RequestParam String category, @RequestParam int pageNum, @RequestParam int pageSize) {
        System.out.println("开始根据指定的API category查找对应的API！");
        return apiService.selectAPIByCategory(category, pageNum, pageSize);
    }


    // 全部模糊匹配
    @ApiOperation(value = "全部模糊匹配查找API", notes = "根据指定的val启用全部模糊匹配从name和category中模糊匹配查找对应的API，返回符合的API")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "val", value = "查询值", required = true, dataType = "String"),
            @ApiImplicitParam(name = "pageNum", value = "显示页数", required = true, dataType = "int")
    })
    @GetMapping("/all")
    public PageInfo<API> selectAPIByAll(@RequestParam String val, @RequestParam int pageNum, @RequestParam int pageSize) {
        System.out.println("开始根据指定的val启用全部模糊匹配从name和category中模糊匹配查找对应的API！");
        return apiService.selectAPIByAll(val, pageNum, pageSize);
    }


    //    根据APIInfo clickNum查找排名靠前API
    @ApiOperation(value = "查找APIInfo clickNum排名靠前APIInfo", notes = "根据指定的API clickNum查找排名靠前的APIInfo，返回APIInfo")
    @GetMapping("/recommend/clickNum")
    public List<API> selectAPIInfoByClickNum() {
        System.out.println("根据APIInfo clickNum查找排名靠前API");
        return apiService.selectAPIInfoByClickNum();
    }

    //    根据APIInfo collectionNum查找排名靠前API
    @ApiOperation(value = "查找APIInfo collectionNum排名靠前APIInfo", notes = "根据指定的API collectionNum查找排名靠前的APIInfo，返回APIInfo")
    @GetMapping("/recommend/collectionNum")
    public List<API> selectAPIInfoByCollectionNum() {
        System.out.println("根据APIInfo collectionNum查找排名靠前API");
        return apiService.selectAPIInfoByCollectionNum();
    }


    //    查找所有API
    @ApiOperation(value = "查找所有API", notes = "查找所有API")
    @ApiImplicitParam(name = "pageNum", value = "显示页数", required = true, dataType = "int")
    @GetMapping("/")
    public PageInfo<API> selectAllAPI(@RequestParam int pageNum, @RequestParam int pageSize) {
        System.out.println("开始查找所有API！");
        return apiService.selectAllAPI(pageNum, pageSize);
    }


    //    根据查找所有api查找出现最多的种类并根据该种类的点击数进行推荐对应的API
    @ApiOperation(value = "查找所有api进行推荐对应的API", notes = "根据查找所有api查找出现最多的种类并根据该种类的点击数进行推荐对应的API，返回List<API>")
    @GetMapping("/recommend/")
    public List<API> selectAPIByAllAPIRecommend() {
        System.out.println("开始推荐所有api对应的API！");
        return apiService.selectAPIByAllAPIRecommend();
    }


    //    根据全部匹配查找出现最多的种类并根据该种类的点击数进行推荐对应的API
    @ApiOperation(value = "查找全部模糊匹配all进行推荐对应的API", notes = " 根据全部模糊匹配查找出现最多的种类并根据该种类的点击数进行推荐对应的API，返回List<API>")
    @ApiImplicitParam(name = "val", value = "查询值", required = true, dataType = "String")
    @GetMapping("/recommend/all")
    public List<API> selectAPIByAllRecommend(String val) {
        System.out.println("开始推荐全部模糊匹配对应的API！");
        return apiService.selectAPIByAllRecommend(val);
    }

    //    根据指定的API category查找出现最多的种类并根据该种类的点击数进行推荐对应的API
    @ApiOperation(value = "查找API category进行推荐对应的API", notes = "根据指定的API category查找出现最多的种类并根据该种类的点击数进行推荐对应的API，返回List<API>")
    @ApiImplicitParam(name = "category", value = "API类属性category", required = true, dataType = "String")
    @GetMapping("/recommend/category")
    public List<API> selectAPIByCategoryRecommend(String category) {
        System.out.println("开始推荐API category对应的API！");
        return apiService.selectAPIByCategoryRecommend(category);
    }

    //    根据指定的API name查找出现最多的种类并根据该种类的点击数进行推荐对应的API
    @ApiOperation(value = "查找API name进行推荐对应的API", notes = "根据指定的API name查找出现最多的种类并根据该种类的点击数进行推荐对应的API，返回List<API>")
    @ApiImplicitParam(name = "name", value = "API类属性namey", required = true, dataType = "String")
    @GetMapping("/recommend/name")
    public List<API> selectAPIByNameRecommend(String name) {
        System.out.println("开始推荐API name对应的API！");
        return apiService.selectAPIByNameRecommend(name);
    }


    //     添加api
    @ApiOperation(value = "添加API", notes = "输入API对象，创建API，返回新增主键号")
    @ApiImplicitParam(name = "api", value = "API类详细实体api", required = true, dataType = "API")
    @PostMapping("/")
    public int  addAPI(@RequestBody API api) {
        System.out.println("开始添加API！");
        return apiService.addAPI(api);
    }

    //更新上传API的审核状态并添加api
    @ApiOperation(value = "更新上传API的审核状态并添加API", notes = "输入UserUpload类id和API对象，创建API，返回true")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "api", value = "API类详细实体api", required = true, dataType = "API"),
            @ApiImplicitParam(name = "id", value = "UserUpload类id", required = true, dataType = "int")
    })
    @PostMapping("/userUpload")
    public boolean addAPIAndUpdateUserUpload(@RequestParam int id) {
        System.out.println("开始更新上传API的审核状态并添加API！");
        return apiService.addAPIAndUpdateUploadAPI(id);
    }

    //    更新指定id的API
    @ApiOperation(value = "更新API", notes = "输入API对象，更新API，返回true")
    @ApiImplicitParam(name = "api", value = "API类详细实体api", required = true, dataType = "API")
    @PutMapping("/id")
    public boolean updateAPI(@RequestBody API api) {
        System.out.println("开始更新指定id的API！");
        return apiService.updateAPI(api);
    }

    //    删除指定id的API
    @ApiOperation(value = "删除API", notes = "删除指定id的API")
    @ApiImplicitParam(name = "id", value = "API类id", required = true, dataType = "int")
    @DeleteMapping("/id")
    public boolean deleteAPIById(@RequestParam int id) {
        System.out.println("开始删除指定id的API！");
        return apiService.deleteAPIById(id);
    }


}
