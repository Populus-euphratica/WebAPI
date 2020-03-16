package com.ysu.webapi.dao;

import com.ysu.webapi.pojo.FeedBack;
import com.ysu.webapi.pojo.FeedBackShow;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface FeedBackDao {
    //根据指定id号从feedback中查找符合的FeedBack
    @Select("select * from feedback where id=#{id}")
    FeedBack selectFeedBackById(int id);
    //根据是否被审核查找符合的FeedBack
    @Select("select feedback.id,theme,content,date,reply,company,userid,user.name,email from feedback,user where istrue=#{istrue} and feedback.userid=user.id")
    List<FeedBackShow> selectFeedBackByIstrue(boolean istrue);

//    获取是否被审核的数目
    @Select("select count(id) from feedback where istrue=#{istrue}")
    int selectFeedBackByIstrueToSum(boolean istrue);

    //添加一条反馈记录
    @Insert("insert into feedback (theme,content,date,userid,istrue) values(#{theme},#{content},#{date},#{userid},false)")
    boolean addFeedBack(FeedBack feedBack);
    //更新一条反馈记录
    @Update("update feedback set theme=#{theme},content=#{content},date=#{date},userid=#{userid},istrue=#{istrue},reply=#{reply}where id=#{id}")
    boolean updateFeedBack(FeedBack feedBack);

    //更新管理员对反馈的回复及状态
    @Update("update feedback set reply=#{reply},istrue=true where id=#{id}")
    boolean updateFeedBackToReply(String reply,int id);
    //删除一条反馈记录
    @Delete("delete from feedback where id=#{id}")
    boolean deleteFeedBackById(int id);
}
