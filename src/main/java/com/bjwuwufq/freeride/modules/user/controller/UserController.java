package com.bjwuwufq.freeride.modules.user.controller;

import com.bjwuwufq.freeride.commons.base.response.ResultMessage;
import com.bjwuwufq.freeride.modules.user.entity.UserEntity;
import com.bjwuwufq.freeride.modules.user.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by IntelliJ IDEA
 *58.87.110.207
 * @author wuwuFQ
 * @program: freeride
 * @description: 用户
 * @date 2021/2/5 11:17 上午
 */
@RestController
@RequestMapping("user")
@Api(tags = "用户接口")
public class UserController {

    @Autowired
    private UserService userService;



    @PostMapping("/loginUpdateData")
     /**
      * @Description: 登录并更新数据
      * @Param: [entity]
      * @return: com.bjwuwufq.freeride.commons.base.response.ResultMessage
      * @author wuwuFQ
      * @date 2021/2/6 9:51 下午
      */
    public ResultMessage loginUpdateData(@RequestBody UserEntity entity) {
        return ResultMessage.success(userService.loginUpdateData(entity));
    }

    @PostMapping("/getUserInfo")
     /**
      * @Description:  获取用户信息
      * @Param: [entity]
      * @return: com.bjwuwufq.freeride.commons.base.response.ResultMessage
      * @author wuwuFQ
      * @date 2021/2/6 9:51 下午
      */
    public ResultMessage getUserInfo(@RequestBody UserEntity entity) {
        return ResultMessage.success(userService.getById(entity.getId()));
    }

}
