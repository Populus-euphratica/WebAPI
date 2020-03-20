package com.ysu.webapi.service.impl;

import com.ysu.webapi.dao.AdminDao;
import com.ysu.webapi.dao.ApplyForAdminDao;
import com.ysu.webapi.dao.FeedBackDao;
import com.ysu.webapi.dao.UserUploadDao;
import com.ysu.webapi.pojo.Admin;
import com.ysu.webapi.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDao adminDao;
    @Autowired
    private ApplyForAdminDao applyForAdminDao;
    @Autowired
    private FeedBackDao feedBackDao;
    @Autowired
    private UserUploadDao userUploadDao;

    // 添加管理员
    @Override
    public boolean addAdmin(Admin admin) {
        boolean flag = false;
        try {
            flag = adminDao.addAdmin(admin);
        } catch (Exception e) {
            System.out.println("添加管理员失败！");
            e.printStackTrace();
        }
        return flag;
    }

    //更新申请状态及添加管理员
    @Override
    @Transactional
    public boolean updateApplyAndAddAdmin(int id, Admin admin) {
        boolean flag = false;
        try {
            applyForAdminDao.updateApply(true, id);
            flag = adminDao.addAdmin(admin);
//            if(!flag){
//                throw new Exception("更新申请状态及添加管理员失败");
//            }
        } catch (Exception e) {
            System.out.println("更新申请状态及添加管理员失败");
            e.printStackTrace();
        }
        return flag;
    }

    // 更新管理员信息
    @Override
    public boolean updateAdmin(Admin admin) {
        boolean flag = false;
        try {
            flag = adminDao.updateAdmin(admin);
            System.out.println("更新管理员成功！");
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
    public Admin selectByIdAdmin(int admin_id) {
        return adminDao.selectByIdAdmin(admin_id);
    }

    // 按照账号查找管理员
    @Override
    public Admin selectByEmailAdmin(String email) {
        return adminDao.selectByEmailAdmin(email);
    }

    //     获取未读消息总和
    @Override
    public int selectMessageSum(){
        try {
            return feedBackDao.selectFeedBackByIstrueToSum(false)+applyForAdminDao.selectApplyByIstrueToSum(false)+userUploadDao.selectUserUploadByIstrueToSum(false);
        }catch (Exception e){
            System.out.println("获取未读消息总和失败！");
            e.printStackTrace();
            return 0;
        }
    }

}
