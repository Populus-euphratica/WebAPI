package com.ysu.webapi.dao;

import com.ysu.webapi.pojo.API;
import com.ysu.webapi.pojo.UserAPI;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserAPIDao {

    @Select("select * from api as a inner join(select APIId from userapi where userId=#{userId}) as b on a.id=b.APIId")
    public List<API> selectUserAPIByUserId(int userId);

    @Insert("insert into userapi (APIId,userId) values(#{APIId},#{userId})")
    public boolean addUserAPI(UserAPI userAPI);

    @Delete("delete from userapi where userId=#{userId}")
    public boolean delectUserAPIByUserId(int userId);

    @Delete("delete from userapi where APIId=#{APIId}")
    public boolean delectUserAPIByAPIId(int APIId);
}
