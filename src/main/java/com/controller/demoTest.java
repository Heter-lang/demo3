package com.controller;

import com.mapper.UserMapper;
import com.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class demoTest {

    @Autowired
    UserMapper userMapper;

    @RequestMapping(value = "hello")
    public String str() {
        return "hi";
    }

    @RequestMapping(value = "hi")
    public List<User> str2() {
        return userMapper.queryAll();
    }


}
