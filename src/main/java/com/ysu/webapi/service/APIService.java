package com.ysu.webapi.service;

import com.github.pagehelper.PageInfo;
import com.ysu.webapi.pojo.API;
import com.ysu.webapi.pojo.APISummary;
import com.ysu.webapi.pojo.APIVersions;

import java.util.List;

public interface APIService {

    //    根据指定的API id查找对应的API
    public API selectAPIById(int id);

    //    根据指定的API name查找对应的API
    public PageInfo<API> selectAPIByName(String name,int pageNum,int pageSize);

    //    根据指定的API category查找对应的API
    public PageInfo<API> selectAPIByCategory(String category,int pageNum,int pageSize);

    //      全部模糊匹配
    public PageInfo<API> selectAPIByAll(String val,int pageNum,int pageSize);

    //    查找所有api
    public PageInfo<API> selectAllAPI(int pageNum, int pageSize);

    //    根据APIInfo clickNum查找排名靠前APIInfo
    public List<API> selectAPIInfoByClickNum();

    //    根据APIInfo collectionNum查找排名靠前APIInfo
    public List<API> selectAPIInfoByCollectionNum();

    //    根据查找所有api查找出现最多的种类并根据该种类的点击数进行推荐对应的API
    public List<API> selectAPIByAllAPIRecommend();

    //    根据全部模糊匹配查找出现最多的种类并根据该种类的点击数进行推荐对应的API
    public List<API> selectAPIByAllRecommend(String val);

    //    根据指定的API category查找出现最多的种类并根据该种类的点击数进行推荐对应的API
    public List<API> selectAPIByCategoryRecommend(String category);

    //    根据指定的API name查找出现最多的种类并根据该种类的点击数进行推荐对应的API
    public List<API> selectAPIByNameRecommend(String name);



    //     添加API
    public int addAPI(API api);


    //更新上传API的审核状态并添加API
    boolean addAPIAndUpdateUploadAPI(int id);


    //    更新指定id的API
    public boolean updateAPI(API api);

    //    删除指定id的API
    public boolean deleteAPIById(int id);


}
