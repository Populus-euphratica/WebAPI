package com.ysu.webapi.service;

import com.ysu.webapi.pojo.APISummary;
import com.ysu.webapi.pojo.APIVersions;

import java.util.List;

public interface APIVersionsService {

    //    根据id查找API版本
    public APIVersions selectAPIVersionsById(int id);

    //    根据APIId查找API版本
    public List<APIVersions> selectAPIVersionsByAPIId(int APIId);

    //    添加API版本
    public boolean addAPIVersions(APIVersions apiVersions, APISummary apiSummary);

    //    添加用户上传的API版本
    public boolean addUploadAPIVersions(int uploadVersionsId);

    //    更新指定id的API版本
    public boolean updateAPIVersions(APIVersions apiVersions,APISummary apiSummary);

    //    删除指定id的API版本
    public boolean deleteAPIVersionsById(int id,String logo);

    //    删除指定APIId的API版本
    public boolean deleteAPIVersionsByAPIId(int APIId);
}
