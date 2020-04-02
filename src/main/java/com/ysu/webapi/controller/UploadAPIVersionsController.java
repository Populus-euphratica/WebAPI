package com.ysu.webapi.controller;


import com.github.pagehelper.PageInfo;
import com.ysu.webapi.pojo.UploadAPIShow;
import com.ysu.webapi.pojo.UploadAPIVS;
import com.ysu.webapi.pojo.UploadAPIVersions;
import com.ysu.webapi.service.UploadAPIVersionsService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/uploadVersions")
public class UploadAPIVersionsController {

    private int pageSize=5;
    @Autowired
    private UploadAPIVersionsService apiVersionsService;

    //    根据id查找API版本
    @ApiOperation(value = "根据id查找API版本", notes = "根据指定的APIVersions id查找对应的API版本，返回API版本")
    @ApiImplicitParam(name = "id", value = "APIVersions类属性id", required = true, dataType = "int")
    @GetMapping("/id")
    public UploadAPIVersions selectUploadAPIVersionsById(int id){
        System.out.println("开始根据id查找API版本！");
        return apiVersionsService.selectUploadAPIVersionsById(id);
    }

    //    根据APIId查找API版本
    @ApiOperation(value = "根据APIId查找API版本", notes = "根据指定的APIVersions APIId查找对应的API版本，返回API版本")
    @ApiImplicitParam(name = "APIId", value = "APIVersions类属性APIId", required = true, dataType = "int")
    @GetMapping("/APIId")
    public List<UploadAPIVersions> selectUploadAPIVersionsByAPIId(@RequestParam int APIId){
        System.out.println("开始根据APIId查找API版本！");
        return apiVersionsService.selectUploadAPIVersionsByAPIId(APIId);
    }

    //    查找API版本未被审核的数目
    @ApiOperation(value = "查找API版本未被审核的数目", notes = "查找API版本未被审核的数目")
    @GetMapping("/istrue/sum")
    public int selectUploadAPIVersionsToSum(){
        return apiVersionsService.selectUploadAPIVersionsToSum();
    }


    //    根据APIId查找是否审核通过API版本
    @ApiOperation(value = "根据APIId查找API版本", notes = "根据指定的APIVersions APIId查找对应的API版本，返回API版本")
    @ApiImplicitParam(name = "istrue", value = "审查是否通过", required = true, dataType = "boolean")
    @GetMapping("/istrue")
    public PageInfo<UploadAPIShow> selectUploadAPIVersionsByIstrue(@RequestParam boolean istrue, @RequestParam int pageNum){
        return apiVersionsService.selectUploadAPIVersionsByIstrue(istrue,pageNum,pageSize);
    }



    //    根据userId查找是否审核通过API版本
    @ApiOperation(value = "根据userId查找是否审核通过API版本", notes = "根据指定的UploadAPIVersions userId查找对应的API版本，返回API版本")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "decide", value = "审查是否通过", required = true, dataType = "boolean"),
            @ApiImplicitParam(name = "userId", value = "UploadAPIVersions类userId", required = true, dataType = "int")
    })
    @GetMapping("/userId/decide")
    public List<UploadAPIVersions> selectUploadAPIVersionsByUserIdAndDecide(boolean decide, int userId){
        return apiVersionsService.selectUploadAPIVersionsByUserIdAndDecide(decide, userId);
    }

    //    根据userId查找是否审核API版本
    @ApiOperation(value = "根据userId查找是否审核API版本", notes = "根据指定的UploadAPIVersions userId查找对应的API版本，返回API版本")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "istrue", value = "审查是否通过", required = true, dataType = "boolean"),
            @ApiImplicitParam(name = "userId", value = "UploadAPIVersions类userId", required = true, dataType = "int")
    })
    @GetMapping("/userId/istrue")
    public List<UploadAPIVersions> selectUploadAPIVersionsByUserIdAndIstrue(boolean istrue, int userId){
        return apiVersionsService.selectUploadAPIVersionsByUserIdAndIstrue(istrue, userId);
    }



    //    添加API版本
    @ApiOperation(value = "添加API版本", notes = "输入API版本对象，创建APIVersions，返回true")
    @ApiImplicitParam(name = "apivs", value = "APIVS类是由APIVersions和APISummary组成的", required = true, dataType = "APIVS")
    @PostMapping("/")
    public boolean addUploadAPIVersions(@RequestBody UploadAPIVS apivs){
        System.out.println("开始添加API版本！");
        return apiVersionsService.addUploadAPIVersions(apivs.getUploadAPIVersions(),apivs.getUploadAPISummary());
    }

    //    更新指定id的API版本
    @ApiOperation(value = "更新指定id的APIVersions版本", notes = "输入APIVersions对象，更新APIVersions，返回true")
    @ApiImplicitParam(name = "apivs", value = "APIVS类是由APIVersions和APISummary组成的", required = true, dataType = "APIVS")
    @PutMapping("/id")
    public boolean updateUploadAPIVersions(@RequestBody UploadAPIVS apivs){
        System.out.println("开始更新指定id的API版本！");
        return apiVersionsService.updateUploadAPIVersions(apivs.getUploadAPIVersions(),apivs.getUploadAPISummary());
    }

    //    更新指定id的API版本,是否审核通过
    @ApiOperation(value = "更新指定id的API版本,是否审核通过", notes = "输入APIVersions对象的id和decide，更新APIVersions，返回true")
    @ApiImplicitParam(name = "id", value = "APIVersions类id", required = true, dataType = "int")
    @PutMapping("/id/decide")
    public boolean updateUploadAPIVersionsBydecide(int id){
        System.out.println("更新指定id的API版本,是否审核通过！");
        return apiVersionsService.updateUploadAPIVersionsBydecide(id);
    }


    //    删除指定id的API版本
    @ApiOperation(value = "删除APIVersions", notes = "删除指定id的APIVersions")
    @ApiImplicitParam(name = "id", value = "APIVersions类id", required = true, dataType = "int")
    @DeleteMapping("/id")
    public boolean deleteUploadAPIVersionsById(int id,String logo){
        System.out.println("开始删除指定id的API版本！");
        return apiVersionsService.deleteUploadAPIVersionsById(id,logo);
    }

    //    删除指定APIId的API版本
    @ApiOperation(value = "删除APIId", notes = "删除指定id的APIId")
    @ApiImplicitParam(name = "id", value = "APIId类id", required = true, dataType = "int")
    @DeleteMapping("/APIId")
    public boolean deleteUploadAPIVersionsByAPIId(int APIId){
        System.out.println("删除指定APIId的API版本！");
        return apiVersionsService.deleteUploadAPIVersionsByAPIId(APIId);
    }
}
