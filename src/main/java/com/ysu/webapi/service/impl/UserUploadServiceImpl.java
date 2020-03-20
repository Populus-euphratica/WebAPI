package com.ysu.webapi.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ysu.webapi.dao.UserUploadDao;
import com.ysu.webapi.pojo.UserUpload;
import com.ysu.webapi.service.UserUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserUploadServiceImpl implements UserUploadService {
    @Autowired
    private UserUploadDao userUploadDao;

    //    根据用户id查找该用户上传的所有的API
    @Override
    public PageInfo<UserUpload> selectUserUploadByUserId(int userId,int pageNum, int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<UserUpload> list=userUploadDao.selectUserUploadByUserId(userId);
        return new PageInfo(list,5);
    }


    //    根据根据是否被审核查找所有符合的API
    @Override
    public PageInfo<UserUpload> selectUserUploadByIstrue(boolean istrue,int pageNum, int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<UserUpload> list=userUploadDao.selectUserUploadByIstrue(istrue);
        return new PageInfo(list,5);
    }


    //    根据根据是否被审核查找所有符合的API数目
    @Override
    public int selectUserUploadByIstrueToSum(boolean istrue){
        return userUploadDao.selectUserUploadByIstrueToSum(istrue);
    }

    //上传API
    @Override
    public boolean addUserUpload(UserUpload userUpload){
        boolean flag=false;
        try {
            flag=userUploadDao.addUserUpload(userUpload);
        }catch (Exception e){
            System.out.println("上传API失败");
            e.printStackTrace();
        }
        return flag;
    }


    //更新上传API的审核状态为失败
    @Override
    public boolean updateUserUpload(int id){
        boolean flag=false;
        try {
            flag=userUploadDao.updateUserUpload(false,id);
        }catch (Exception e){
            System.out.println("更新上传API的审核状态为失败失败");
            e.printStackTrace();
        }
        return flag;
    }

    //    删除指定id的上传API
    @Override
    public boolean deleteUserUploadById(int id){
        boolean flag=false;
        try {
            flag=userUploadDao.deleteUserUploadById(id);
        }catch (Exception e){
            System.out.println("删除指定id的上传API失败");
            e.printStackTrace();
        }
        return flag;
    }

}
