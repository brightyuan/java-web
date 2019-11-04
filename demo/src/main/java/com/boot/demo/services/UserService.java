package com.boot.demo.services;

import com.boot.demo.dao.UserDao;
import com.boot.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public User selectUserByName(String name){
        return userDao.findUserByName(name);
    }

    public User findUserById(int id){
        return userDao.findUserById(id);
    }
}


//https://segmentfault.com/a/1190000017211657#11-%E7%8E%AF%E5%A2%83%E5%8F%82%E6%95%B0