package com.ysu.webapi.service.impl;

import com.ysu.webapi.dao.HistoryDao;
import com.ysu.webapi.pojo.API;
import com.ysu.webapi.pojo.History;
import com.ysu.webapi.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoryServiceImpl implements HistoryService {
    @Autowired
    private HistoryDao historyDao;

    //    根据用户id和历史记录进行推荐
    @Override
    public List<API> selectByUserId(String userId){
        return historyDao.selectByUserId(userId);
    }

    //添加历史记录
    @Override
    public boolean addHistory(History history){
        boolean flag=false;
        try {
            flag=historyDao.addHistory(history);
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }
}
