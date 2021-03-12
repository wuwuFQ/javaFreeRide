package com.bjwuwufq.freeride.modules.tripCar.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bjwuwufq.freeride.commons.base.service.BaseService;
import com.bjwuwufq.freeride.modules.tripCar.dao.TripCarDao;
import com.bjwuwufq.freeride.modules.tripCar.entity.TripCarEntity;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by IntelliJ IDEA
 *
 * @author wuwuFQ
 * @program: freeride
 * @description:
 * @date 2021/2/6 9:14 上午
 */
@Service
public class TripCarService extends BaseService<TripCarDao, TripCarEntity> {

    public IPage<TripCarEntity> queryByPage(int current, int size) {
        //封装查询参数
        QueryWrapper<TripCarEntity> wrapper = new QueryWrapper<>();
        //查询 最晚出发时间 大于等于 当前时间 的数据
        wrapper.ge("last_time", new Date());
        return baseMapper.selectPage(new Page<>(current, size), wrapper);
    }

    public IPage<TripCarEntity> queryMyCarListByPage(int userId, int current, int size) {
        //封装查询参数
        QueryWrapper<TripCarEntity> wrapper = new QueryWrapper<>();
        //查询 自己发布的
        wrapper.eq("user_id", userId);
        return baseMapper.selectPage(new Page<>(current, size), wrapper);
    }
}
