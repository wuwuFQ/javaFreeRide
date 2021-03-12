package com.bjwuwufq.freeride.commons.base.response;

/**
 * @program: islimp
 * @description: 统一封装公共JSON编码
 * @author: zhou hong gang
 * @create: 2020-12-09 11:51
 */
public enum ResultCode {
    /* 成功状态码 */
    SUCCESS(10000, "成功"),

    /* 参数错误：10001-19999 */
    PARAM_IS_INVALID(10001, "参数无效"),
    PARAM_IS_BLANK(10002, "参数为空"),
    PARAM_TYPE_BIND_ERROR(10003, "参数类型错误"),
    PARAM_NOT_COMPLETE(10004, "参数缺失"),

    /* 用户错误：20001-29999*/
    USER_NOT_LOGIN(20001, "用户未登录"),
    USER_LOGIN_ERROR(20002, "账号不存在或密码错误"),
    USER_ACCOUNT_FORBIDDEN(20003, "账号已被禁用"),
    USER_ACCOUNT_LOCKED(20004, "账号已被锁定"),
    USER_LOGIN_OTHER_ERROR(20005, "其他登陆失败"),
    USER_LOGIN_SUCCESS(20006, "登陆成功"),
    USER_LOGOUT_SUCCESS(20007, "退出成功"),
    USER_NOT_EXIST(20008, "用户不存在"),
    USER_HAS_EXISTED(20009, "用户已存在"),
    USER_PASS_ERROR(20010, "密码输入错误"),
    PERMISSION_DENIED(20011, "权限不足"),

    /* 业务错误：30001-39999 */
    SPECIFIED_QUESTIONED_USER_NOT_EXIST(30001, "某业务出现问题"),

    /* 系统错误：40001-49999 */
    SYSTEM_INNER_ERROR(40001, "系统繁忙，请稍后重试"),

    /* 数据错误：50001-599999 */
    RESULT_DATA_NONE(50001, "数据未找到"),
    DATA_IS_WRONG(50002, "数据有误"),
    DATA_ALREADY_EXISTED(50003, "数据已存在"),
    DATA_HAS_BEEN_DELETED(50004,"数据已被删除"),
    DATA_USERID_WRONG(50005, "用户ID错误"),


    /* 接口错误：60001-69999 */
    INTERFACE_INNER_INVOKE_ERROR(60001, "内部系统接口调用异常"),
    INTERFACE_OUTER_INVOKE_ERROR(60002, "外部系统接口调用异常"),
    INTERFACE_FORBID_VISIT(60003, "该接口禁止访问"),
    INTERFACE_ADDRESS_INVALID(60004, "接口地址无效"),
    INTERFACE_REQUEST_TIMEOUT(60005, "接口请求超时"),
    INTERFACE_EXCEED_LOAD(60006, "接口负载过高");

    //响应状态码
    private Integer code;
    //响应文本值
    private String message;

    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer code() {
        return this.code;
    }

    public String message() {
        return this.message;
    }

    public static String getMessage(String name) {
        for (ResultCode item : ResultCode.values()) {
            if (item.name().equals(name)) {
                return item.message;
            }
        }
        return name;
    }

    public static Integer getCode(String name) {
        for (ResultCode item : ResultCode.values()) {
            if (item.name().equals(name)) {
                return item.code;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return this.name();
    }

}
