package com.ysu.webapi.service.impl;

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
    public List<User> selectUserByName(String name){
        return userDao.selectUserByName(name);
    }

    //    查找所有user
    @Override
    public List<User> selectUserAll(){
        return userDao.selectUserAll();
    }


    //    根据邮箱查找对应的user
    @Override
    public User selectUserByEmail(String email){
        return userDao.selectUserByEmail(email);
    }


    //    根据company查找对应的user
    @Override
    public List<User> selectUserByCompany(String company){
        return userDao.selectUserByCompany(company);
    }

    //    添加user
    @Override
    @Transactional
    public boolean addUser(User user){
        boolean flag=false;
        try{
            UserInfo userInfo=new UserInfo();
            userInfo.setUserid(user.getId());
            userDao.addUser(user);
            userInfoDao.addUserInfo(userInfo);
            flag=true;
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
            userDao.updateUser(user);
            flag=true;
        }catch (Exception e){
            System.out.println("更新user信息失败");
            e.printStackTrace();
        }
        return flag;
    }


    //    删除指定id的User   启用事务
    @Override
    @Transactional
    public boolean deleteUserById(String id){
        boolean flag=false;
        try {
            userDao.deleteUserById(id);
            userInfoDao.deleteUserInfoById(id);
            flag=true;
        }catch (Exception e){
            System.out.println("删除user信息失败");
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
        }
        return flag;
    }
}
