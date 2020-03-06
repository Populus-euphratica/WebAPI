package com.ysu.webapi.dao;

import com.ysu.webapi.pojo.ApplyForAdmin;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ApplyForAdminDao {

    //    根据指定的id查找对应的管理员申请
    @Select("select * from applyforadmin where id=#{id}")
    ApplyForAdmin selectApplyById(int id);
    //    查找所有管理员申请
    @Select("select * from applyforadmin")
    List<ApplyForAdmin> selectApplyAll();
    //    根据邮箱查找对应的管理员申请
    @Select("select * from applyforadmin where email=#{email}")
    ApplyForAdmin selectApplyByEmail(String email);
    //    添加管理员申请
    @Insert("insert into applyforadmin (name,email,password) values(#{name},#{email},#{password})")
    boolean addApply(ApplyForAdmin admin);

    //    删除指定id的管理员申请
    @Delete("delete from applyforadmin where id=#{id}")
    boolean deleteApplyById(int id);
}
