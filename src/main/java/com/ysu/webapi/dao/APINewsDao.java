package com.ysu.webapi.dao;

import com.ysu.webapi.pojo.APINews;
import org.apache.ibatis.annotations.*;

import java.sql.Date;
import java.util.List;
@Mapper
public interface APINewsDao {

    //    根据指定的APINews id查找对应的APINews
    @Select("select id,name,author,date,category,content from apinews where id=#{id}")
    APINews selectAPINewsById(int id);


    //    根据指定的APINews name查找对应的APINews
    @Select("select id,name,author,date,category,contentBrief from apinews where name like CONCAT('%',#{name},'%')")
    List<APINews> selectAPINewsByName(String name);


    //    根据指定的APINews author查找对应的APINews
    @Select("select id,name,author,date,category,contentBrief from apinews where author like CONCAT('%',#{author},'%')")
    List<APINews> selectAPINewsByAuthor(String author);

    //    根据指定的APINews date区间查找对应的APINews
    @Select("select id,name,author,date,category,contentBrief from apinews where date>#{date1} and date<#{date2}")
    List<APINews> selectAPINewsByDateSection(Date date1,Date date2);

    //    根据指定的APINews date查找对应的APINews
    @Select("select id,name,author,date,category,contentBrief from apinews where date=#{date}")
    List<APINews> selectAPINewsByDate(Date date);

    //    根据指定的APINews category查找对应的APINews
    @Select("select id,name,author,date,category,contentBrief from apinews where category=#{category}")
    List<APINews> selectAPINewsByCategory(String category);

    //    根据指定的APINews 全部模糊匹配查找对应的APINews
    @Select("select id,name,author,date,category,contentBrief from apinews where category like CONCAT('%',#{val},'%') or name like CONCAT('%',#{val},'%') or author like CONCAT('%',#{val},'%')")
    List<APINews> selectAPINewsByAll(String val);


    //    查找所有APINews
    @Select("select id,name,author,date,category,contentBrief from apinews")
    List<APINews> selectAllAPINews();


    //     添加apinews
    @Insert("insert into apinews (name,category,author,date,content,contentBrief) values(#{name},#{category},#{author},#{date},#{content},#{contentBrief})")
    boolean addAPINews(APINews api);


    //    更新指定id的APINews
    @Update("update apinews set name=#{name},author=#{author},date=#{date},content=#{content},category=#{category},contentBrief=#{contentBrief} where id=#{id}")
    boolean updateAPINews(APINews api);


    //    删除指定id的APINews
    @Delete("delete from apinews where id=#{id}")
    boolean deleteAPINewsById(int id);
}
