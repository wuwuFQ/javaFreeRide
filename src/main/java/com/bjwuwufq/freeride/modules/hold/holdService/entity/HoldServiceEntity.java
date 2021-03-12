package com.bjwuwufq.freeride.modules.hold.holdService.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.bjwuwufq.freeride.commons.base.entity.Base;
import lombok.Data;

/**
 * Created by IntelliJ IDEA
 *
 * @author wuwuFQ
 * @program: freeride
 * @description: hold服务实体
 * @date 2021/3/10 09:44
 */
@Data
@TableName(value = "hold_tb_service")
public class HoldServiceEntity extends Base {

    private String name;

    private Double stars;

    private String phone;

    private String address;


}
