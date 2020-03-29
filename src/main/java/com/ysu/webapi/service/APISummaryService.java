package com.ysu.webapi.service;

import com.ysu.webapi.pojo.APISummary;

public interface APISummaryService {

    //    根据指定的API版本id查找该版本的详细信息
    public APISummary selectAPISummaryDaoByAPIVersionsId(int APIVersionsId);

    //为指定的API和API版本添加该版本的详细信息
    public boolean addAPISummary(APISummary apiSummary);

    //通过指定的版本APIVersionsId进行更新
    public boolean updateAPISummaryByAPIVersionsId(APISummary apiSummary);

    //    删除指定id的apisummary
    public boolean deleteAPISummaryById(int id);

    //    删除指定APIId的apisummary
    public boolean deleteAPISummaryByAPIId(int APIId);

    //    删除指定APIVersionsId的apisummary
    public boolean deleteAPISummaryByAPIVersionsId(int APIVersionsId);
}
