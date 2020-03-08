package com.ysu.webapi.service;


import com.ysu.webapi.pojo.APIInfo;


import java.util.List;

public interface APIInfoService {
    //    根据指定的APIInfo id查找对应的APIInfo
    public APIInfo selectAPIInfoById(int id);



    //    查找所有APIInfo
    public List<APIInfo> selectAllAPIInfo();

    //    更新指定apiId的APIInfo clickNum
    public boolean updateAPIInfoClickNum(int apiId);

    //    更新指定apiId的APIInfo collectionNum
    public boolean updateAPIInfoCollectionNum(int apiId);

}
