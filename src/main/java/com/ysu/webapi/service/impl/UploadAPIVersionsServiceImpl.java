package com.ysu.webapi.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ysu.webapi.dao.UploadAPISummaryDao;
import com.ysu.webapi.dao.UploadAPIVersionsDao;

import com.ysu.webapi.pojo.UploadAPIShow;
import com.ysu.webapi.pojo.UploadAPISummary;
import com.ysu.webapi.pojo.UploadAPIVersions;

import com.ysu.webapi.service.UploadAPIVersionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import static com.ysu.webapi.WebapiApplication.path;
import java.io.File;
import java.util.Iterator;
import java.util.List;

@Service
public class UploadAPIVersionsServiceImpl implements UploadAPIVersionsService {

    @Autowired
    private UploadAPIVersionsDao apiVersionsDao;
    @Autowired
    private UploadAPISummaryDao apiSummaryDao;


    //    根据id查找API版本
    @Override
    public UploadAPIVersions selectUploadAPIVersionsById(int id){
        return apiVersionsDao.selectUploadAPIVersionsById(id);
    }

    //    根据APIId查找API版本
    @Override
    public List<UploadAPIVersions> selectUploadAPIVersionsByAPIId(int APIId){
        return apiVersionsDao.selectUploadAPIVersionsByAPIId(APIId);
    }

    //    查找API版本未被审核的数目
    @Override
    public int selectUploadAPIVersionsToSum(){
        return apiVersionsDao.selectUploadAPIVersionsToSum();
    }

    //    根据APIId查找是否审核通过API版本
    public PageInfo<UploadAPIShow> selectUploadAPIVersionsByIstrue(boolean istrue, int pageNum, int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<UploadAPIShow> list=apiVersionsDao.selectUploadAPIVersionsByIstrue(istrue);
        return new PageInfo(list,5);
    }

    //    根据userId查找是否审核通过API版本
    @Override
    public List<UploadAPIVersions> selectUploadAPIVersionsByUserIdAndDecide(boolean decide,int userId){

        return apiVersionsDao.selectUploadAPIVersionsByUserIdAndDecide(decide, userId);
    }

    //    根据userId查找是否审核API版本
    @Override
    public List<UploadAPIVersions> selectUploadAPIVersionsByUserIdAndIstrue(boolean istrue, int userId){
        return apiVersionsDao.selectUploadAPIVersionsByUserIdAndIstrue( istrue,userId);
    }

    //    添加API版本
    @Override
    @Transactional
    public boolean addUploadAPIVersions(UploadAPIVersions apiVersions, UploadAPISummary apiSummary){
        boolean flag=false;
        try{
            apiVersionsDao.addUploadAPIVersions(apiVersions);
            apiSummary.setAPIId(apiVersions.getAPIId());
            apiSummary.setAPIVersionsId(apiVersions.getId());
            flag=apiSummaryDao.addUploadAPISummary(apiSummary);
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
    public boolean updateUploadAPIVersions(UploadAPIVersions apiVersions,UploadAPISummary apiSummary){
        boolean flag=false;
        try{
            apiVersionsDao.updateUploadAPIVersions(apiVersions);
            flag=apiSummaryDao.updateUploadAPISummaryByAPIVersionsId(apiSummary);
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

    //    更新指定id的API版本,是否审核通过
    @Override
    @Transactional
    public boolean updateUploadAPIVersionsBydecide(int id){
        boolean flag=false;
        try {
            flag=apiVersionsDao.updateUploadAPIVersionsBydecide(id, false);
        }catch (Exception e){
            System.out.println("更新指定id的API版本,是否审核通过失败");
            e.printStackTrace();
            throw new RuntimeException();
        }
        return flag;
    }

    //    删除指定id的API版本
    @Transactional
    @Override
    public boolean deleteUploadAPIVersionsById(int id,String logo){
        boolean flag=false;
        try{
            File cashfile =new File(path+logo);
            cashfile.delete();
            apiVersionsDao.deleteUploadAPIVersionsById(id);
            flag=apiSummaryDao.deleteUploadAPISummaryByAPIVersionsId(id);
        }catch (Exception e){
            System.out.println("删除指定id的API版本失败");
            e.printStackTrace();
            throw new RuntimeException();
        }
        return flag;
    }

    //    删除指定APIId的API版本
    public boolean deleteUploadAPIVersionsByAPIId(int APIId){
        boolean flag=false;
        try {

            List<UploadAPIVersions> apiVersionsList=apiVersionsDao.selectUploadAPIVersionsByAPIId(APIId);
            Iterator<UploadAPIVersions> it = apiVersionsList.iterator();
            while (it.hasNext()){
                File cashfile =new File(path+it.next().getLogo());
                cashfile.delete();
            }
            flag=apiVersionsDao.deleteUploadAPIVersionsByAPIId(APIId);
        }catch (Exception e){
            System.out.println("删除指定APIId的API版本失败");
            e.printStackTrace();
        }
        return flag;
    }
}
