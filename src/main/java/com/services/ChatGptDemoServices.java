package com.services;

import com.pojo.TimeDemo;

import java.text.ParseException;

public interface ChatGptDemoServices {

    public String qu(String s);
    public TimeDemo Love() throws InterruptedException, ParseException;

}
