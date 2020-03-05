package com.ysu.webapi.service;

import com.github.pagehelper.PageInfo;
import com.ysu.webapi.pojo.User;

import java.util.List;

public interface UserService {

    //    根据指定的user id查找对应的user
    public User selectUserById(int id);


    //    根据指定的user name查找对应的user
    public PageInfo<User> selectUserByName(String name,int pageNum,int pageSize);

    //    查找所有user
    public PageInfo<User> selectUserAll(int pageNum,int pageSize);


    //    根据邮箱查找对应的user
    public User selectUserByEmail(String email);


    //    根据company查找对应的user
    public PageInfo<User> selectUserByCompany(String company,int pageNum,int pageSize);

    //    模糊查找
    public PageInfo<User> selectUserByAll(String val,int pageNum,int pageSize);

    //    添加user
    public boolean addUser(User user);


    //    更新user信息
    public boolean updateUser(User user);

    //    删除指定id的User
    public boolean deleteUserById(String id);

}
