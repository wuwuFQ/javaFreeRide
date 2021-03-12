package com.bjwuwufq.freeride.modules.user.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bjwuwufq.freeride.modules.user.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

/**
 * Created by IntelliJ IDEA
 *
 * @author wuwuFQ
 * @program: freeride
 * @description: 数据层接口
 * @date 2021/2/5 9:33 上午
 */

public interface UserDao extends BaseMapper<UserEntity> {
//    Map<String, Object> getUserInfo(int userid);
}
