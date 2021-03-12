package com.bjwuwufq.freeride.modules.user.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.bjwuwufq.freeride.commons.base.entity.Base;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by IntelliJ IDEA
 *
 * @author wuwuFQ
 * @program: freeride
 * @description: 用户实体类
 * @date 2021/2/5 9:01 上午
 */
@Data
@TableName(value = "fr_user")
@ApiModel(value = "用户模块")
public class UserEntity extends Base {
    /**
     * 微信openID
     */
    @NotNull(message = "微信openID不可为空")
    @ApiModelProperty(value = "微信openID", required = true, example = "sjjj6728ns777d8sb8ssh9s9")
    private String wechatOpenid;
    /**
      * 微信昵称
     */
    @ApiModelProperty(name = "微信昵称")
    private String wechatNickName;
    /**
     * 微信头像
     */
    @ApiModelProperty(name = "微信头像")
    private String wechatAvatarurl;
    /**
     * 微信性别 1男，2女
     */
    @ApiModelProperty(name = " 微信性别 1男，2女")
    private Integer wechatGender;
    /**
     * 微信国家
     */
    @ApiModelProperty(name = "微信国家")
    private String wechatCountry;
    /**
     * 微信城市-省
     */
    @ApiModelProperty(name = "微信城市-省")
    private String wechatProvince;
    /**
     * 微信城市-市
     */
    @ApiModelProperty(name = "微信城市-市")
    private String wechatCity;

    @ApiModelProperty(value = "创建时间", hidden = true)
    private Date createdTime;
    @ApiModelProperty(value = "更新时间", hidden = true)
    private Date updatedTime;

}
