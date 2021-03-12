package com.bjwuwufq.freeride.modules.tripCar.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.bjwuwufq.freeride.commons.base.response.ResultCode;
import com.bjwuwufq.freeride.commons.base.response.ResultMessage;
import com.bjwuwufq.freeride.modules.tripCar.entity.TripCarEntity;
import com.bjwuwufq.freeride.modules.tripCar.service.TripCarService;
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
 * @description: 人找车
 * @date 2021/2/6 9:56 上午
 */
@RestController
@RequestMapping("release")
@Api(tags = "人找车接口")
public class TripCarController {

    @Autowired
    private TripCarService tripCarService;

    @GetMapping("/getReleaseTripCar")
     /**
      * @Description:  分页查询人找车的列表
      * @Param: [currentPage, pageSize]
      * @return: com.bjwuwufq.freeride.commons.base.response.ResultMessage
      * @author wuwuFQ
      * @date 2021/2/6 9:52 下午
      */
    public ResultMessage getReleaseTripCar(@RequestParam int currentPage, @RequestParam(defaultValue = "10") int pageSize) {
        IPage<TripCarEntity> iPage = tripCarService.queryByPage(currentPage, pageSize);
        List<TripCarEntity> list = iPage.getRecords();
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

    @GetMapping("/getMyTripCarList")
     /*
      * @Description:  获取我发布的 车辆信息
      * @Param: [userId, currentPage, pageSize]
      * @return: com.bjwuwufq.freeride.commons.base.response.ResultMessage
      * @author wuwuFQ
      * @date 2021/2/6 10:11 下午
      */
    public ResultMessage getMyTripCarList(@RequestParam int userId, @RequestParam int currentPage, @RequestParam(defaultValue = "10") int pageSize) {
        IPage<TripCarEntity> iPage = tripCarService.queryMyCarListByPage(userId, currentPage, pageSize);
        List<TripCarEntity> list = iPage.getRecords();
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

    @PostMapping("/updateTripCarInfo")
     /*
      * @Description: 发布人修改人找车的信息 
      * @Param: [entity]
      * @return: com.bjwuwufq.freeride.commons.base.response.ResultMessage
      * @author wuwuFQ
      * @date 2021/2/6 9:54 下午
      */
    public ResultMessage updateTripCarInfo(@RequestBody TripCarEntity entity) {
        TripCarEntity model = tripCarService.getById(entity.getId());
        //先确定是发布人自己操作
        if (model.getUserId() == entity.getUserId()) {
            if (tripCarService.updateById(entity)) {
                return ResultMessage.success();
            } else {
                return ResultMessage.failure(ResultCode.DATA_IS_WRONG);
            }
        } else {
            return ResultMessage.failure(ResultCode.DATA_USERID_WRONG);
        }
    }

    @PostMapping("deleteCarInfo")
    public ResultMessage deleteCarInfo(@RequestBody TripCarEntity entity) {
        TripCarEntity model = tripCarService.getById(entity.getId());
        //先确定是发布人自己操作
        if (model.getUserId() == entity.getUserId()) {
            if (tripCarService.removeById(entity.getId())) {
                return ResultMessage.success();
            } else {
                return ResultMessage.failure(ResultCode.DATA_IS_WRONG);
            }
        } else {
            return ResultMessage.failure(ResultCode.DATA_USERID_WRONG);
        }
    }

     /**
      * @Description:  发布车辆行程
      * @Param:
      * @return:
      * @author wuwuFQ
      * @date 2021/3/1 11:37
      */
    @PostMapping("saveTripCarInfo")
    public ResultMessage saveTripCarInfo(@RequestBody TripCarEntity entity) {
        if (entity.getUserId() == null) {
            return ResultMessage.failure(ResultCode.DATA_USERID_WRONG);
        }
        entity.setCreatedTime(new Date());
        if (tripCarService.save(entity)) {
            return ResultMessage.success();
        } else {
            return ResultMessage.failure(ResultCode.DATA_IS_WRONG);
        }
    }
}
