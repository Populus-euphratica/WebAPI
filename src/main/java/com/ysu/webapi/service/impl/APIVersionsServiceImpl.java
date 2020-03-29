package com.ysu.webapi.service.impl;

import com.ysu.webapi.dao.APISummaryDao;
import com.ysu.webapi.dao.APIVersionsDao;
import com.ysu.webapi.pojo.APISummary;
import com.ysu.webapi.pojo.APIVersions;
import com.ysu.webapi.service.APIVersionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.List;

@Service
public class APIVersionsServiceImpl implements APIVersionsService {

    @Autowired
    private APIVersionsDao apiVersionsDao;
    @Autowired
    private APISummaryDao apiSummaryDao;


    //    根据id查找API版本
    public APIVersions selectAPIVersionsById(int id){
        return apiVersionsDao.selectAPIVersionsById(id);
    }

    //    根据APIId查找API版本
    public List<APIVersions> selectAPIVersionsByAPIId(int APIId){
        return apiVersionsDao.selectAPIVersionsByAPIId(APIId);
    }

    //    添加API版本
    @Override
    @Transactional
    public boolean addAPIVersions(APIVersions apiVersions, APISummary apiSummary){
        boolean flag=false;
        try{
            apiVersionsDao.addAPIVersions(apiVersions);
            apiSummary.setAPIId(apiVersions.getAPIId());
            apiSummary.setAPIVersionsId(apiVersions.getId());
            flag=apiSummaryDao.addAPISummary(apiSummary);
        }catch (Exception e){
            System.out.println("添加API版本失败");
            e.printStackTrace();
            throw new RuntimeException();
        }
        return flag;
    }

    //    更新指定id的API版本
    @Override
    @Transactional
    public boolean updateAPIVersions(APIVersions apiVersions,APISummary apiSummary){
        boolean flag=false;
        try{
            apiVersionsDao.updateAPIVersions(apiVersions);
            flag=apiSummaryDao.updateAPISummaryByAPIVersionsId(apiSummary);
//            if (!flag){
//                throw new RuntimeException();
//            }
        }catch (Exception e){
            System.out.println("更新指定id的API版本失败");
            e.printStackTrace();
            throw new RuntimeException();
        }
        return flag;
    }

    //    删除指定id的API版本
    @Transactional
    @Override
    public boolean deleteAPIVersionsById(int id,String logo){
        boolean flag=false;
        try{
            File cashfile =new File("C:\\Users\\贾廷刚\\Desktop\\Pingendo\\Web\\default\\APILogo\\"+logo);
            cashfile.delete();
            apiVersionsDao.deleteAPIVersionsById(id);
            flag=apiSummaryDao.deleteAPISummaryByAPIVersionsId(id);
        }catch (Exception e){
            System.out.println("删除指定id的API版本失败");
            e.printStackTrace();
            throw new RuntimeException();
        }
        return flag;
    }

    //    删除指定APIId的API版本
    public boolean deleteAPIVersionsByAPIId(int APIId){
        boolean flag=false;
        try {
            flag=apiVersionsDao.deleteAPIVersionsByAPIId(APIId);
        }catch (Exception e){
            System.out.println("删除指定APIId的API版本失败");
            e.printStackTrace();
        }
        return flag;
    }
}
