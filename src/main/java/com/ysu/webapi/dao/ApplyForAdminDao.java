package com.ysu.webapi.dao;

import com.ysu.webapi.pojo.ApplyForAdmin;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ApplyForAdminDao {

    //    根据指定的id查找对应的管理员申请
    @Select("select * from applyforadmin where id=#{id}")
    ApplyForAdmin selectApplyById(int id);
    //    查找所有管理员申请
    @Select("select * from applyforadmin")
    List<ApplyForAdmin> selectApplyAll();

    //根据是否被审核查找符合的ApplyForAdmin
    @Select("select * from applyforadmin where istrue=#{istrue}")
    List<ApplyForAdmin> selectApplyByIstrue(boolean istrue);

//    获取是否被审核的数目
    @Select("select count(id) from applyforadmin where istrue=#{istrue}")
    int selectApplyByIstrueToSum(boolean istrue);

    //    根据邮箱查找对应的管理员申请
    @Select("select * from applyforadmin where email=#{email}")
    ApplyForAdmin selectApplyByEmail(String email);
    //    添加管理员申请
    @Insert("insert into applyforadmin (name,email,password,reason,date,istrue,decide) values(#{name},#{email},#{password},#{reason},#{date},false,false)")
    boolean addApply(ApplyForAdmin applyForAdmin);

    //更新申请状态
    @Update("update applyforadmin set istrue=true,decide=#{decide} where id=#{id}")
    boolean updateApply(boolean decide,int id);

    //    删除指定id的管理员申请
    @Delete("delete from applyforadmin where id=#{id}")
    boolean deleteApplyById(int id);
}
