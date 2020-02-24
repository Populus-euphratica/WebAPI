package com.ysu.webapi.service.impl;

import com.ysu.webapi.dao.APINewsDao;
import com.ysu.webapi.pojo.APINews;
import com.ysu.webapi.service.APINewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
@Service
public class APINewsServiceImpl implements APINewsService {
    @Autowired
    private APINewsDao apiNewsDao;

    //    根据指定的APINews id查找对应的APINews
    @Override
    public APINews selectAPINewsById(int id){
        return apiNewsDao.selectAPINewsById(id);
    }


    //    根据指定的APINews name查找对应的APINews
    @Override
    public List<APINews> selectAPINewsByName(String name){
        return apiNewsDao.selectAPINewsByName(name);
    }


    //    根据指定的APINews author查找对应的APINews
    @Override
    public APINews selectAPINewsByAuthor(String author){
        return apiNewsDao.selectAPINewsByAuthor(author);
    }

    //    根据指定的APINews date区间查找对应的APINews
    @Override
    public List<APINews> selectAPINewsByDateSection(Date data1, Date data2){
        return apiNewsDao.selectAPINewsByDateSection(data1,data2);
    }

    //    根据指定的APINews date查找对应的APINews
    @Override
    public List<APINews> selectAPINewsByDate(Date data){
        return apiNewsDao.selectAPINewsByDate(data);
    }

    //    查找所有APINews
    @Override
    public List<APINews> selectAllAPINews(){
        return apiNewsDao.selectAllAPINews();
    }


    //     添加apinews
    @Override
    public boolean addAPINews(APINews api){
        boolean flag=false;
        try {
            apiNewsDao.addAPINews(api);
            flag=true;
        }catch (Exception e){
            System.out.println("添加APINews失败");
            e.printStackTrace();
        }
        return flag;
    }


    //    更新指定id的APINews
    @Override
    public boolean updateAPINews(APINews api){
        boolean flag=false;
        try {
            apiNewsDao.updateAPINews(api);
            flag=true;
        }catch (Exception e){
            System.out.println("更新APINews失败");
            e.printStackTrace();
        }
        return flag;
    }


    //    删除指定id的APINews
    @Override
    public boolean deleteAPINewsById(String id){
        boolean flag=false;
        try {
            apiNewsDao.deleteAPINewsById(id);
            flag=true;
        }catch (Exception e){
            System.out.println("删除APINews失败");
            e.printStackTrace();
        }
        return flag;
    }



}
