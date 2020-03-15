package com.ysu.webapi.controller;

import com.ysu.webapi.service.EmailService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/email")
public class EmailController {
    @Autowired
    private EmailService service;

    @ApiOperation(value="发送邮件", notes="输入邮件的接收者、主题、内容，发送邮件")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "to", value = "邮件接收者", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "content", value = "内容", required = true, paramType = "query", dataType = "String")
    })
    @PostMapping("/")
    public boolean sendHtmlMail(@RequestParam String to, @RequestParam String content){
        System.out.println("向"+to+"发送邮件！");
        return service.sendHtmlMail(to,content);
    }
}
