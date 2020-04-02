package com.ysu.webapi.service;


import com.ysu.webapi.pojo.UploadAPISummary;

public interface UploadAPISummaryService {

    //    根据指定的API版本id查找该版本的详细信息
    public UploadAPISummary selectUploadAPISummaryDaoByAPIVersionsId(int APIVersionsId);

    //为指定的API和API版本添加该版本的详细信息
    public boolean addUploadAPISummary(UploadAPISummary uploadAPISummary);

    //通过指定的版本APIVersionsId进行更新
    public boolean updateUploadAPISummaryByAPIVersionsId(UploadAPISummary uploadAPISummary);

    //    删除指定id的apisummary
    public boolean deleteUploadAPISummaryById(int id);

    //    删除指定APIId的apisummary
    public boolean deleteUploadAPISummaryByAPIId(int APIId);

    //    删除指定APIVersionsId的apisummary
    public boolean deleteUploadAPISummaryByAPIVersionsId(int APIVersionsId);
}
