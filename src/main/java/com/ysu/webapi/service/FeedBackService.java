package com.ysu.webapi.service;

import com.github.pagehelper.PageInfo;
import com.ysu.webapi.pojo.FeedBack;
import com.ysu.webapi.pojo.FeedBackShow;


public interface FeedBackService {

    //根据指定id号从feedback中查找符合的FeedBack
    public FeedBack selectFeedBackById(int id);

    //根据是否被审核查找符合的FeedBack
    public PageInfo<FeedBackShow> selectFeedBackByIstrue(boolean istrue, int pageNum, int pageSize);

    //    获取是否被审核的数目
    public int selectFeedBackByIstrueToSum(boolean istrue);

    //添加一条反馈记录
    public boolean addFeedBack(FeedBack feedBack);

    //更新一条反馈记录
    public boolean updateFeedBack(FeedBack feedBack);

    //更新管理员对反馈的回复及状态
    public boolean updateFeedBackToReply(String reply,boolean decide,int id);

    //删除一条反馈记录
    public boolean deleteFeedBackById(int id);
}
