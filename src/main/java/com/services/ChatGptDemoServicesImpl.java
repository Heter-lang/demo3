package com.services;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONObject;
import com.pojo.TimeDemo;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    @Override
    public TimeDemo Love() throws InterruptedException, ParseException {
        String ln = "\r\n";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        Date date = new Date(System.currentTimeMillis()); // this object contains the current date value
        //System.out.println(date);
        //System.out.println(System.currentTimeMillis());
        System.out.println("现在的时间是" + formatter.format(date));

        long c = System.currentTimeMillis() - dateToStamp("2023-2-24 11:14:00");
        long s = c / 1000;
        long m = s / 60;
        long h = m / 60;
        long d = h / 24;
        TimeDemo timeDemo=new TimeDemo(d,s,m,h);
        //System.out.println("我们已经认识了: "+s+"秒， "+m+"分钟，"+h+"小时，"+d+"天");
       // String s1="如果以天为单位，我们已经认识了：" + d + "天"+ln+"以小时为单位，我们已经认识了：" + h + "小时"+ln+"以分钟为单位，我们已经认识了：" + m + "分钟"+ln+"以秒为单位则，我们已经认识了：" + s + "秒";

        return timeDemo;
    }

    /**
     * 时间变为时间戳
     * @param s
     * @return
     * @throws ParseException
     */
    public static long dateToStamp(String s) throws ParseException {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = simpleDateFormat.parse(s);
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }
        long ts = date.getTime();
        return ts;
    }
}
