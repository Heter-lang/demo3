package com.controller;

import com.mapper.UserMapper;
import com.pojo.TimeDemo;
import com.pojo.User;
import com.services.ChatGptDemoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.util.List;

@RestController
public class demoTest {

    @Autowired
    UserMapper userMapper;

    @Autowired
    ChatGptDemoServices chatGptDemoServices;

    @RequestMapping(value = "hello")
    public String str() {
        return "hi";
    }

    @RequestMapping(value = "hi")
    public List<User> str2() {
        return userMapper.queryAll();
    }

    @RequestMapping(value = "love")
    public ModelAndView love() throws ParseException, InterruptedException {
        ModelAndView modelAndView = new ModelAndView("/hello");//设置对应JSP的模板文件
        modelAndView.addObject("name", chatGptDemoServices.Love());
        return modelAndView;
    }


}
