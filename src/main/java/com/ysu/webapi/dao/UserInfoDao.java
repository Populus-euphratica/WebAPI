package com.ysu.webapi.dao;

import com.ysu.webapi.pojo.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface UserInfoDao {

    //    根据指定的userInfo id查找对应的userInfo
    @Select("select * from userinfo where id=#{id}")
    UserInfo selectUserInfoById(int id);


    //    根据指定的userInfo userId查找对应的userInfo
    @Select("select * from userinfo where userId=#{userId}")
    UserInfo selectUserInfoByUserId(int userId);

    //    查找所有userInfo
    @Select("select * from userinfo")
    List<UserInfo> selectUserInfoAll();



    //    添加userInfo
    @Insert("insert into userinfo (userId,userConcern,userUpload) values(#{userId},#{userConcern},#{userUpload})")
    boolean addUserInfo(UserInfo userInfo);


    //    更新userInfo信息
    @Update("update userinfo set userId=#{userId},userConcern=#{userConcern},userUpload=#{userUpload} where id=#{id}")
    boolean updateUserInfo(UserInfo userInfo);

    //    删除指定id的userInfo
    @Delete("delete from userinfo where id=#{id}")
    boolean deleteUserInfoById(int id);

    //    删除指定id的userInfo
    @Delete("delete from userinfo where userId=#{userId}")
    boolean deleteUserInfoByUserId(int userId);

}
