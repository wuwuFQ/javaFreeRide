package com.bjwuwufq.freeride.modules.weChat.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.kevinsawicki.http.HttpRequest;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA
 *
 * @author wuwuFQ
 * @program: freeride
 * @description:
 * @date 2021/2/24 9:23 上午
 */
@Service
public class WeChatService {
//   secret： 8c429bbdbf7320ca1922eb84e30499cd
    public JSONObject getWeChatOpenID(String code) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("appid", "wx9ad57a5bff1c8e04");
        map.put("secret", "8c429bbdbf7320ca1922eb84e30499cd");
        map.put("js_code", code);
        map.put("grant_type", "authorization_code");

        String response = HttpRequest.get("https://api.weixin.qq.com/sns/jscode2session").form(map).body();
        //将json字符串转换为json对
        JSONObject json = JSON.parseObject(response);

        return json;
    }
//    secret：12660262862362ef79602404e5845752
    public JSONObject getHoldWeChatOpenID(String code) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("appid", "wx65c532ea78e62b5e");
        map.put("secret", "12660262862362ef79602404e5845752");
        map.put("js_code", code);
        map.put("grant_type", "authorization_code");

        String response = HttpRequest.get("https://api.weixin.qq.com/sns/jscode2session").form(map).body();
        //将json字符串转换为json对
        JSONObject json = JSON.parseObject(response);

        return json;
    }

}
