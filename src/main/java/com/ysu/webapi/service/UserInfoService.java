package com.ysu.webapi.service;

import com.github.pagehelper.PageInfo;
import com.ysu.webapi.pojo.UserInfo;

import java.util.List;

public interface UserInfoService {

    //    根据指定的userInfo id查找对应的userInfo
    public UserInfo selectUserInfoById(int id);

    //    根据指定的userInfo id查找对应的userConcern
    public String selectUserInfoByIdToConcern(int id);

    //    根据指定的userInfo id查找对应的userUpload
    public String selectUserInfoByIdToUpload(int id);


    //    查找所有userInfo
    public PageInfo<UserInfo> selectUserInfoAll(int pageNum, int pageSize);





    //    更新userInfo Concern信息
    public boolean updateUserInfoConcern(UserInfo userInfo);

    //    更新userInfo Upload信息
    public boolean updateUserInfoUpload(UserInfo userInfo);

}
