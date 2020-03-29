package com.ysu.webapi.dao;


import com.ysu.webapi.pojo.APIVersions;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface APIVersionsDao {

    //    根据id查找API版本
    @Select("select * from apiversions where id=#{id}")
    APIVersions selectAPIVersionsById(int id);

    //    根据APIId查找API版本
    @Select("select id,versions,logo from apiversions where APIId=#{APIId}")
    List<APIVersions> selectAPIVersionsByAPIId(int APIId);
    //    添加API版本
    @Insert("insert into apiversions (APIId,name,description,category,logo,versions) values(#{APIId},#{name},#{description},#{category},#{logo},#{versions})")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    boolean addAPIVersions(APIVersions apiVersions);
    //    更新指定id的API版本
    @Update("update apiversions set name=#{name},description=#{description},category=#{category},versions=#{versions} where id=#{id}")
    boolean updateAPIVersions(APIVersions apiVersions);

    //    删除指定id的API版本
    @Delete("delete from apiversions where id=#{id}")
    boolean deleteAPIVersionsById(int id);

    //    删除指定APIId的API版本
    @Delete("delete from apiversions where APIId=#{APIId}")
    boolean deleteAPIVersionsByAPIId(int APIId);
}
