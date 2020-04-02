package com.ysu.webapi.controller;

import com.github.pagehelper.PageInfo;
import com.ysu.webapi.pojo.UploadAPI;
import com.ysu.webapi.service.UploadAPIService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/uploadAPI")
public class UploadAPIController {

    @Autowired
    private UploadAPIService uploadAPIService;
    private int pageSize = 5;

    //    根据用户id及是否审核通过查找该用户上传的所有的API
    @ApiOperation(value = "通过id查找UploadAPI对应的uploadAPI", notes = "输入UploadAPI userId，查询User，返回对应的uploadAPI")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "UploadAPI类userId", required = true, dataType = "int"),
            @ApiImplicitParam(name = "decide", value = "管理员审核是否通过", required = true, dataType = "boolean"),
            @ApiImplicitParam(name = "pageNum", value = "显示页数", required = true, dataType = "int")
    })
    @GetMapping("/userId/decide")
    public PageInfo<UploadAPI> selectUploadAPIByUserIdAndDecide(@RequestParam int userId,@RequestParam boolean decide,@RequestParam int pageNum){
        return uploadAPIService.selectUploadAPIByUserIdAndDecide(userId, decide, pageNum, pageSize);
    }

    //    根据用户id及是否被审核查找该用户上传的所有的API
    @ApiOperation(value = "通过id查找UploadAPI对应的uploadAPI", notes = "输入UploadAPI userId，查询User，返回对应的uploadAPI")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "UploadAPI类userId", required = true, dataType = "int"),
            @ApiImplicitParam(name = "pageNum", value = "显示页数", required = true, dataType = "int")
    })
    @GetMapping("/userId")
    public PageInfo<UploadAPI> selectUploadAPIByUserIdAndIstrue(@RequestParam int userId,@RequestParam int pageNum){
        return uploadAPIService.selectUploadAPIByUserIdAndIstrue(userId,pageNum, pageSize);
    }

    //    根据根据是否被审核查找所有符合的API
    @ApiOperation(value = "通过istrue查找UploadAPI对应的uploadAPI", notes = "输入UploadAPI userId，查询User，返回对应的uploadAPI")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "istrue", value = "UploadAPI类istrue", required = true, dataType = "boolean"),
            @ApiImplicitParam(name = "pageNum", value = "显示页数", required = true, dataType = "int")
    })
    @GetMapping("/istrue")
    PageInfo<UploadAPI> selectUploadAPIByIstrue(@RequestParam boolean istrue,@RequestParam int pageNum){
        return uploadAPIService.selectUploadAPIByIstrue(istrue,pageNum,pageSize);
    }

    //    根据根据是否被审核查找所有符合的API数目
    @ApiOperation(value="查找UploadAPI是否被审核的数目", notes="输入UploadAPI istrue，根据是否被审核从UploadAPI中查找符合的UploadAPI，返回是否被审核的数目")
    @ApiImplicitParam(name = "istrue", value = "UploadAPI类属性istrue", required = true, dataType = "boolean")
    @GetMapping("/istrue/sum")
    public int selectUploadAPIByIstrueToSum(@RequestParam boolean istrue){
        return uploadAPIService.selectUploadAPIByIstrueToSum(istrue);
    }


    //上传API
    @ApiOperation(value = "添加UploadAPI", notes = "添加UploadAPI")
    @ApiImplicitParam(name = "uploadAPI", value = "显示页数", required = true, dataType = "UploadAPI")
    @PostMapping("/")
    public boolean addUploadAPI(@RequestBody UploadAPI uploadAPI) {
        return uploadAPIService.addUploadAPI(uploadAPI);
    }


    //更新上传API的审核状态
    @ApiOperation(value = "更新上传API的审核状态", notes = "更新上传id的UploadAPI")
    @ApiImplicitParam(name = "id", value = "显示页数", required = true, dataType = "int")
    @PutMapping("/id")
    public boolean updateUploadAPI(@RequestParam int id) {
        return uploadAPIService.updateUploadAPI(id);
    }

    //    删除指定id的上传API
    @ApiOperation(value = "删除指定id的UploadAPI", notes = "删除指定id的UploadAPI")
    @ApiImplicitParam(name = "id", value = "显示页数", required = true, dataType = "int")
    @DeleteMapping("/id")
    public boolean deleteUploadAPIById(@RequestParam int id) {
        return uploadAPIService.deleteUploadAPIById(id);
    }

}
