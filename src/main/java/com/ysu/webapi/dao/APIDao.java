package com.ysu.webapi.dao;

import com.ysu.webapi.pojo.API;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface APIDao {
    //    根据指定的API id查找对应的API
    @Select("select * from api where id=#{id}")
    API selectAPIById(int id);
    //    根据指定的API name查找对应的API
    @Select("select * from api where name=%#{name}%")
    List<API> selectAPIByName(String name);
    //    根据指定的API category查找对应的API
    @Select("select * from api where category=%#{category}%")
    API selectAPIByCategory(String category);
    //    查找所有api
    @Select("select name,descriptionBrief,category,versions from api")
    List<API> selectAllAPI();
    //     添加api
    @Insert("insert into api (name,descriptionBrief,description,category,versions) values(#{name},#{descriptionBrief},#{description},#{category},#{versions})")
    boolean addAPI(API api);
    //    更新指定id的API
    @Update("update api set name=#{name},descriptionBrief=#{descriptionBrief},description=#{description},category=#{category},versions=#{versions} where id=#{id}")
    boolean updateAPI(API api);
    //    删除指定id的API
    @Delete("delete from api where id=#{id}")
    boolean deleteAPIById(String id);

}
