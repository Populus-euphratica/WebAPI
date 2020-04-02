package com.ysu.webapi.service.impl;


import com.ysu.webapi.dao.UploadAPISummaryDao;
import com.ysu.webapi.pojo.UploadAPISummary;
import com.ysu.webapi.service.UploadAPISummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UploadAPISummaryServiceImpl implements UploadAPISummaryService {

    @Autowired
    private UploadAPISummaryDao apiSummaryDao;

    //    根据指定的API版本id查找该版本的详细信息
    public UploadAPISummary selectUploadAPISummaryDaoByAPIVersionsId(int APIVersionsId){
        return apiSummaryDao.selectUploadAPISummaryDaoByAPIVersionsId(APIVersionsId);
    }

    //为指定的API和API版本添加该版本的详细信息
    @Override
    public boolean addUploadAPISummary(UploadAPISummary apiSummary){
        boolean flag=false;
        try {
            flag=apiSummaryDao.addUploadAPISummary(apiSummary);
        }catch (Exception e){
            System.out.println("为指定的API和API版本添加该版本的详细信息失败");
            e.printStackTrace();
        }
        return flag;
    }

    //通过指定的版本APIVersionsId进行更新
    @Override
    public boolean updateUploadAPISummaryByAPIVersionsId(UploadAPISummary apiSummary){
        boolean flag=false;
        try{
            flag=apiSummaryDao.updateUploadAPISummaryByAPIVersionsId(apiSummary);
        }catch (Exception e){
            System.out.println("通过指定的版本信息id进行更新失败");
            e.printStackTrace();
        }
        return flag;
    }

    //    删除指定id的apisummary
    @Override
    public boolean deleteUploadAPISummaryById(int id){
        boolean flag=false;
        try {
            flag=apiSummaryDao.deleteUploadAPISummaryById(id);
        }catch (Exception e){
            System.out.println(" 删除指定id的apisummary失败");
            e.printStackTrace();
        }
        return flag;
    }

    //    删除指定APIId的apisummary
    @Override
    public boolean deleteUploadAPISummaryByAPIId(int APIId){
        boolean flag=false;
        try{
            flag=apiSummaryDao.deleteUploadAPISummaryByAPIId(APIId);
        }catch (Exception e){
            System.out.println("删除指定APIId的apisummary失败");
            e.printStackTrace();
        }
        return flag;
    }

    //    删除指定APIVersionsId的apisummary
    @Override
    public boolean deleteUploadAPISummaryByAPIVersionsId(int APIVersionsId){
        boolean flag=false;
        try{
            flag=apiSummaryDao.deleteUploadAPISummaryByAPIVersionsId(APIVersionsId);
        }catch (Exception e){
            System.out.println("删除指定APIVersionsId的apisummary失败");
            e.printStackTrace();
        }
        return flag;
    }
}
