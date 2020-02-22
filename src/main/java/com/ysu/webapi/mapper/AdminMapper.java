package com.ysu.webapi.mapper;

import com.ysu.webapi.pojo.Admin;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface AdminMapper {

//    根据指定的管理员id查找对应的管理员
    @Select("select * from admin where id=#{admin_id}")
    Admin selectByIdAdmin(String admin_id);
//    查找所有管理员
    @Select("select * from admin")
    List<Admin> selectAllAdmin();
//    根据邮箱查找对应的管理员
    @Select("select * from admin where email=#{email}")
    Admin selectByEmailAdmin(String email);
//    添加管理员
    @Insert("insert into admin (name,email,password) values(#{name},#{email},#{password})")
    boolean addAdmin(Admin admin);
//    更新管理员信息
    @Update("update admin set name=#{name},email=#{email},password=#{password} where id=#{id}")
    boolean updateAdmin(Admin admin);
}
