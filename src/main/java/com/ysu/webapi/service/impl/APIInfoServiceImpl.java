package com.ysu.webapi.service.impl;

import com.ysu.webapi.dao.APIInfoDao;
import com.ysu.webapi.pojo.APIInfo;
import com.ysu.webapi.service.APIInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class APIInfoServiceImpl implements APIInfoService {

    @Autowired
    private APIInfoDao apiInfoDao;

    //    根据指定的APIInfo id查找对应的APIInfo
    @Override
    public APIInfo selectAPIInfoById(int id){
        return apiInfoDao.selectAPIInfoById(id);
    }


    //    根据APIInfo clickNum查找排名靠前APIInfo
    @Override
    public List<APIInfo> selectAPIInfoByClickNum(){
        return apiInfoDao.selectAPIInfoByClickNum();
    }
    //    根据APIInfo collectionNum查找排名靠前APIInfo
    @Override
    public List<APIInfo> selectAPIInfoByCollectionNum(){
        return apiInfoDao.selectAPIInfoByCollectionNum();
    }

    //    查找所有APIInfo
    @Override
    public List<APIInfo> selectAllAPIInfo(){
        return apiInfoDao.selectAllAPIInfo();
    }

    //    更新指定apiId的APIInfo clickNum
    @Override
    @Transactional
    public boolean updateAPIInfoClickNum(int apiId){
        boolean flag=false;
        try {
            int clickNum=apiInfoDao.selectAPIInfoById(apiId).getId();
            flag=apiInfoDao.updateAPIInfoClickNum(clickNum+1,apiId);
        }catch (Exception e){
            System.out.println("更新指定apiId的APIInfo clickNum失败");
            e.printStackTrace();
        }
        return flag;
    }

    //    更新指定apiId的APIInfo collectionNum
    @Override
    @Transactional
    public boolean updateAPIInfoCollectionNum(int apiId){
        boolean flag=false;
        try {
            int collectionNum=apiInfoDao.selectAPIInfoById(apiId).getId();
            flag=apiInfoDao.updateAPIInfoCollectionNum(collectionNum+1, apiId);
        }catch (Exception e){
            System.out.println("更新指定apiId的APIInfo collectionNum失败");
            e.printStackTrace();
        }
        return flag;
    }
}
