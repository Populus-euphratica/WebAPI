package com.ysu.webapi.service;

import com.ysu.webapi.pojo.User;

import java.util.List;

public interface UserService {

    //    根据指定的user id查找对应的user
    User selectUserById(int id);


    //    根据指定的user name查找对应的user
    User selectUserByName(String name);

    //    查找所有user
    List<User> selectUserAll();


    //    根据邮箱查找对应的user
    User selectUserByEmail(String email);


    //    根据company查找对应的user
    User selectUserByCompany(String company);

    //    添加user
    boolean addUser(User user);


    //    更新user信息
    boolean updateUser(User user);

    //    删除指定id的User
    boolean deleteUserById(String id);

}
