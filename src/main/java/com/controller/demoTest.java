package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class demoTest {
    @RequestMapping(value = "hello")
    public String str() {
        return "hi";
    }
}
