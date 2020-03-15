package com.ysu.webapi.service;

import com.ysu.webapi.pojo.UserInfo;

import java.util.List;

public interface UserInfoService {

    //    根据指定的userInfo id查找对应的userInfo
    public UserInfo selectUserInfoById(int id);


    //    查找所有userInfo
    public List<UserInfo> selectUserInfoAll();


    //    添加userInfo
    public boolean addUserInfo(UserInfo userInfo);


    //    更新userInfo信息
    public boolean updateUserInfo(UserInfo userInfo);

}
