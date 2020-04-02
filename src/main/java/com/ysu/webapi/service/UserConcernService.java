package com.ysu.webapi.service;

import com.github.pagehelper.PageInfo;
import com.ysu.webapi.pojo.API;
import com.ysu.webapi.pojo.APIShow;
import com.ysu.webapi.pojo.UserConcern;

import java.util.List;

public interface UserConcernService {

//    //    根据指定的userConcern userId查找对应的userConcern
//    UserConcern selectUserConcernById(int userId);

    //    根据指定的userConcern userId查找对应的userConcern
    PageInfo<APIShow> selectUserConcernByUserId(int userId, int pageNum, int pageSize);
    //    根据指定的userConcern userId查找对应的userConcern不分页
    List<UserConcern> selectUserConcernByUserIdALL(int userId);
    //    查找所有userConcern
    PageInfo<UserConcern> selectUserConcernAll(int pageNum, int pageSize);



    //    添加userConcern
    int addUserConcern(UserConcern userConcern);


    //    删除指定id的userConcern
    boolean deleteUserConcernById(int id);


}
