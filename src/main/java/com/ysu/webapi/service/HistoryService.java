package com.ysu.webapi.service;

import com.ysu.webapi.pojo.API;
import com.ysu.webapi.pojo.History;

import java.util.List;

public interface HistoryService {
    //    根据用户id和历史记录进行推荐
    public List<API> selectByUserId(String userId);

    //添加历史记录
    public boolean addHistory(History history);
}
