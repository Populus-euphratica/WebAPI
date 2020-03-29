package com.ysu.webapi.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ysu.webapi.dao.UploadAPIDao;
import com.ysu.webapi.pojo.UploadAPI;
import com.ysu.webapi.service.UploadAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UploadAPIServiceImpl implements UploadAPIService {
    @Autowired
    private UploadAPIDao userUploadDao;

    //    根据用户id查找该用户上传的所有的API
    @Override
    public PageInfo<UploadAPI> selectUploadAPIByUserId(int userId,int pageNum, int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<UploadAPI> list=userUploadDao.selectUploadAPIByUserId(userId);
        return new PageInfo(list,5);
    }


    //    根据根据是否被审核查找所有符合的API
    @Override
    public PageInfo<UploadAPI> selectUploadAPIByIstrue(boolean istrue,int pageNum, int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<UploadAPI> list=userUploadDao.selectUploadAPIByIstrue(istrue);
        return new PageInfo(list,5);
    }


    //    根据根据是否被审核查找所有符合的API数目
    @Override
    public int selectUploadAPIByIstrueToSum(boolean istrue){
        return userUploadDao.selectUploadAPIByIstrueToSum(istrue);
    }

    //上传API
    @Override
    public boolean addUploadAPI(UploadAPI uploadAPI){
        boolean flag=false;
        try {
            flag=userUploadDao.addUploadAPI(uploadAPI);
        }catch (Exception e){
            System.out.println("上传API失败");
            e.printStackTrace();
        }
        return flag;
    }


    //更新上传API的审核状态为失败
    @Override
    public boolean updateUploadAPI(int id){
        boolean flag=false;
        try {
            flag=userUploadDao.updateUploadAPI(false,id);
        }catch (Exception e){
            System.out.println("更新上传API的审核状态为失败失败");
            e.printStackTrace();
        }
        return flag;
    }

    //    删除指定id的上传API
    @Override
    public boolean deleteUploadAPIById(int id){
        boolean flag=false;
        try {
            flag=userUploadDao.deleteUploadAPIById(id);
        }catch (Exception e){
            System.out.println("删除指定id的上传API失败");
            e.printStackTrace();
        }
        return flag;
    }

}
