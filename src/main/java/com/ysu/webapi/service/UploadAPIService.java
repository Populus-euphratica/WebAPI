package com.ysu.webapi.service;

import com.github.pagehelper.PageInfo;
import com.ysu.webapi.pojo.UploadAPI;

public interface UploadAPIService {

    //    根据用户id及是否审核通过查找该用户上传的所有的API
    public PageInfo<UploadAPI> selectUploadAPIByUserIdAndDecide(int userId,boolean decide,int pageNum, int pageSize);

    //    根据用户id及是否被审核查找该用户上传的所有的API
    public PageInfo<UploadAPI> selectUploadAPIByUserIdAndIstrue(int userId,int pageNum, int pageSize);

    //    根据根据是否被审核查找所有符合的API
    public PageInfo<UploadAPI> selectUploadAPIByIstrue(boolean istrue,int pageNum, int pageSize);

    //    根据根据是否被审核查找所有符合的API数目
    public int selectUploadAPIByIstrueToSum(boolean istrue);

    //上传API
    public boolean addUploadAPI(UploadAPI uploadAPI);


    //更新上传API的审核状态
    public boolean updateUploadAPI(int id);

    //    删除指定id的上传API
    public boolean deleteUploadAPIById(int id);


}
