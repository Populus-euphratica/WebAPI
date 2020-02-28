package com.ysu.webapi.service;

import com.github.pagehelper.PageInfo;
import com.ysu.webapi.pojo.API;

import java.util.List;

public interface APIService {

    //    根据指定的API id查找对应的API
    public API selectAPIById(int id);

    //    根据指定的API name查找对应的API
    public PageInfo<API> selectAPIByName(String name,int pageNum,int pageSize);

    //    根据指定的API category查找对应的API
    public PageInfo<API> selectAPIByCategory(String category,int pageNum,int pageSize);

    // 全部匹配
    public PageInfo<API> selectAPIByAll(String val,int pageNum,int pageSize);

    //    查找所有api
    public PageInfo<API> selectAllAPI(int pageNum, int pageSize);

    //     添加api
    public boolean addAPI(API api);

    //    更新指定id的API
    public boolean updateAPI(API api);

    //    删除指定id的API
    public boolean deleteAPIById(String id);


}
