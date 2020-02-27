package com.ysu.webapi.controller;

import com.github.pagehelper.PageInfo;
import com.ysu.webapi.pojo.APINews;
import com.ysu.webapi.service.APINewsService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

import static com.ysu.webapi.WebapiApplication.pageSize;

@RestController
@RequestMapping(value = "/api/apiNews")
public class APINewsController  {
    @Autowired
    private APINewsService apiNewsService;

    //    根据指定的APINews id查找对应的APINews
    @ApiOperation(value="通过id查找APINews", notes="输入APINews id，查询APINews，返回单个APINews对象")
    @ApiImplicitParam(name = "id", value = "APINews类id", required = true, dataType = "int")
    @GetMapping("/id")
    public APINews selectAPINewsById(@RequestParam int id){
        System.out.println("开始根据指定的APINews id查找对应的APINews!");
        return apiNewsService.selectAPINewsById(id);
    }

    //    根据指定的APINews name查找对应的APINews
    @ApiOperation(value="通过name查找APINews", notes="输入APINews name，查询APINews，返回单个APINews对象")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "APINews类name", required = true, dataType = "String"),
            @ApiImplicitParam(name = "pageNum", value = "显示页数", required = true, dataType = "int")
    })
    @GetMapping("/name")
    public PageInfo<APINews> selectAPINewsByName(@RequestParam String name,@RequestParam int pageNum){
        System.out.println("开始根据指定的APINews name查找对应的APINews!");
        return apiNewsService.selectAPINewsByName(name,pageNum,pageSize);
    }


    //    根据指定的APINews author查找对应的APINews
    @ApiOperation(value="通过author查找APINews", notes="输入APINews author，查询APINews，返回单个APINews对象")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "author", value = "APINews类author", required = true, dataType = "String"),
            @ApiImplicitParam(name = "pageNum", value = "显示页数", required = true, dataType = "int")
    })
    @GetMapping("/author")
    public PageInfo<APINews> selectAPINewsByAuthor(@RequestParam String author,@RequestParam int pageNum){
        System.out.println("开始根据指定的APINews author查找对应的APINews!");
        return apiNewsService.selectAPINewsByAuthor(author,pageNum,pageSize);
    }

    //    根据指定的APINews date区间查找对应的APINews
    @ApiOperation(value="通过date区间查找APINews", notes="输入APINews date区间data1,data2，查询APINews，返回所有符合的APINews对象")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "data1", value = "查询开始日期", required = true, dataType = "Date"),
            @ApiImplicitParam(name = "data2", value = "查询结束日期", required = true, dataType = "Date"),
            @ApiImplicitParam(name = "pageNum", value = "显示页数", required = true, dataType = "int")
    })
    @GetMapping("/dateSection")
    public PageInfo<APINews> selectAPINewsByDateSection(@RequestParam Date data1, @RequestParam Date data2,@RequestParam int pageNum){
        System.out.println("开始根据指定的APINews date区间查找对应的APINews!");
        return apiNewsService.selectAPINewsByDateSection(data1,data2,pageNum,pageSize);
    }

    //    根据指定的APINews date查找对应的APINews
    @ApiOperation(value="通过date查找APINews", notes="输入APINews data，查询APINews，返回所有符合的APINews对象")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "data", value = "APINews类data", required = true, dataType = "Date"),
            @ApiImplicitParam(name = "pageNum", value = "显示页数", required = true, dataType = "int")
    })
    @GetMapping("/data")
    public PageInfo<APINews> selectAPINewsByDate(@RequestParam Date data,  @RequestParam int pageNum){
        System.out.println("开始根据指定的APINews date查找对应的APINews!");
        return apiNewsService.selectAPINewsByDate(data,pageNum,pageSize);
    }

    //    查找所有APINews
    @ApiOperation(value="查找所有APINews", notes="查找所有APINews")
    @ApiImplicitParam(name = "pageNum", value = "显示页数", required = true, dataType = "int")
    @GetMapping("/")
    public PageInfo<APINews> selectAllAPINews(@RequestParam int pageNum){
        System.out.println("开始查找所有APINews!");
        return apiNewsService.selectAllAPINews(pageNum,pageSize);
    }


    //     添加APINews
    @ApiOperation(value="添加APINews", notes="输入APINews对象，创建APINews，返回true")
    @ApiImplicitParam(name = "apiNews", value = "APINews类详细实体apiNews", required = true, dataType = "APINews")
    @PostMapping("/")
    public boolean addAPINews(@RequestBody APINews api){
        System.out.println("开始添加apinews!");
        return apiNewsService.addAPINews(api);
    }


    //    更新指定id的APINews
    @ApiOperation(value="更新APINews", notes="输入APINews对象，更新APINews，返回true")
    @ApiImplicitParam(name = "apiNews", value = "APINews类详细实体apiNews", required = true, dataType = "APINews")
    @PutMapping("/id")
    public boolean updateAPINews(@RequestBody APINews api){
        System.out.println("开始更新指定id的APINews!");
        return apiNewsService.updateAPINews(api);
    }


    //    删除指定id的APINews
    @ApiOperation(value="通过id删除APINews", notes="删除指定id的APINews")
    @ApiImplicitParam(name = "id", value = "APINews类id", required = true, dataType = "int")
    @DeleteMapping("/id")
    public boolean deleteAPINewsById(@RequestParam String id){
        System.out.println("开始删除指定id的APINews!");
        return apiNewsService.deleteAPINewsById(id);
    }

}
