package com.ysu.webapi.dao;

import com.ysu.webapi.pojo.UploadAPI;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UploadAPIDao {

    //    根据指定的UploadAPI id查找对应的UploadAPI
    @Select("select * from uploadapi where id=#{id}")
    UploadAPI selectUserConcernById(int id);

    //    根据用户id及是否审核通过查找该用户上传的所有的API
    @Select("select * from uploadapi where userId=#{userId} and istrue=true and decide=#{decide}")
    List<UploadAPI> selectUploadAPIByUserIdAndDecide(int userId,boolean decide);

    //    根据用户id及是否被审核查找该用户上传的所有的API
    @Select("select * from uploadapi where userId=#{userId}")
    List<UploadAPI> selectUploadAPIByUserIdAndIstrue(int userId);

    //    根据根据是否被审核查找所有符合的API
    @Select("select * from uploadapi where istrue=#{istrue}")
    List<UploadAPI> selectUploadAPIByIstrue(boolean istrue);

    //    根据根据是否被审核查找所有符合的API数目
    @Select("select count(id) from uploadapi where istrue=#{istrue}")
    int selectUploadAPIByIstrueToSum(boolean istrue);


    //上传API
    @Insert("insert into uploadapi (userId,name,descriptionBrief,category,istrue,decide,date,email) values(#{userId},#{name},#{descriptionBrief},#{category},false,false,#{date},#{email})")
    boolean addUploadAPI(UploadAPI uploadAPI);


    //更新上传API的审核状态
    @Update("update uploadapi set istrue=true,decide=#{decide} where id=#{id}")
    boolean updateUploadAPI(boolean decide, int id);

    //    删除指定id的上传API
    @Delete("delete from uploadapi where id=#{id}")
    boolean deleteUploadAPIById(int id);

    //删除该用户所有上传的API
    @Delete("delete from uploadapi where UserId=#{UserId}")
    boolean deleteUploadAPIByUserId(int UserId);
}
