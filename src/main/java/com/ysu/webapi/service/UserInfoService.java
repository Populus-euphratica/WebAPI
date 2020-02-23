package com.ysu.webapi.service;

import com.ysu.webapi.pojo.UserInfo;

import java.util.List;

public interface UserInfoService {

    //    根据指定的userInfo id查找对应的userInfo
    UserInfo selectUserInfoById(int id);


    //    根据指定的userInfo userId查找对应的userInfo
    UserInfo selectUserInfoByUserId(int userid);

    //    查找所有userInfo
    List<UserInfo> selectUserInfoAll();



    //    添加userInfo
    boolean addUserInfo(UserInfo userInfo);


    //    更新userInfo信息
    boolean updateUserInfo(UserInfo userInfo);

}
