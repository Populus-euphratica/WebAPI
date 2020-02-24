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
    API selectAPIByName(String name);
    //    根据指定的API category查找对应的API
    @Select("select * from api where category=%#{category}%")
    API selectAPIByCategory(String category);
    //    查找所有api
    @Select("select * from api")
    List<API> selectAllAPI();
    //     添加api
    @Insert("insert into api (name,descriptionBiref,description,category,version) values(#{name},#{descriptionBiref},#{description},#{category},#{version})")
    boolean addAPI(API api);
    //    更新指定id的API
    @Update("update api set name=#{name},descriptionBiref=#{descriptionBiref},description=#{description},category=#{category},version=#{version} where id=#{id}")
    boolean updateAPI(API api);
    //    删除指定id的API
    @Delete("delete from api where id=#{id}")
    boolean deleteAPIById(String id);

}
