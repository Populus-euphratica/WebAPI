package com.ysu.webapi.service;

import com.ysu.webapi.pojo.API;

import java.util.List;

public interface APIService {

    //    根据指定的API id查找对应的API
    API selectAPIById(int id);

    //    根据指定的API name查找对应的API
    API selectAPIByName(String Name);

    //    根据指定的API category查找对应的API
    API selectAPIByCategory(String category);

    //    查找所有api
    List<API> selectAllAPI();

    //     添加api
    boolean addAPI(API api);

    //    更新指定id的API
    boolean updateAPI(API api);

    //    删除指定id的API
    boolean deleteAPIById(String id);


}
