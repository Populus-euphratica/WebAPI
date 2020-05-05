package com.ysu.webapi.dao;

import com.ysu.webapi.pojo.Admin;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface AdminDao {

//    根据指定的管理员id查找对应的管理员
    @Select("select * from admin where id=#{admin_id}")
    Admin selectByIdAdmin(int admin_id);



//    查找所有管理员
    @Select("select * from admin")
    List<Admin> selectAllAdmin();
//    根据邮箱查找对应的管理员
    @Select("select * from admin where email=#{email}")
    Admin selectByEmailAdmin(String email);
//    添加管理员
    @Insert("insert into admin (name,email,password) values(#{name},#{email},#{password})")
    boolean addAdmin(Admin admin);
//    更新管理员用户名
    @Update("update admin set name=#{name} where id=#{id}")
    boolean updateAdminName(String name,int id);
    //    更新管理员密码
    @Update("update admin set password=#{password} where id=#{id}")
    boolean updateAdminPassword(String password,int id);


}
