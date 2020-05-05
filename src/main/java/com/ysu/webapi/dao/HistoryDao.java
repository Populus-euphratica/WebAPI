package com.ysu.webapi.dao;

import com.ysu.webapi.pojo.API;
import com.ysu.webapi.pojo.History;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface HistoryDao {
    //    根据用户id和历史记录进行推荐
    @Select("select * from api where category=(select category from api as a inner join(select apiId from webapi.historytb where userId=#{userId}) as b on a.id=b.apiId GROUP BY category ORDER BY count( * ) DESC limit 1)limit 0,8")
    public List<API> selectByUserId(String userId);

    //添加历史记录
    @Insert("insert into historytb (userId,apiId,date) values(#{userId},#{apiId},#{date})")
    public boolean addHistory(History history);
}
