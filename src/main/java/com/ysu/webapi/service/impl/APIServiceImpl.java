package com.ysu.webapi.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ysu.webapi.dao.*;
import com.ysu.webapi.pojo.*;
import com.ysu.webapi.service.APIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.io.File;
import java.util.Iterator;
import java.util.List;
@Service
public class APIServiceImpl implements APIService {
    @Autowired
    private APIDao apiDao;
    @Autowired
    private APIInfoDao apiInfoDao;
    @Autowired
    private UploadAPIDao uploadAPIDao;
    @Autowired
    private APIVersionsDao apiVersionsDao;
    @Autowired
    private APISummaryDao apiSummaryDao;
    @Autowired
    private UserAPIDao userAPIDao;

    //    根据指定的API id查找对应的API
    @Override
    public API selectAPIById(int id){
        return apiDao.selectAPIById(id);
    }

    //    根据指定的API name查找对应的API
    @Override
    public PageInfo<API> selectAPIByName(String name,int pageNum,int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<API> list=apiDao.selectAPIByName(name);
        PageInfo<API> page=new PageInfo(list,5);
        return page;
    }

    //    根据指定的API category查找对应的API
    @Override
    public PageInfo<API> selectAPIByCategory(String category,int pageNum,int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<API> list=apiDao.selectAPIByCategory(category);
        PageInfo<API> page=new PageInfo(list,5);
        return page;
    }

    // 全部模糊匹配
    @Override
    public PageInfo<API> selectAPIByAll(String val,int pageNum,int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<API> list=apiDao.selectAPIByAll(val);
        PageInfo<API> page=new PageInfo(list,5);
        return page;
    }

    //    根据APIInfo clickNum查找排名靠前API
    @Override
    public List<API> selectAPIInfoByClickNum(){
        return apiInfoDao.selectAPIInfoByClickNum();
    }

    //    根据APIInfo collectionNum查找排名靠前API
    @Override
    public List<API> selectAPIInfoByCollectionNum(){
        return apiInfoDao.selectAPIInfoByCollectionNum();
    }


    //    根据查找所有api查找出现最多的种类并根据该种类的点击数进行推荐对应的API
    @Override
    public List<API> selectAPIByAllAPIRecommend(){
        return apiDao.selectAPIByAllAPIRecommend();
    }

    //    根据全部模糊匹配查找出现最多的种类并根据该种类的点击数进行推荐对应的API
    @Override
    public List<API> selectAPIByAllRecommend(String val){
        return apiDao.selectAPIByAllRecommend(val);
    }

    //    根据指定的API category查找出现最多的种类并根据该种类的点击数进行推荐对应的API
    @Override
    public List<API> selectAPIByCategoryRecommend(String category){
        return apiDao.selectAPIByCategoryRecommend(category);
    }

    //    根据指定的API name查找出现最多的种类并根据该种类的点击数进行推荐对应的API
    @Override
    public List<API> selectAPIByNameRecommend(String name){
        return apiDao.selectAPIByNameRecommend(name);
    }






    //    查找所有api
    @Override
    public PageInfo<API> selectAllAPI(int pageNum,int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<API> list=apiDao.selectAllAPI();
        return new PageInfo(list,5);
    }

    //     添加api
    @Override
    @Transactional
    public int addAPI(API api){
        boolean flag=false;
        try {
            apiDao.addAPI(api);
            flag=apiInfoDao.addAPIInfo(api.getId());
        }catch (Exception e){
            System.out.println("添加api失败");
            e.printStackTrace();
            throw new RuntimeException();
        }
        return api.getId();
    }

    //更新上传API的审核状态并添加api
    @Override
    @Transactional
    public boolean addAPIAndUpdateUploadAPI(int id){
        boolean flag=false;
        try {
            API api=new API();
            uploadAPIDao.updateUploadAPI(true,id);
            UploadAPI uploadAPI=uploadAPIDao.selectUserConcernById(id);
            api.setCategory(uploadAPI.getCategory());
            api.setDescriptionBrief(uploadAPI.getDescriptionBrief());
            api.setName(uploadAPI.getName());
            apiDao.addAPI(api);
            UserAPI userAPI=new UserAPI();
            userAPI.setAPIId(api.getId());
            userAPI.setUserId(uploadAPI.getUserId());
            userAPIDao.addUserAPI(userAPI);
            flag=apiInfoDao.addAPIInfo(api.getId());
        }catch (Exception e){
            System.out.println("添加api失败");
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
        }
        if (!flag){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return flag;
    }

    //    更新指定id的API
    @Override
    public boolean updateAPI(API api){
        boolean flag=false;
        try {
            flag=apiDao.updateAPI(api);
        }catch (Exception e){
            System.out.println("更新api失败");
            e.printStackTrace();
        }
        if (!flag){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return flag;
    }

    //    删除指定id的API
    @Override
    @Transactional
    public boolean deleteAPIById(int id){
        boolean flag=false;
        try {
            apiDao.deleteAPIById(id);
            apiSummaryDao.deleteAPISummaryByAPIId(id);
            apiVersionsDao.deleteAPIVersionsByAPIId(id);
            userAPIDao.delectUserAPIByAPIId(id);
            flag=apiInfoDao.deleteAPIInfoById(id);
        }catch (Exception e){
            System.out.println("删除API失败");
            e.printStackTrace();
            throw new RuntimeException();
        }
        return flag;
    }
}
