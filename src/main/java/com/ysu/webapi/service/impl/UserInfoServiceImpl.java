package com.ysu.webapi.service.impl;

import com.ysu.webapi.dao.UserInfoDao;
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


    //    根据指定的userInfo userId查找对应的userInfo
    @Override
    public UserInfo selectUserInfoByUserId(int userid){
        return userInfoDao.selectUserInfoByUserId(userid);
    }

    //    查找所有userInfo
    @Override
    public List<UserInfo> selectUserInfoAll(){
        return userInfoDao.selectUserInfoAll();
    }



    //    添加userInfo
    @Override
    public boolean addUserInfo(UserInfo userInfo){
        boolean flag=false;
        try {
            flag=userInfoDao.addUserInfo(userInfo);
        }catch (Exception e){
            System.out.println("添加userInfo失败");
            e.printStackTrace();
        }
        return flag;
    }


    //    更新userInfo信息
    @Override
    public boolean updateUserInfo(UserInfo userInfo){
        boolean flag=false;
        try {
            flag=userInfoDao.updateUserInfo(userInfo);
        }catch (Exception e){
            System.out.println("更新userInfo失败");
            e.printStackTrace();
        }
        return flag;
    }


}
