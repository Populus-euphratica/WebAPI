package com.ysu.webapi.service.impl;

import com.ysu.webapi.dao.UserDao;
import com.ysu.webapi.pojo.User;
import com.ysu.webapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    //    根据指定的user id查找对应的user
    @Override
    public User selectUserById(int id){
        return userDao.selectUserById(id);
    }


    //    根据指定的user name查找对应的user
    @Override
    public User selectUserByName(String name){
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
    public User selectUserByCompany(String company){
        return userDao.selectUserByCompany(company);
    }

    //    添加user
    @Override
    public boolean addUser(User user){
        boolean flag=false;
        try{
            userDao.addUser(user);
            flag=true;
        }catch (Exception e){
            System.out.println("添加user失败");
            e.printStackTrace();
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
}
