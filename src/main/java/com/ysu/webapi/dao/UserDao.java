package com.ysu.webapi.dao;

import com.ysu.webapi.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserDao {

    //    根据指定的user id查找对应的user
    @Select("select * from user where id=#{id}")
    User selectUserById(int id);


    //    根据指定的user name查找对应的user
    @Select("select * from user where name=#{name}")
    User selectUserByName(String name);

    //    查找所有user
    @Select("select * from user")
    List<User> selectUserAll();


    //    根据邮箱查找对应的user
    @Select("select * from user where email=#{email}")
    User selectUserByEmail(String email);


    //    根据company查找对应的user
    @Select("select * from user where company=#{company}")
    User selectUserByCompany(String company);

    //    添加user
    @Insert("insert into user (name,email,company,position) values(#{name},#{email},#{company},#{position})")
    boolean addUser(User user);


    //    更新user信息
    @Update("update user set name=#{name},email=#{email},company=#{company} position=#{position} where id=#{id}")
    boolean updateUser(User user);



}