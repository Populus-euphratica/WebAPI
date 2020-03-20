package com.ysu.webapi.service;

import com.github.pagehelper.PageInfo;
import com.ysu.webapi.pojo.UserUpload;

public interface UserUploadService {

    //    根据用户id查找该用户上传的所有的API
    public PageInfo<UserUpload> selectUserUploadByUserId(int userId,int pageNum, int pageSize);


    //    根据根据是否被审核查找所有符合的API
    PageInfo<UserUpload> selectUserUploadByIstrue(boolean istrue,int pageNum, int pageSize);

    //    根据根据是否被审核查找所有符合的API数目
    int selectUserUploadByIstrueToSum(boolean istrue);

    //上传API
    public boolean addUserUpload(UserUpload userUpload);


    //更新上传API的审核状态
    public boolean updateUserUpload(int id);

    //    删除指定id的上传API
    public boolean deleteUserUploadById(int id);


}
