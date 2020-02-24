package com.ysu.webapi.service;

import com.ysu.webapi.pojo.Admin;

import java.util.List;

public interface AdminService {

    //    添加管理员
    public boolean addAdmin(Admin admin);


    //    更改管理员信息
    public boolean updateAdmin(Admin admin);

    //    查找全部管理员
    public List<Admin> selectAllAdmin();

    //    按照ID查询指定用户
    public Admin selectByIdAdmin(int admin_id);

    //    按照账号查询指定用户
    public Admin selectByEmailAdmin(String admin_id);

}
