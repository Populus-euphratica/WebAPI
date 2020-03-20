package com.ysu.webapi.controller;

import com.github.pagehelper.PageInfo;
import com.ysu.webapi.pojo.UserUpload;
import com.ysu.webapi.service.UserUploadService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/userUpload")
public class UserUploadController {

    @Autowired
    private UserUploadService userUploadService;
    private int pageSize = 5;

    //    根据用户id查找该用户上传的所有的API
    @ApiOperation(value = "通过id查找UserUpload对应的userUpload", notes = "输入UserUpload userId，查询User，返回对应的userUpload")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "UserUpload类userId", required = true, dataType = "int"),
            @ApiImplicitParam(name = "pageNum", value = "显示页数", required = true, dataType = "int")
    })
    @GetMapping("/userId")
    public PageInfo<UserUpload> selectUserUploadByUserId(@RequestParam int userId,@RequestParam int pageNum) {
        return userUploadService.selectUserUploadByUserId(userId, pageNum, pageSize);
    }


    //    根据根据是否被审核查找所有符合的API
    @ApiOperation(value = "通过istrue查找UserUpload对应的userUpload", notes = "输入UserUpload userId，查询User，返回对应的userUpload")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "istrue", value = "UserUpload类istrue", required = true, dataType = "boolean"),
            @ApiImplicitParam(name = "pageNum", value = "显示页数", required = true, dataType = "int")
    })
    @GetMapping("/istrue")
    PageInfo<UserUpload> selectUserUploadByIstrue(@RequestParam boolean istrue,@RequestParam int pageNum){
        return userUploadService.selectUserUploadByIstrue(istrue,pageNum,pageSize);
    }

    //    根据根据是否被审核查找所有符合的API数目
    @ApiOperation(value="查找UserUpload是否被审核的数目", notes="输入UserUpload istrue，根据是否被审核从UserUpload中查找符合的UserUpload，返回是否被审核的数目")
    @ApiImplicitParam(name = "istrue", value = "UserUpload类属性istrue", required = true, dataType = "boolen")
    @GetMapping("/istrue/sum")
    public int selectUserUploadByIstrueToSum(@RequestParam boolean istrue){
        return userUploadService.selectUserUploadByIstrueToSum(istrue);
    }


    //上传API
    @ApiOperation(value = "添加UserUpload", notes = "添加UserUpload")
    @ApiImplicitParam(name = "userUpload", value = "显示页数", required = true, dataType = "UserUpload")
    @PostMapping("/")
    public boolean addUserUpload(@RequestBody UserUpload userUpload) {
        return userUploadService.addUserUpload(userUpload);
    }


    //更新上传API的审核状态
    @ApiOperation(value = "更新上传API的审核状态", notes = "更新上传id的UserUpload")
    @ApiImplicitParam(name = "id", value = "显示页数", required = true, dataType = "int")
    @PutMapping("/id")
    public boolean updateUserUpload(@RequestParam int id) {
        return userUploadService.updateUserUpload(id);
    }

    //    删除指定id的上传API
    @ApiOperation(value = "删除指定id的UserUpload", notes = "删除指定id的UserUpload")
    @ApiImplicitParam(name = "id", value = "显示页数", required = true, dataType = "int")
    @DeleteMapping("/id")
    public boolean deleteUserUploadById(@RequestParam int id) {
        return userUploadService.deleteUserUploadById(id);
    }

}
