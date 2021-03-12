package com.bjwuwufq.freeride.modules.hold.holdUser.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.bjwuwufq.freeride.commons.base.entity.Base;
import lombok.Data;

/**
 * Created by IntelliJ IDEA
 *
 * @author wuwuFQ
 * @program: freeride
 * @description: hold用户实体
 * @date 2021/3/10 09:41
 */
@Data
@TableName(value = "hold_tb_user")
public class HoldUserEntity extends Base {

    private String openid;

    private String name;

    private String idcard;

    private String phone;

    private String provinces;

    private String city;

    private String areas;

    private String address;

    private String deviceNumber;


}
