package com.ysu.webapi.service.impl;

import com.ysu.webapi.dao.AdminDao;
import com.ysu.webapi.pojo.Admin;
import com.ysu.webapi.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDao adminDao;

    // 添加管理员
    @Override
    public boolean addAdmin(Admin admin) {
        boolean flag = false;
        try {
            adminDao.addAdmin(admin);
            flag = true;
        } catch (Exception e) {
            System.out.println("添加管理员失败！");
            e.printStackTrace();
        }
        return flag;
    }


    // 更新管理员信息
    @Override
    public boolean updateAdmin(Admin admin) {
        boolean flag = false;
        try {
            adminDao.updateAdmin(admin);
            System.out.println("更新管理员成功！");
            flag=true;
        } catch (Exception e) {
            System.out.println("更新失败！");
            e.printStackTrace();
        }
        return flag;
    }

    // 查找全部管理员
    @Override
    public List<Admin> selectAllAdmin() {
        return adminDao.selectAllAdmin();
    }

    // 按照ID查找管理员
    @Override
    public Admin selectByIdAdmin(int admin_id){
        return adminDao.selectByIdAdmin(admin_id);
    }

    // 按照账号查找管理员
    @Override
    public Admin selectByEmailAdmin(String email){
        return adminDao.selectByEmailAdmin(email);
    }

}
