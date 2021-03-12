package com.bjwuwufq.freeride.modules.hold.holdUser.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bjwuwufq.freeride.commons.base.response.ResultMessage;
import com.bjwuwufq.freeride.modules.hold.holdUser.entity.HoldUserEntity;
import com.bjwuwufq.freeride.modules.hold.holdUser.service.HoldUserService;
import com.bjwuwufq.freeride.modules.user.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

/**
 * Created by IntelliJ IDEA
 *
 * @author wuwuFQ
 * @program: freeride
 * @description: hold小程序用户类
 * @date 2021/3/10 09:40
 */
@RestController
@RequestMapping("hold/user")
public class HoldUserController {
    @Autowired
    private HoldUserService holdUserService;

     /**
      * @Description:  查询用户信息
      * @Param:
      * @return:
      * @author wuwuFQ
      * @date 2021/3/10 10:01
      */
     @GetMapping("/getUserInfo")
    public ResultMessage getUserInfo(@RequestParam String openid) {
        QueryWrapper<HoldUserEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("openid", openid);
        HoldUserEntity entity = holdUserService.getOne(wrapper);
        return ResultMessage.success(entity);
    }

     /*
      * @Description: 更新用户信息，先根据openID查询是否存在，然后保存或更新 
      * @Param: 
      * @return: 
      * @author wuwuFQ
      * @date 2021/3/10 10:44
      */
    @PostMapping("/updateUserInfo")
    public ResultMessage updateUserInfo(@RequestBody HoldUserEntity entity) {
        QueryWrapper<HoldUserEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("openid", entity.getOpenid());
        HoldUserEntity e = holdUserService.getOne(wrapper);
        if (e == null) {
           if (holdUserService.save(entity)) {
               System.out.println("保存成功");
           } else {
               System.out.println("保存失败");
           }
        } else {
            if (holdUserService.updateById(entity)) {
                System.out.println("修改成功");
            } else {
                System.out.println("修改成功");
            }

        }
        return ResultMessage.success(holdUserService.getOne(wrapper));
    }
}
