package com.boot.demo.controller;

import com.boot.demo.entity.User;
import com.boot.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class MySQLController {

    @Autowired
    UserService userService;

    /**
     * http://localhost:8081//user/query?name=ssss
     * @param name
     * @return
     */
    @RequestMapping("/query")
    public User query(String name){
        return userService.selectUserByName(name);
    }

    /**
     * http://localhost:8081//user/queryById?id=111
     * @param id
     * @return
     */
    @RequestMapping("/queryById")
    public User queryById(int id){
        return userService.findUserById(id);
    }
}
