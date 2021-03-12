package com.bjwuwufq.freeride.modules.user.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bjwuwufq.freeride.commons.base.service.BaseService;
import com.bjwuwufq.freeride.modules.user.dao.UserDao;
import com.bjwuwufq.freeride.modules.user.entity.UserEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by IntelliJ IDEA
 *
 * @author wuwuFQ
 * @program: freeride
 * @description: 用户逻辑层
 * @date 2021/2/5 9:35 上午
 */
@Service
public class UserService extends BaseService<UserDao, UserEntity> {
    public UserEntity getUserInfo(String openid) {
        QueryWrapper<UserEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("wechat_openid", openid);
        return baseMapper.selectOne(wrapper);
    }

    @Transactional(readOnly = false)
    public UserEntity loginUpdateData(UserEntity entity) {
        //如果存在就更新，不存在就插入数据
        String openid = entity.getWechatOpenid();
        UserEntity model = getUserInfo(openid);
        if (model == null) {
            entity.setUpdatedTime(new Date());
            entity.setCreatedTime(new Date());
            baseMapper.insert(entity);
        } else {
            entity.setUpdatedTime(new Date());
            entity.setId(model.getId());
            Integer result =baseMapper.updateById(entity);
            System.out.println(result);
        }
        return getUserInfo(openid);
    }


}
