package com.bjwuwufq.freeride.modules.weChat.controller;

import com.alibaba.fastjson.JSONObject;
import com.bjwuwufq.freeride.commons.base.response.ResultCode;
import com.bjwuwufq.freeride.commons.base.response.ResultMessage;
import com.bjwuwufq.freeride.modules.weChat.service.WeChatService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA
 *
 * @author wuwuFQ
 * @program: freeride
 * @description: 微信openID
 * @date 2021/2/24 9:22 上午
 */
@RestController
@RequestMapping("wechat")
@Api(tags = "微信相关接口")
public class WeChatController {

    @Autowired
    WeChatService weChatService;

//    freeride小程序
    @GetMapping("/getOpenID")
    public ResultMessage getWeChatOpenID(String code) {
        JSONObject json =  weChatService.getWeChatOpenID(code);
        String openid = json.getString("openid");
        if (openid != null) {
            Map<String, String> map = new HashMap<String, String>();
            map.put("openid", openid);
            return ResultMessage.success(map);
        } else {
            /*
            -1	系统繁忙，此时请开发者稍候再试
            0	请求成功
            40029	code 无效
            45011	频率限制，每个用户每分钟100次
             */
            return ResultMessage.failure(ResultCode.INTERFACE_OUTER_INVOKE_ERROR);
        }
    }

//只适用于 HOLD小程序
    @GetMapping("/getHoldOpenID")
    public ResultMessage getHoldWeChatOpenID(String code) {
        JSONObject json =  weChatService.getHoldWeChatOpenID(code);
        String openid = json.getString("openid");
        if (openid != null) {
            Map<String, String> map = new HashMap<String, String>();
            map.put("openid", openid);
            return ResultMessage.success(map);
        } else {
            /*
            -1	系统繁忙，此时请开发者稍候再试
            0	请求成功
            40029	code 无效
            45011	频率限制，每个用户每分钟100次
             */
            return ResultMessage.failure(ResultCode.INTERFACE_OUTER_INVOKE_ERROR);
        }
    }

}
