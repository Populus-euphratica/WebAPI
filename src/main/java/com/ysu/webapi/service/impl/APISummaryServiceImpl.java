package com.ysu.webapi.service.impl;

import com.ysu.webapi.dao.APISummaryDao;
import com.ysu.webapi.pojo.APISummary;
import com.ysu.webapi.service.APISummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class APISummaryServiceImpl implements APISummaryService {

    @Autowired
    private APISummaryDao apiSummaryDao;

    //    根据指定的API版本id查找该版本的详细信息
    public APISummary selectAPISummaryDaoByAPIVersionsId(int APIVersionsId){
        return apiSummaryDao.selectAPISummaryDaoByAPIVersionsId(APIVersionsId);
    }

    //为指定的API和API版本添加该版本的详细信息
    @Override
    public boolean addAPISummary(APISummary apiSummary){
        boolean flag=false;
        try {
            flag=apiSummaryDao.addAPISummary(apiSummary);
        }catch (Exception e){
            System.out.println("为指定的API和API版本添加该版本的详细信息失败");
            e.printStackTrace();
        }
        return flag;
    }

    //通过指定的版本APIVersionsId进行更新
    @Override
    public boolean updateAPISummaryByAPIVersionsId(APISummary apiSummary){
        boolean flag=false;
        try{
            flag=apiSummaryDao.updateAPISummaryByAPIVersionsId(apiSummary);
        }catch (Exception e){
            System.out.println("通过指定的版本信息id进行更新失败");
            e.printStackTrace();
        }
        return flag;
    }

    //    删除指定id的apisummary
    @Override
    public boolean deleteAPISummaryById(int id){
        boolean flag=false;
        try {
            flag=apiSummaryDao.deleteAPISummaryById(id);
        }catch (Exception e){
            System.out.println(" 删除指定id的apisummary失败");
            e.printStackTrace();
        }
        return flag;
    }

    //    删除指定APIId的apisummary
    @Override
    public boolean deleteAPISummaryByAPIId(int APIId){
        boolean flag=false;
        try{
            flag=apiSummaryDao.deleteAPISummaryByAPIId(APIId);
        }catch (Exception e){
            System.out.println("删除指定APIId的apisummary失败");
            e.printStackTrace();
        }
        return flag;
    }

    //    删除指定APIVersionsId的apisummary
    @Override
    public boolean deleteAPISummaryByAPIVersionsId(int APIVersionsId){
        boolean flag=false;
        try{
            flag=apiSummaryDao.deleteAPISummaryByAPIVersionsId(APIVersionsId);
        }catch (Exception e){
            System.out.println("删除指定APIVersionsId的apisummary失败");
            e.printStackTrace();
        }
        return flag;
    }
}
