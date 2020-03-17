package com.ysu.webapi.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ysu.webapi.dao.UserInfoDao;
import com.ysu.webapi.pojo.User;
import com.ysu.webapi.pojo.UserInfo;
import com.ysu.webapi.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserInfoDao userInfoDao;


    //    根据指定的userInfo id查找对应的userInfo
    @Override
    public UserInfo selectUserInfoById(int id){
        return userInfoDao.selectUserInfoById(id);
    }



    //    查找所有userInfo
    @Override
    public PageInfo<UserInfo> selectUserInfoAll(int pageNum, int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<UserInfo> list=userInfoDao.selectUserInfoAll();
        return new PageInfo(list,5);
    }

    //    查找所有userInfo userConcern
    @Override
    public PageInfo<UserInfo> selectUserInfoAllConcern(int pageNum,int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<UserInfo> list=userInfoDao.selectUserInfoAllConcern();
        return new PageInfo(list,5);
    }

    //    查找所有userInfo userUpload
    @Override
    public PageInfo<UserInfo> selectUserInfoAllUpload(int pageNum, int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<UserInfo> list=userInfoDao.selectUserInfoAllUpload();
        return new PageInfo(list,5);
    }



    //    更新userInfo Concern信息
    @Override
    public boolean updateUserInfoConcern(UserInfo userInfo){
        boolean flag=false;
        try {
            flag=userInfoDao.updateUserInfoConcern(userInfo);
        }catch (Exception e){
            System.out.println(" 更新userInfo Concern信息失败");
            e.printStackTrace();
        }
        return flag;
    }

    //    更新userInfo Upload信息
    @Override
    public boolean updateUserInfoUpload(UserInfo userInfo){
        boolean flag=false;
        try {
            flag=userInfoDao.updateUserInfoUpload(userInfo);
        }catch (Exception e){
            System.out.println(" 更新userInfo Concern信息失败");
            e.printStackTrace();
        }
        return flag;
    }


}
