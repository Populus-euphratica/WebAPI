package com.ysu.webapi.service;

import com.ysu.webapi.pojo.Admin;

import java.util.List;

public interface AdminService {

    //    添加管理员
    boolean addAdmin(Admin admin);


    //    更改管理员信息
    boolean updateAdmin(Admin admin);

    //    查找全部管理员
    List<Admin> selectAllAdmin();

    //    按照ID查询指定用户
    Admin selectByIdAdmin(String admin_id);

    //    按照账号查询指定用户
    Admin selectByEmailAdmin(String admin_id);

}
