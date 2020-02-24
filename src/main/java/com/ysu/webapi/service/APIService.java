package com.ysu.webapi.service;

import com.ysu.webapi.pojo.API;

import java.util.List;

public interface APIService {

    //    根据指定的API id查找对应的API
    public API selectAPIById(int id);

    //    根据指定的API name查找对应的API
    public List<API> selectAPIByName(String name);

    //    根据指定的API category查找对应的API
    public API selectAPIByCategory(String category);

    //    查找所有api
    public List<API> selectAllAPI();

    //     添加api
    public boolean addAPI(API api);

    //    更新指定id的API
    public boolean updateAPI(API api);

    //    删除指定id的API
    public boolean deleteAPIById(String id);


}
