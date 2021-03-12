package com.bjwuwufq.freeride.modules.hold.holdService.controller;

import com.bjwuwufq.freeride.commons.base.response.ResultMessage;
import com.bjwuwufq.freeride.modules.hold.holdService.entity.HoldServiceEntity;
import com.bjwuwufq.freeride.modules.hold.holdService.service.HoldServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by IntelliJ IDEA
 *
 * @author wuwuFQ
 * @program: freeride
 * @description: hold服务类
 * @date 2021/3/10 09:45
 */
@RequestMapping("hold/service")
@RestController
public class HoldServiceController {
    @Autowired
    private HoldServiceService holdServiceService;

    @GetMapping("peopleList")
    public ResultMessage getPeopleList() {
        return ResultMessage.success(holdServiceService.list());
    }
}
