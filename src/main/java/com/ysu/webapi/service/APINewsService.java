package com.ysu.webapi.service;

import com.github.pagehelper.PageInfo;
import com.ysu.webapi.pojo.APINews;

import java.sql.Date;
import java.util.List;

public interface APINewsService {

    //    根据指定的APINews id查找对应的APINews
    public APINews selectAPINewsById(int id);


    //    根据指定的APINews name查找对应的APINews
    public PageInfo<APINews> selectAPINewsByName(String name,int pageNum,int pageSize);


    //    根据指定的APINews author查找对应的APINews
    public PageInfo<APINews> selectAPINewsByAuthor(String author,int pageNum,int pageSize);

    //    根据指定的APINews date区间查找对应的APINews
    public PageInfo<APINews> selectAPINewsByDateSection(Date data1, Date data2,int pageNum,int pageSize);

    //    根据指定的APINews date查找对应的APINews
    public PageInfo<APINews> selectAPINewsByDate(Date data,int pageNum,int pageSize);

    //    根据指定的APINews category查找对应的APINews
    public PageInfo<APINews> selectAPINewsByCategory(String category,int pageNum,int pageSize);

    //    根据指定的APINews 全部模糊匹配查找对应的APINews
    public PageInfo<APINews> selectAPINewsByAll(String val,int pageNum,int pageSize);

    //    查找所有APINews
    public PageInfo<APINews> selectAllAPINews(int pageNum,int pageSize);


    //     添加apinews
    public boolean addAPINews(APINews api);


    //    更新指定id的APINews
    public boolean updateAPINews(APINews api);


    //    删除指定id的APINews
    public boolean deleteAPINewsById(int id);

}
