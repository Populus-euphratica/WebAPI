package com.ysu.webapi.dao;

import com.ysu.webapi.pojo.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface UserInfoDao {

    //    根据指定的userInfo id查找对应的userInfo
    @Select("select * from userinfo where id=#{id}")
    UserInfo selectUserInfoById(int id);



    //    查找所有userInfo
    @Select("select * from userinfo")
    List<UserInfo> selectUserInfoAll();

    //    查找所有userInfo userConcern
    @Select("select id,userConcern from userinfo")
    List<UserInfo> selectUserInfoAllConcern();

    //    查找所有userInfo userUpload
    @Select("select id,userUpload from userinfo")
    List<UserInfo> selectUserInfoAllUpload();



    //    添加userInfo
    @Insert("insert into userinfo (userConcern,userUpload) values(#{userConcern},#{userUpload})")
    boolean addUserInfo(UserInfo userInfo);


    //    更新userInfo Concern信息
    @Update("update userinfo set userConcern=#{userConcern}where id=#{id}")
    boolean updateUserInfoConcern(UserInfo userInfo);

    //    更新userInfo Upload信息
    @Update("update userinfo set userUpload=#{userUpload} where id=#{id}")
    boolean updateUserInfoUpload(UserInfo userInfo);

    //    删除指定id的userInfo
    @Delete("delete from userinfo where id=#{id}")
    boolean deleteUserInfoById(int id);


}
