package com.bjwuwufq.freeride.modules.tripPeople.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.bjwuwufq.freeride.commons.base.response.ResultCode;
import com.bjwuwufq.freeride.commons.base.response.ResultMessage;
import com.bjwuwufq.freeride.modules.tripCar.entity.TripCarEntity;
import com.bjwuwufq.freeride.modules.tripCar.service.TripCarService;
import com.bjwuwufq.freeride.modules.tripPeople.entity.TripPeopleEntity;
import com.bjwuwufq.freeride.modules.tripPeople.service.TripPeopleService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA
 *
 * @author wuwuFQ
 * @program: freeride
 * @description: 车找人
 * @date 2021/2/6 1:06 下午
 */
@RestController
@RequestMapping("release")
@Api(tags = "车找人接口")
public class TripPeopleController {

    @Autowired
    private TripPeopleService tripPeopleService;


    @GetMapping("/getReleaseTripPeople")
    public ResultMessage getReleaseTripPeople(@RequestParam int currentPage,
                                              @RequestParam(defaultValue = "10") int pageSize) {
        IPage<TripPeopleEntity> iPage = tripPeopleService.queryByPage(currentPage, pageSize);
        List<TripPeopleEntity> list = iPage.getRecords();
        long totalCount = iPage.getTotal();
        long size = iPage.getSize();
        long current = iPage.getCurrent();
        long totalPages = iPage.getPages();
        Map<String, Object> map = new HashMap<>();
        map.put("peopleList", list);
        map.put("totalCount", totalCount);
        map.put("pageSize", size);
        map.put("currentPage", current);
        map.put("totalPages", totalPages);

        return ResultMessage.success(map);
    }

    @GetMapping("/getMyTripList")
    public ResultMessage getMyTripList(@RequestParam int userId, @RequestParam int currentPage,
                                       @RequestParam(defaultValue = "10") int pageSize) {
        IPage<TripPeopleEntity> iPage = tripPeopleService.queryMyListByPage(userId, currentPage, pageSize);
        List<TripPeopleEntity> list = iPage.getRecords();
        long totalCount = iPage.getTotal();
        long size = iPage.getSize();
        long current = iPage.getCurrent();
        long totalPages = iPage.getPages();
        Map<String, Object> map = new HashMap<>();
        map.put("carList", list);
        map.put("totalCount", totalCount);
        map.put("pageSize", size);
        map.put("currentPage", current);
        map.put("totalPages", totalPages);

        return ResultMessage.success(map);
    }

    @PostMapping("/updateTripPeopleInfo")
    public ResultMessage updateTripPeopleInfo(@RequestBody TripPeopleEntity entity) {
        TripPeopleEntity model = tripPeopleService.getById(entity.getId());
        //先确定是发布人自己操作
        if (model.getUserId() == entity.getUserId()) {
            if (tripPeopleService.updateById(entity)) {
                return ResultMessage.success();
            } else {
                return ResultMessage.failure(ResultCode.DATA_IS_WRONG);
            }
        } else {
            return ResultMessage.failure(ResultCode.DATA_USERID_WRONG);
        }
    }
    @PostMapping("deletePeopleInfo")
    public ResultMessage deletePeopleInfo(@RequestBody TripPeopleEntity entity) {
        TripPeopleEntity model = tripPeopleService.getById(entity.getId());
        //先确定是发布人自己操作
        if (model.getUserId() == entity.getUserId()) {
            if (tripPeopleService.removeById(entity.getId())) {
                return ResultMessage.success();
            } else {
                return ResultMessage.failure(ResultCode.DATA_IS_WRONG);
            }
        } else {
            return ResultMessage.failure(ResultCode.DATA_USERID_WRONG);
        }
    }

     /*
      * @Description: 发布人员行程 
      * @Param: 
      * @return: 
      * @author wuwuFQ
      * @date 2021/3/1 11:54
      */
    @PostMapping("/saveTripPeopleInfo")
    public ResultMessage saveTripPeopleInfo(@RequestBody TripPeopleEntity entity) {
        if (entity.getUserId() == null) {
            return ResultMessage.failure(ResultCode.DATA_USERID_WRONG);
        }
        entity.setCreatedTime(new Date());
        if (tripPeopleService.save(entity)) {
            return ResultMessage.success();
        } else {
            return ResultMessage.failure(ResultCode.DATA_IS_WRONG);
        }
    }
}
