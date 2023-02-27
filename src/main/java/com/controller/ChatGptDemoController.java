package com.controller;

import com.services.ChatGptDemoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatGptDemoController {

    @Autowired
    ChatGptDemoServices chatGptDemoServices;

    @PostMapping(value ="chatgptdemo")
    public String qu(@RequestBody String s){
        return chatGptDemoServices.qu(s);
    }


}
