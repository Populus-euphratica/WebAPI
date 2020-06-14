package com.ysu.webapi.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ysu.webapi.dao.UserConcernDao;

import com.ysu.webapi.pojo.API;
import com.ysu.webapi.pojo.APIShow;
import com.ysu.webapi.pojo.UserConcern;

import com.ysu.webapi.service.UserConcernService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserConcernServiceImpl implements UserConcernService {
    @Autowired
    private UserConcernDao userConcernDao;


//    //    根据指定的userConcern id查找对应的userConcern
//    @Override
//    public UserConcern selectUserConcernById(int id){
//        return userConcernDao.selectUserConcernById(id);
//    }

    //    根据指定的userConcern id查找对应的userConcern
    @Override
    public PageInfo<APIShow> selectUserConcernByUserId(int userId, int pageNum, int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<APIShow> list=userConcernDao.selectUserConcernByUserId(userId);
        return new PageInfo(list,5);
    }
    //    根据指定的userConcern userId查找对应的userConcern ID 并且不分页
    @Override
    public List<UserConcern> selectUserConcernByUserIdALL(int userId){
        return userConcernDao.selectUserConcernByUserIdALL(userId);
    }

    @Override
    public int addUserConcern(UserConcern userConcern) {
        int a=userConcernDao.addUserConcern(userConcern);
        System.out.println(a);
        return userConcern.getId();
    }

    @Override
    public boolean deleteUserConcernById(int id) {
        return userConcernDao.deleteUserConcernById(id);
    }


    //    查找所有userConcern
    @Override
    public PageInfo<UserConcern> selectUserConcernAll(int pageNum, int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<UserConcern> list=userConcernDao.selectUserConcernAll();
        return new PageInfo(list,5);
    }




}
