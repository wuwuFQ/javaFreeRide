package com.bjwuwufq.freeride.modules.tripCar.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.bjwuwufq.freeride.commons.base.entity.Base;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 发布-车招人(FrReleaseCar)实体类
 *
 * @author makejava
 * @since 2021-02-06 09:02:09
 */
@Data
@TableName(value = "fr_release_car")
@ApiModel(value = "发布的车辆信息模块")
public class TripCarEntity extends Base {
    /**
     * 发布人ID
     */
    private Integer userId;
    /**
     * 出发地-省
     */
    private String startProvince;
    /**
     * 出发地-市
     */
    private String startCity;
    /**
     * 出发地-区县
     */
    private String startArea;
    /**
     * 出发地-乡镇
     */
    private String startTown;
    /**
     * 目的地-省
     */
    private String endProvince;
    /**
     * 目的地-市
     */
    private String endCity;
    /**
     * 目的地-区县
     */
    private String endArea;
    /**
     * 目的地-乡镇
     */
    private String endTown;
    /**
     * 最早出发时间
     */
    private Date firstTime;
    /**
     * 最晚出发时间
     */
    private Date lastTime;
    /**
     * 招募几人
     */
    private Integer numPeople;
    /**
     * 车辆品牌
     */
    private String carBrand;
    /**
     * 车辆类型
     */
    private String carType;
    /**
     * 预估价格
     */
    private Double price;
    /**
     * 联系方式
     */
    private String phone;
    /**
     * 备注
     */
    private String remarks;

    @ApiModelProperty(value = "创建时间", hidden = true)
    private Date createdTime;
    @ApiModelProperty(value = "更新时间", hidden = true)
    private Date updatedTime;


}