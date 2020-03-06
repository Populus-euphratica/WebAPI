package com.ysu.webapi.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
    public PageInfo<APINews> selectAPINewsByName(String name,int pageNum,int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<APINews> list=apiNewsDao.selectAPINewsByName(name);
        PageInfo<APINews> page=new PageInfo(list,5);
        return page;
    }


    //    根据指定的APINews author查找对应的APINews
    @Override
    public PageInfo<APINews> selectAPINewsByAuthor(String author,int pageNum,int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<APINews> list=apiNewsDao.selectAPINewsByAuthor(author);
        PageInfo<APINews> page=new PageInfo(list,5);
        return page;
    }

    //    根据指定的APINews date区间查找对应的APINews
    @Override
    public PageInfo<APINews> selectAPINewsByDateSection(Date data1, Date data2,int pageNum,int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<APINews> list=apiNewsDao.selectAPINewsByDateSection(data1,data2);
        PageInfo<APINews> page=new PageInfo(list,5);
        return page;
    }

    //    根据指定的APINews date查找对应的APINews
    @Override
    public PageInfo<APINews> selectAPINewsByDate(Date data,int pageNum,int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<APINews> list=apiNewsDao.selectAPINewsByDate(data);
        PageInfo<APINews> page=new PageInfo(list,5);
        return page;
    }

    //    查找所有APINews
    @Override
    public PageInfo<APINews> selectAllAPINews(int pageNum,int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<APINews> list=apiNewsDao.selectAllAPINews();
        PageInfo<APINews> page=new PageInfo(list,5);
        return page;
    }


    //     添加apinews
    @Override
    public boolean addAPINews(APINews api){
        boolean flag=false;
        try {
            flag=apiNewsDao.addAPINews(api);
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
            flag=apiNewsDao.updateAPINews(api);
        }catch (Exception e){
            System.out.println("更新APINews失败");
            e.printStackTrace();
        }
        return flag;
    }


    //    删除指定id的APINews
    @Override
    public boolean deleteAPINewsById(int id){
        boolean flag=false;
        try {
            flag=apiNewsDao.deleteAPINewsById(id);
        }catch (Exception e){
            System.out.println("删除APINews失败");
            e.printStackTrace();
        }
        return flag;
    }



}
