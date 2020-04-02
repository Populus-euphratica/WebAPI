package com.ysu.webapi.dao;


import com.ysu.webapi.pojo.API;
import com.ysu.webapi.pojo.APIShow;
import com.ysu.webapi.pojo.UserConcern;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface UserConcernDao {

//    //    根据指定的userConcern id查找对应的userConcern
//    @Select("select * from userconcern where id=#{id}")
//    UserConcern selectUserConcernById(int userId);

    //    根据指定的userConcern userId查找对应的userConcern
    @Select("SELECT b.id,userconcern,date,name,descriptionBrief,category FROM api as a inner join(SELECT userconcern,id,date FROM userconcern where userId=#{userId}) as b where a.id=b.userconcern")
    List<APIShow> selectUserConcernByUserId(int userId);

    //    根据指定的userConcern userId查找对应的userConcern ID 并且不分页
    @Select("SELECT id,userConcern from userconcern where userId=#{userId}")
    List<UserConcern> selectUserConcernByUserIdALL(int userId);

    //    查找所有userConcern
    @Select("select * from userconcern")
    List<UserConcern> selectUserConcernAll();



    //    添加userConcern
    @Insert("insert into userconcern (userConcern,userId,date) values(#{userConcern},#{userId},#{date})")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    int addUserConcern(UserConcern userConcern);


    //    删除指定id的userConcern
    @Delete("delete from userconcern where id=#{id}")
    boolean deleteUserConcernById(int id);

    //    删除指定userId的userConcern
    @Delete("delete from userconcern where userId=#{userId}")
    boolean deleteUserConcernByUserId(int userId);


}
