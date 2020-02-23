package com.ysu.webapi.service.impl;

import com.ysu.webapi.dao.APIDao;
import com.ysu.webapi.pojo.API;
import com.ysu.webapi.service.APIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class APIServiceImpl implements APIService {
    @Autowired
    private APIDao apiDao;

    //    根据指定的API id查找对应的API
    @Override
    public API selectAPIById(int id){
        return apiDao.selectAPIById(id);
    }

    //    根据指定的API name查找对应的API
    @Override
    public API selectAPIByName(String name){
        return apiDao.selectAPIByName(name);
    }

    //    根据指定的API category查找对应的API
    @Override
    public API selectAPIByCategory(String category){
        return apiDao.selectAPIByCategory(category);
    }

    //    查找所有api
    @Override
    public List<API> selectAllAPI(){
        return apiDao.selectAllAPI();
    }

    //     添加api
    @Override
    public boolean addAPI(API api){
        boolean flag=false;
        try {
            apiDao.addAPI(api);
            flag=true;
        }catch (Exception e){
            System.out.println("添加api失败");
            e.printStackTrace();
        }
        return false;
    }

    //    更新指定id的API
    @Override
    public boolean updateAPI(API api){
        boolean flag=false;
        try {
            apiDao.updateAPI(api);
            flag=true;
        }catch (Exception e){
            System.out.println("更新api失败");
            e.printStackTrace();
        }
        return flag;
    }

    //    删除指定id的API
    @Override
    public boolean deleteAPIById(String id){
        boolean flag=false;
        try {
            apiDao.deleteAPIById(id);
            flag=true;
        }catch (Exception e){
            System.out.println("删除API失败");
            e.printStackTrace();
        }
        return flag;
    }
}
