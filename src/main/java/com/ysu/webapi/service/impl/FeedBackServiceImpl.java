package com.ysu.webapi.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ysu.webapi.dao.FeedBackDao;
import com.ysu.webapi.pojo.FeedBack;
import com.ysu.webapi.pojo.FeedBackShow;
import com.ysu.webapi.service.FeedBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FeedBackServiceImpl implements FeedBackService {
    @Autowired
    private FeedBackDao feedBackDao;

    //根据指定id号从feedback中查找符合的FeedBack
    @Override
    public FeedBack selectFeedBackById(int id){
        return feedBackDao.selectFeedBackById(id);
    }

    //根据是否被审核查找符合的FeedBack
    @Override
    public PageInfo<FeedBackShow> selectFeedBackByIstrue(boolean istrue, int pageNum, int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<FeedBackShow> list=feedBackDao.selectFeedBackByIstrue(istrue);
        return new PageInfo(list,5);
    }

    //    获取是否被审核的数目
    @Override
    public int selectFeedBackByIstrueToSum(boolean istrue){
        return feedBackDao.selectFeedBackByIstrueToSum(istrue);
    }
    //添加一条反馈记录
    @Override
    public boolean addFeedBack(FeedBack feedBack){
        boolean flag=false;
        try{
            flag=feedBackDao.addFeedBack(feedBack);
        }catch (Exception e){
            System.out.println("添加一条反馈记录失败！");
            e.printStackTrace();
        }
        return flag;
    }

    //更新一条反馈记录
    @Override
    public boolean updateFeedBack(FeedBack feedBack){
        boolean flag=false;
        try{
            flag=feedBackDao.updateFeedBack(feedBack);
        }catch (Exception e){
            System.out.println("更新一条反馈记录失败！");
            e.printStackTrace();
        }
        return flag;
    }

    //更新管理员对反馈的回复
    @Override
    public boolean updateFeedBackToReply(String reply,int id){
        boolean flag=false;
        try {
            flag=feedBackDao.updateFeedBackToReply(reply,id);
        }catch (Exception e){
            System.out.println("更新管理员对反馈的回复失败！");
            e.printStackTrace();
        }
        return flag;
    }

    //删除一条反馈记录
    @Override
    public boolean deleteFeedBackById(int id){
        boolean flag=false;
        try {
            flag=feedBackDao.deleteFeedBackById(id);
        }catch (Exception e){
            System.out.println("删除一条反馈记录失败！");
            e.printStackTrace();
        }
        return flag;
    }
}
