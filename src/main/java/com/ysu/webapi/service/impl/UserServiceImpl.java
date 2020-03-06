package com.ysu.webapi.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ysu.webapi.dao.UserDao;
import com.ysu.webapi.dao.UserInfoDao;
import com.ysu.webapi.pojo.User;
import com.ysu.webapi.pojo.UserInfo;
import com.ysu.webapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private UserInfoDao userInfoDao;


    //    根据指定的user id查找对应的user
    @Override
    public User selectUserById(int id){
        return userDao.selectUserById(id);
    }


    //    根据指定的user name查找对应的user
    @Override
    public PageInfo<User> selectUserByName(String name,int pageNum,int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<User> list=userDao.selectUserByName(name);
        PageInfo<User> page=new PageInfo(list,5);
        return page;
    }

    //    查找所有user
    @Override
    public PageInfo<User> selectUserAll(int pageNum,int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<User> list=userDao.selectUserAll();
        PageInfo<User> page=new PageInfo(list,5);
        return page;
    }


    //    根据邮箱查找对应的user
    @Override
    public User selectUserByEmail(String email){
        return userDao.selectUserByEmail(email);
    }


    //    根据company查找对应的user
    @Override
    public PageInfo<User> selectUserByCompany(String company,int pageNum,int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<User> list=userDao.selectUserByCompany(company);
        PageInfo<User> page=new PageInfo(list,5);
        return page;
    }

    //    模糊查找
    @Override
    public PageInfo<User> selectUserByAll(String val,int pageNum,int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<User> list=userDao.selectUserByAll(val);
        PageInfo<User> page=new PageInfo<User>(list,5);
        return page;
    }

    //    添加user
    @Override
    @Transactional
    public boolean addUser(User user){
        boolean flag=false;
        try{
            UserInfo userInfo=new UserInfo();
            userDao.addUser(user);
            userInfo.setUserid(userDao.selectUserByEmail(user.getEmail()).getId());
            flag=userInfoDao.addUserInfo(userInfo);
        }catch (Exception e){
            System.out.println("添加user失败");
            e.printStackTrace();
//            手动回滚事务
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return flag;
    }


    //    更新user信息
    @Override
    public boolean updateUser(User user){
        boolean flag=false;
        try {
            flag=userDao.updateUser(user);
        }catch (Exception e){
            System.out.println("更新user信息失败");
            e.printStackTrace();
        }
        return flag;
    }


    //    删除指定id的User   启用事务
    @Override
    @Transactional
    public boolean deleteUserById(int id){
        boolean flag=false;
        try {
            userDao.deleteUserById(id);
            flag=userInfoDao.deleteUserInfoByUserId(id);
        }catch (Exception e){
            System.out.println("删除user信息失败");
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
        }
        return flag;
    }
}
