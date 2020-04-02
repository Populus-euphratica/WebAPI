package com.ysu.webapi.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ysu.webapi.dao.UserAPIDao;
import com.ysu.webapi.pojo.API;
import com.ysu.webapi.pojo.UserAPI;
import com.ysu.webapi.service.UserAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserAPIServiceImpl implements UserAPIService {

    @Autowired
    private UserAPIDao userAPIDao;

    @Override
    public PageInfo<API> selectUserAPIByUserId(int userId, int pageNum, int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<API> list=userAPIDao.selectUserAPIByUserId(userId);
        return new PageInfo(list,5);
    }
}
