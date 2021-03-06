package com.ysu.webapi.controller;

import com.github.pagehelper.PageInfo;
import com.ysu.webapi.pojo.ApplyForAdmin;
import com.ysu.webapi.service.ApplyForAdminService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping(value = "/api/applyForAdmin")
public class ApplyForAdminController {

    @Autowired
    private ApplyForAdminService applyForAdminService;
    private int pageSize=5;

    //    根据指定的id查找对应的管理员申请对象
    @ApiOperation(value="按照指定的id查找对应的管理员申请对象", notes="输入管理员申请对象ID ，查询管理员申请对象，返回单个ApplyForAdmin对象")
    @ApiImplicitParam(name = "id", value = "管理员申请对象Id", required = true, paramType = "query", dataType = "int")
    @GetMapping("/id")
    public ApplyForAdmin selectApplyById(@RequestParam int id){
        System.out.println("开始根据指定的id查找对应的管理员申请！");
        return applyForAdminService.selectApplyById(id);
    }

    //根据是否被审核查找符合的ApplyForAdmin
    @ApiOperation(value="查找ApplyForAdmin", notes="输入ApplyForAdmin istrue，根据是否被审核从ApplyForAdmin中查找符合的ApplyForAdmin，返回ApplyForAdmin")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "istrue", value = "ApplyForAdmin类属性istrue", required = true, dataType = "boolean"),
            @ApiImplicitParam(name = "pageNum", value = "显示页数", required = true, dataType = "int")
    })
    @GetMapping("/istrue")
    public PageInfo<ApplyForAdmin> selectApplyByIstrue(@RequestParam boolean istrue,@RequestParam int pageNum){
        return applyForAdminService.selectApplyByIstrue(istrue,pageNum,pageSize);
    }

    //    获取是否被审核的数目
    @ApiOperation(value="查找ApplyFromAdmin是否被审核的数目", notes="输入ApplyFromAdmin istrue，根据是否被审核从ApplyFromAdmin中查找符合的ApplyFromAdmin，返回是否被审核的数目")
    @ApiImplicitParam(name = "istrue", value = "ApplyFromAdmin类属性istrue", required = true, dataType = "boolean")
    @GetMapping("/istrue/sum")
    public int selectApplyByIstrueToSum(@RequestParam boolean istrue){
        return applyForAdminService.selectApplyByIstrueToSum(istrue);
    }
    
    //    查找所有管理员申请对象
    @ApiOperation(value="查找全部管理员申请对象", notes="返回所有ApplyForAdmin对象")
    @ApiImplicitParam(name = "pageNum", value = "显示页数", required = true, dataType = "int")
    @GetMapping("/all")
    public PageInfo<ApplyForAdmin> selectApplyAll(@RequestParam int pageNum){
        System.out.println("开始查找所有管理员申请！");
        return applyForAdminService.selectApplyAll(pageNum,pageSize);
    }

    //    根据邮箱查找对应的管理员申请对象
    @ApiOperation(value="通过email查找ApplyForAdmin", notes="输入ApplyForAdmin email，查询ApplyForAdmin，返回单个ApplyForAdmin对象")
    @ApiImplicitParam(name = "email", value = "ApplyForAdmin类email", required = true, dataType = "String")
    @GetMapping("/email")
    public ApplyForAdmin selectApplyByEmail(@RequestParam String email){
        System.out.println("开始根据邮箱查找对应的管理员申请！");
        return applyForAdminService.selectApplyByEmail(email);
    }

    //    添加管理员申请对象
    @ApiOperation(value="添加ApplyForAdmin", notes="输入ApplyForAdmin对象，创建ApplyForAdmin，返回true")
    @ApiImplicitParam(name = "applyForAdmin", value = "ApplyForAdmin类详细实体user", required = true, dataType = "ApplyForAdmin")
    @PostMapping("/")
    public boolean addApply(@RequestBody ApplyForAdmin applyForAdmin){
        System.out.println("开始添加管理员申请！");
        return applyForAdminService.addApply(applyForAdmin);
    }


    //更新申请状态
    @ApiOperation(value="添加ApplyForAdmin", notes="输入ApplyForAdmin对象，创建ApplyForAdmin，返回true")
    @ApiImplicitParam(name = "id", value = "ApplyForAdmin类详属性id", required = true, dataType = "int")
    @PutMapping("/id")
    public boolean updateApply(int id){
        System.out.println("开始更新申请状态！");
        return applyForAdminService.updateApply(id);
    }


    //    删除指定id的管理员申请对象
    @ApiOperation(value="通过id删除ApplyForAdmin", notes="删除指定id的管理员申请对象")
    @ApiImplicitParam(name = "id", value = "ApplyForAdmin类id", required = true, dataType = "int")
    @DeleteMapping("/id")
    public boolean deleteApplyById(@RequestParam int id){
        System.out.println("开始删除指定id的管理员申请！");
        return applyForAdminService.deleteApplyById(id);
    }
}
