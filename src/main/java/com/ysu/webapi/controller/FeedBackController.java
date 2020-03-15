package com.ysu.webapi.controller;

import com.github.pagehelper.PageInfo;
import com.ysu.webapi.pojo.FeedBack;
import com.ysu.webapi.pojo.FeedBackShow;
import com.ysu.webapi.service.FeedBackService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import static com.ysu.webapi.WebapiApplication.pageSize;

@RestController
@RequestMapping(value = "/api/feedBack")
public class FeedBackController {

    @Autowired
    private FeedBackService feedBackService;


    //根据指定id号从feedback中查找符合的FeedBack
    @ApiOperation(value = "查找FeedBack", notes = "输入FeedBack id，根据指定id号从feedback中查找符合的FeedBack，返回FeedBack")
    @ApiImplicitParam(name = "id", value = "FeedBack类属性id", required = true, dataType = "int")
    @GetMapping("/id")
    public FeedBack selectFeedBackById(@RequestParam int id) {
        System.out.println("根据指定id号从feedback中查找符合的FeedBack");
        return feedBackService.selectFeedBackById(id);
    }

    //根据是否被审核查找符合的FeedBack
    @ApiOperation(value = "查找FeedBack", notes = "输入FeedBack istrue，根据是否被审核从feedback中查找符合的FeedBack，返回FeedBack")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "istrue", value = "FeedBack类属性istrue", required = true, dataType = "boolen"),
            @ApiImplicitParam(name = "pageNum", value = "显示页数", required = true, dataType = "int")
    })
    @GetMapping("/istrue")
    public PageInfo<FeedBackShow> selectFeedBackByIstrue(@RequestParam boolean istrue, @RequestParam int pageNum) {
        System.out.println("根据是否被审核查找符合的FeedBack");
        return feedBackService.selectFeedBackByIstrue(istrue, pageNum, pageSize);
    }

    //    获取是否被审核的数目
    @ApiOperation(value = "查找FeedBack是否被审核的数目", notes = "输入FeedBack istrue，根据是否被审核从feedback中查找符合的FeedBack，返回是否被审核的数目")
    @ApiImplicitParam(name = "istrue", value = "FeedBack类属性istrue", required = true, dataType = "boolen")
    @GetMapping("/istrue/sum")
    public int selectFeedBackByIstrueToSum(@RequestParam boolean istrue) {
        System.out.println("获取是否被审核的数目");
        return feedBackService.selectFeedBackByIstrueToSum(istrue);
    }

    //添加一条反馈记录
    @ApiOperation(value = "添加FeedBack", notes = "输入FeedBack对象，创建FeedBack，返回true")
    @ApiImplicitParam(name = "feedBack", value = "FeedBack类详细实体feedBack", required = true, dataType = "FeedBack")
    @PostMapping("/")
    public boolean addFeedBack(@RequestBody FeedBack feedBack) {
        System.out.println("添加一条反馈记录");
        return feedBackService.addFeedBack(feedBack);
    }

    //更新一条反馈记录
    @ApiOperation(value = "更新FeedBack", notes = "输入FeedBack对象，更新FeedBack，返回true")
    @ApiImplicitParam(name = "feedBack", value = "FeedBack类详细实体feedBack", required = true, dataType = "FeedBack")
    @PutMapping("/id")
    public boolean updateFeedBack(@RequestBody FeedBack feedBack) {
        System.out.println("更新一条反馈记录");
        return feedBackService.updateFeedBack(feedBack);
    }

    //更新管理员对反馈的回复
    @ApiOperation(value = "更新FeedBack", notes = "输入reply，更新管理员对反馈的回复，更新FeedBack，返回true")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "reply", value = "FeedBack类属性reply", required = true, dataType = "String"),
            @ApiImplicitParam(name = "id", value = "FeedBack类属性id", required = true, dataType = "int")
    })
    @PutMapping("/reply")
    public boolean updateFeedBackToReply(@RequestParam String reply, @RequestParam int id) {
        System.out.println("更新管理员对反馈的回复");
        return feedBackService.updateFeedBackToReply(reply, id);
    }

    //删除一条反馈记录
    @ApiOperation(value = "通过id删除FeedBack", notes = "删除指定id的FeedBack")
    @ApiImplicitParam(name = "id", value = "FeedBack类id", required = true, dataType = "int")
    @DeleteMapping("/id")
    public boolean deleteFeedBackById(@RequestParam int id) {
        return feedBackService.deleteFeedBackById(id);
    }
}
