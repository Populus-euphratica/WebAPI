package com.ysu.webapi.service;

import com.ysu.webapi.pojo.Admin;

import java.util.List;

public interface AdminService {

    //    添加管理员
    public boolean addAdmin(Admin admin);


    //    更新管理员用户名
    boolean updateAdminName(String name,int id);

    //    更新管理员密码
    boolean updateAdminPassword(String password,int id);

    //更新申请状态并添加管理员
    public boolean updateApplyAndAddAdmin(int id, Admin admin);

    //    查找全部管理员
    public List<Admin> selectAllAdmin();

    //    按照ID查询指定用户
    public Admin selectByIdAdmin(int admin_id);

    //    按照账号查询指定用户
    public Admin selectByEmailAdmin(String email);

    //     获取未读消息总和
    public int selectMessageSum();


}
