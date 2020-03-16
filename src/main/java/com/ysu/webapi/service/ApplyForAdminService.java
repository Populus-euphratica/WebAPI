package com.ysu.webapi.service;

import com.github.pagehelper.PageInfo;
import com.ysu.webapi.pojo.ApplyForAdmin;


public interface ApplyForAdminService {

    //    根据指定的id查找对应的管理员申请
    public ApplyForAdmin selectApplyById(int id);

    //根据是否被审核查找符合的ApplyForAdmin
    public PageInfo<ApplyForAdmin> selectApplyByIstrue(boolean istrue,int pageNum,int pageSize);

    //    获取是否被审核的数目
    public int selectApplyByIstrueToSum(boolean istrue);

    //    查找所有管理员申请
    public PageInfo<ApplyForAdmin> selectApplyAll(int pageNum,int pageSize);

    //    根据邮箱查找对应的管理员申请
    public ApplyForAdmin selectApplyByEmail(String email);

    //    添加管理员申请
    public boolean addApply(ApplyForAdmin applyForAdmin);

    //更新申请状态
    public boolean updateApply(boolean decide,int id);

    //    删除指定id的管理员申请
    public boolean deleteApplyById(int id);
}
