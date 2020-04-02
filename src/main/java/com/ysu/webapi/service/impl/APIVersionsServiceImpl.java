package com.ysu.webapi.service.impl;

import com.ysu.webapi.dao.APISummaryDao;
import com.ysu.webapi.dao.APIVersionsDao;
import com.ysu.webapi.dao.UploadAPISummaryDao;
import com.ysu.webapi.dao.UploadAPIVersionsDao;
import com.ysu.webapi.pojo.APISummary;
import com.ysu.webapi.pojo.APIVersions;
import com.ysu.webapi.pojo.UploadAPISummary;
import com.ysu.webapi.pojo.UploadAPIVersions;
import com.ysu.webapi.service.APIVersionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import static com.ysu.webapi.WebapiApplication.path;
import java.io.File;
import java.util.Iterator;
import java.util.List;

@Service
public class APIVersionsServiceImpl implements APIVersionsService {

    @Autowired
    private APIVersionsDao apiVersionsDao;
    @Autowired
    private APISummaryDao apiSummaryDao;
    @Autowired
    private UploadAPIVersionsDao uploadAPIVersionsDao;
    @Autowired
    private UploadAPISummaryDao uploadAPISummaryDao;


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

    //    添加用户上传的API版本
    @Override
    @Transactional
    public boolean addUploadAPIVersions(int uploadVersionsId){
        boolean flag=false;
        try {
            UploadAPIVersions uploadAPIVersions=uploadAPIVersionsDao.selectUploadAPIVersionsById(uploadVersionsId);
            APIVersions apiVersions=new APIVersions(uploadAPIVersions);
            UploadAPISummary uploadAPISummary=uploadAPISummaryDao.selectUploadAPISummaryDaoByAPIVersionsId(uploadVersionsId);
            APISummary apiSummary=new APISummary(uploadAPISummary);
            apiVersionsDao.addAPIVersions(apiVersions);
            uploadAPIVersionsDao.updateUploadAPIVersionsBydecide(uploadVersionsId,true);
            apiSummary.setAPIVersionsId(apiVersions.getId());
            flag=apiSummaryDao.addAPISummary(apiSummary);
        }catch (Exception e){
            System.out.println("添加用户上传的API版本");
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
            File cashfile =new File(path+logo);
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

            List<APIVersions> apiVersionsList=apiVersionsDao.selectAPIVersionsByAPIId(APIId);
            Iterator<APIVersions> it = apiVersionsList.iterator();
            while (it.hasNext()){
                File cashfile =new File(path+it.next().getLogo());
                cashfile.delete();
            }
            flag=apiVersionsDao.deleteAPIVersionsByAPIId(APIId);
        }catch (Exception e){
            System.out.println("删除指定APIId的API版本失败");
            e.printStackTrace();
        }
        return flag;
    }
}
