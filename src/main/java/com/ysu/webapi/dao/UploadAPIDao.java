package com.ysu.webapi.dao;

import com.ysu.webapi.pojo.UploadAPI;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UploadAPIDao {

    //    根据指定的UploadAPI id查找对应的UploadAPI
    @Select("select * from userupload where id=#{id}")
    UploadAPI selectUserConcernById(int id);

    //    根据用户id查找该用户上传的所有的API
    @Select("select userId,name,descriptionBrief,category,istrue,decide,date from userupload where userId=#{userId}")
    List<UploadAPI> selectUploadAPIByUserId(int userId);


    //    根据根据是否被审核查找所有符合的API
    @Select("select id,userId,name,descriptionBrief,category,istrue,decide,date,email from userupload where istrue=#{istrue}")
    List<UploadAPI> selectUploadAPIByIstrue(boolean istrue);

    //    根据根据是否被审核查找所有符合的API数目
    @Select("select count(id) from userupload where istrue=#{istrue}")
    int selectUploadAPIByIstrueToSum(boolean istrue);


    //上传API
    @Insert("insert into userupload (userId,name,descriptionBrief,category,istrue,decide,date,email) values(#{userId},#{name},#{descriptionBrief},#{category},false,false,#{date},#{email})")
    boolean addUploadAPI(UploadAPI uploadAPI);


    //更新上传API的审核状态
    @Update("update userupload set istrue=true,decide=#{decide} where id=#{id}")
    boolean updateUploadAPI(boolean decide, int id);

    //    删除指定id的上传API
    @Delete("delete from userupload where id=#{id}")
    boolean deleteUploadAPIById(int id);

    //删除该用户所有上传的API
    @Delete("delete from userupload where UserId=#{UserId}")
    boolean deleteUploadAPIByUserId(int UserId);
}
