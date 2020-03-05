package com.ysu.webapi.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ysu.webapi.dao.ApplyForAdminDao;
import com.ysu.webapi.pojo.ApplyForAdmin;
import com.ysu.webapi.service.ApplyForAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplyForAdminServiceImpl implements ApplyForAdminService {
    @Autowired
    ApplyForAdminDao applyForAdminDao;

    //    根据指定的id查找对应的管理员申请
    @Override
    public ApplyForAdmin selectApplyById(int id){
        return applyForAdminDao.selectApplyById(id);
    }

    //    查找所有管理员申请
    @Override
    public PageInfo<ApplyForAdmin> selectApplyAll(int pageNum, int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<ApplyForAdmin> list=applyForAdminDao.selectApplyAll();
        PageInfo<ApplyForAdmin> page=new PageInfo(list,5);
        return page;
    }

    //    根据邮箱查找对应的管理员申请
    @Override
    public ApplyForAdmin selectApplyByEmail(String email){
        return applyForAdminDao.selectApplyByEmail(email);
    }

    //    添加管理员申请
    @Override
    public boolean addApply(ApplyForAdmin applyForAdmin){
        boolean flag=false;
        try {
            applyForAdminDao.addApply(applyForAdmin);
            flag=true;
        }catch (Exception e){
            System.out.println("添加ApplyForAdmin失败");
            e.printStackTrace();
        }
        return flag;
    }


    //    删除指定id的管理员申请
    @Override
    public boolean deleteApplyById(String id){
        boolean flag=false;
        try {
            applyForAdminDao.deleteApplyById(id);
            flag=true;
        }catch (Exception e){
            System.out.println("删除ApplyForAdmin失败");
            e.printStackTrace();
        }
        return flag;
    }
}
