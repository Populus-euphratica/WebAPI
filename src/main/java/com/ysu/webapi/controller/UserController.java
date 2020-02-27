package com.ysu.webapi.controller;

import com.github.pagehelper.PageInfo;
import com.ysu.webapi.pojo.User;
import com.ysu.webapi.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.ysu.webapi.WebapiApplication.pageSize;

@RestController
@RequestMapping(value = "/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    //    根据指定的user id查找对应的user
    @ApiOperation(value="通过id查找User", notes="输入User id，查询User，返回单个User对象")
    @ApiImplicitParam(name = "id", value = "User类id", required = true, dataType = "int")
    @GetMapping("/id")
    public User selectUserById(@RequestParam int id){
        System.out.println("开始根据指定的user id查找对应的user！");
        return userService.selectUserById(id);
    }


    //    根据指定的user name查找对应的User
    @ApiOperation(value="通过name查找User", notes="输入User name，查询User，返回单个User对象")
    @ApiImplicitParam(name = "name", value = "User类name", required = true, dataType = "String")
    @GetMapping("/name")
    public PageInfo<User> selectUserByName(@RequestParam String name,@RequestParam int pageNum){
        System.out.println("开始根据指定的user name查找对应的user！");
        return userService.selectUserByName(name,pageNum,pageSize);
    }

    //    查找所有User
    @ApiOperation(value="查找所有User", notes="查找所有User")
    @GetMapping("/")
    public PageInfo<User> selectUserAll(@RequestParam int pageNum){
        System.out.println("开始查找所有User！");
        return userService.selectUserAll(pageNum,pageSize);
    }


    //    根据邮箱查找对应的user
    @ApiOperation(value="通过email查找User", notes="输入User email，查询User，返回单个User对象")
    @ApiImplicitParam(name = "email", value = "User类email", required = true, dataType = "String")
    @GetMapping("/email")
    public User selectUserByEmail(@RequestParam String email){
        System.out.println("开始根据邮箱查找对应的user！");
        return userService.selectUserByEmail(email);
    }


    //    根据company查找对应的user
    @ApiOperation(value="通过company查找User", notes="输入User company，查询User，返回单个User对象")
    @ApiImplicitParam(name = "company", value = "User类company", required = true, dataType = "String")
    @GetMapping("/company")
    public PageInfo<User> selectUserByCompany(@RequestParam String company,@RequestParam int pageNum){
        System.out.println("开始根据company查找对应的user！");
        return userService.selectUserByCompany(company,pageNum,pageSize);
    }

    //    添加user
    @ApiOperation(value="添加User", notes="输入User对象，创建User，返回true")
    @ApiImplicitParam(name = "user", value = "User类详细实体user", required = true, dataType = "User")
    @PostMapping("/")
    public boolean addUser(@RequestBody User user){
        System.out.println("开始添加user！");
        return userService.addUser(user);
    }


    //    更新user信息
    @ApiOperation(value="更新User", notes="输入User对象，更新User，返回true")
    @ApiImplicitParam(name = "user", value = "User类详细实体user", required = true, dataType = "User")
    @PutMapping("/id")
    public boolean updateUser(@RequestBody User user){
        System.out.println("开始更新user信息！");
        return userService.updateUser(user);
    }

    //    删除指定id的User
    @ApiOperation(value="通过id删除User", notes="删除指定id的User")
    @ApiImplicitParam(name = "id", value = "User类id", required = true, dataType = "int")
    @DeleteMapping("/id")
    public boolean deleteUserById(@RequestParam String id){
        System.out.println("开始删除指定id的User！");
        return userService.deleteUserById(id);
    }

    @ApiOperation(value="验证登陆", notes="输入用户账号，查询用户，返回是否存在")
    @ApiImplicitParam(name = "user", value = "用户类详细实体user", required = true, dataType = "User")
    @PostMapping("/login")
    public boolean loginAdmin(@RequestBody User user){
        System.out.println("开始匹配指定管理员账号密码是否正确！");
        User user1=userService.selectUserByEmail(user.getEmail());
        if (user.getPassword().equals(user1.getPassword())){
            System.out.println("user账号正确");
            return true;
        }
        return false;
    }

}
