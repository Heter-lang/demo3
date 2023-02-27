package com.services;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ChatGptDemoServicesImpl implements ChatGptDemoServices{
    @Override
    public String qu(String s) {
        Map<String,String> headers = new HashMap<String,String>();
        headers.put("Content-Type","application/json;charset=UTF-8");

        JSONObject json = new JSONObject();
        //选择模型
        json.set("model","text-davinci-003");
        //添加我们需要输入的内容
        json.set("prompt",s);
        json.set("temperature",0.9);
        json.set("max_tokens",2048);
        json.set("top_p",1);
        json.set("frequency_penalty",0.0);
        json.set("presence_penalty",0.6);

        HttpResponse response = HttpRequest.post("https://api.openai.com/v1/completions")
                .headerMap(headers, false)
                .bearerAuth("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")
                .body(String.valueOf(json))
                .timeout(5 * 60 * 1000)
                .execute();
        System.out.println(response.body());

        return response.body();
    }
}
