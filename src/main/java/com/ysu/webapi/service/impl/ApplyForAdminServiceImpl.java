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


    //根据是否被审核查找符合的ApplyForAdmin
    @Override
    public PageInfo<ApplyForAdmin> selectApplyByIstrue(boolean istrue,int pageNum,int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<ApplyForAdmin> list=applyForAdminDao.selectApplyByIstrue(istrue);
        PageInfo<ApplyForAdmin> page=new PageInfo(list,5);
        return page;
    }

    //    获取是否被审核的数目
    @Override
    public int selectApplyByIstrueToSum(boolean istrue){
        return applyForAdminDao.selectApplyByIstrueToSum(istrue);
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
            flag=applyForAdminDao.addApply(applyForAdmin);
        }catch (Exception e){
            System.out.println("添加ApplyForAdmin失败");
            e.printStackTrace();
        }
        return flag;
    }


    //更新申请状态
    @Override
    public boolean updateApply(boolean decide,int id){
        boolean flag=false;
        try {
            flag=applyForAdminDao.updateApply(decide,id);
        }catch (Exception e){
            System.out.println("更新申请状态失败");
            e.printStackTrace();
        }
        return flag;
    }

    //    删除指定id的管理员申请
    @Override
    public boolean deleteApplyById(int id){
        boolean flag=false;
        try {
            flag=applyForAdminDao.deleteApplyById(id);
        }catch (Exception e){
            System.out.println("删除ApplyForAdmin失败");
            e.printStackTrace();
        }
        return flag;
    }
}
