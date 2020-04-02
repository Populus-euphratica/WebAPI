package com.ysu.webapi.service;


import com.github.pagehelper.PageInfo;
import com.ysu.webapi.pojo.UploadAPIShow;
import com.ysu.webapi.pojo.UploadAPISummary;
import com.ysu.webapi.pojo.UploadAPIVersions;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UploadAPIVersionsService {

    //    根据id查找API版本
    public UploadAPIVersions selectUploadAPIVersionsById(int id);

    //    根据APIId查找API版本
    public List<UploadAPIVersions> selectUploadAPIVersionsByAPIId(int APIId);

    //    查找API版本未被审核的数目
    public int selectUploadAPIVersionsToSum();

    //    根据APIId查找是否审核通过API版本
    public PageInfo<UploadAPIShow> selectUploadAPIVersionsByIstrue(boolean istrue, int pageNum, int pageSize);

    //    根据userId查找是否审核通过API版本
    public List<UploadAPIVersions> selectUploadAPIVersionsByUserIdAndDecide(boolean decide,int userId);

    //    根据userId查找是否审核API版本
    public List<UploadAPIVersions> selectUploadAPIVersionsByUserIdAndIstrue(boolean istrue, int userId);

    //    添加API版本
    public boolean addUploadAPIVersions(UploadAPIVersions apiVersions, UploadAPISummary apiSummary);

    //    更新指定id的API版本
    public boolean updateUploadAPIVersions(UploadAPIVersions apiVersions, UploadAPISummary apiSummary);

    //    更新指定id的API版本,是否审核通过
    public boolean updateUploadAPIVersionsBydecide(int id);

    //    删除指定id的API版本
    public boolean deleteUploadAPIVersionsById(int id, String logo);

    //    删除指定APIId的API版本
    public boolean deleteUploadAPIVersionsByAPIId(int APIId);
}
