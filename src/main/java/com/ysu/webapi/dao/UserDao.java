package com.ysu.webapi.dao;

import com.ysu.webapi.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface UserDao {

    //    根据指定的user id查找对应的user
    @Select("select * from user where id=#{id}")
    User selectUserById(int id);


    //    根据指定的user name查找对应的user
    @Select("select * from user where name like CONCAT('%',#{name},'%')")
    List<User> selectUserByName(String name);

    //    查找所有user
    @Select("select * from user")
    List<User> selectUserAll();


    //    根据邮箱查找对应的user
    @Select("select * from user where email=#{email}")
    User selectUserByEmail(String email);

    //    模糊查找
    @Select("select * from user where name like CONCAT('%',#{val},'%') or company like CONCAT('%',#{val},'%') or email like CONCAT('%',#{val},'%')")
    List<User> selectUserByAll(String val);


    //    根据company查找对应的user
    @Select("select * from user where company like CONCAT('%',#{company},'%')")
    List<User> selectUserByCompany(String company);

    //    添加user
    @Insert("insert into user (name,company,email,password,position) values(#{name},#{company},#{email},#{password},#{position})")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    boolean addUser(User user);


    //    更新user信息
    @Update("update user set name=#{name},company=#{company},email=#{email},password=#{password},position=#{position} where id=#{id}")
    boolean updateUser(User user);

    //    根据id更新user信息姓名、公司
    @Update("update user set name=#{name},company=#{company} where id=#{id}")
    boolean updateUserNameAndCompany(String name,String company,int id);


    //    根据id更新user信息姓名、公司
    @Update("update user set password=#{password} where id=#{id}")
    boolean updateUserPassword(String password,int id);


    //    删除指定id的User
    @Delete("delete from user where id=#{id}")
    boolean deleteUserById(int id);



}
