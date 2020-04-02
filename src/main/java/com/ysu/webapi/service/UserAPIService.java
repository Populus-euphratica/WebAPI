package com.ysu.webapi.service;

import com.github.pagehelper.PageInfo;
import com.ysu.webapi.pojo.API;




public interface UserAPIService {

    public PageInfo<API> selectUserAPIByUserId(int userId, int pageNum, int pageSize);

}
