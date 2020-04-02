package com.ysu.webapi.dao;


import com.ysu.webapi.pojo.APIVersions;
import com.ysu.webapi.pojo.UploadAPIShow;
import com.ysu.webapi.pojo.UploadAPIVersions;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UploadAPIVersionsDao {

    //    根据id查找API版本
    @Select("select * from uploadapiversions where id=#{id}")
    UploadAPIVersions selectUploadAPIVersionsById(int id);

    //    根据APIId查找API版本
    @Select("select id,versions,logo from uploadapiversions where APIId=#{APIId}")
    List<UploadAPIVersions> selectUploadAPIVersionsByAPIId(int APIId);

    //    查找API版本未被审核的数目
    @Select("select count(id) from uploadapiversions where istrue=false")
    int selectUploadAPIVersionsToSum();

    //    根据istrue查找是否审核通过API版本
    @Select("select * from api as a INNER JOIN (select id as versionsId,APIId,versions,logo,email,decide from uploadapiversions where istrue=#{istrue})as b on b.APIId=a.id")
    List<UploadAPIShow> selectUploadAPIVersionsByIstrue(boolean istrue);

    //    根据userId查找是否审核通过API版本
    @Select("select * from uploadapi as a INNER JOIN (select id as versionsId,APIId,versions,logo from uploadapiversions where istrue=true and decide=#{decide} and userId=#{userId})as b on b.APIId=a.id")
    List<UploadAPIVersions> selectUploadAPIVersionsByUserIdAndDecide(boolean decide,int userId);

    //    根据userId查找是否审核API版本
    @Select("select * from uploadapi as a INNER JOIN (select id as versionsId,APIId,versions,logo from uploadapiversions where istrue=#{istrue} and userId=#{userId})as b on b.APIId=a.id")
    List<UploadAPIVersions> selectUploadAPIVersionsByUserIdAndIstrue(boolean istrue,int userId);

    //    添加API版本
    @Insert("insert into uploadapiversions (APIId,name,userId,email,description,category,logo,versions,istrue,decide) values(#{APIId},#{name},#{userId},#{email},#{description},#{category},#{logo},#{versions},false,false)")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    boolean addUploadAPIVersions(UploadAPIVersions uploadAPIVersions);

    //    更新指定id的API版本
    @Update("update uploadapiversions set name=#{name},description=#{description},category=#{category},versions=#{versions},istrue=false,decide=false where id=#{id}")
    boolean updateUploadAPIVersions(UploadAPIVersions uploadAPIVersions);

    //    更新指定id的API版本,是否审核通过
    @Update("update uploadapiversions set istrue=true,decide=#{decide} where id=#{id}")
    boolean updateUploadAPIVersionsBydecide(int id,boolean decide);

    //    删除指定id的API版本
    @Delete("delete from uploadapiversions where id=#{id}")
    boolean deleteUploadAPIVersionsById(int id);

    //    删除指定APIId的API版本
    @Delete("delete from uploadapiversions where APIId=#{APIId}")
    boolean deleteUploadAPIVersionsByAPIId(int APIId);
}
