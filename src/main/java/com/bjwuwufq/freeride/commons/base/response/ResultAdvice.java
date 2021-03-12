package com.bjwuwufq.freeride.commons.base.response;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: islimp
 * @description: 统一封装接口返回数据
 * @author: zhou hong gang
 * @create: 2020-12-09 11:51
 */
@RestControllerAdvice(basePackages = "com.bjwuwufq.freeride.modules")
public class ResultAdvice implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType,
                                  Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        System.out.println("TestResponseBodyAdvice==>beforeBodyWrite:" + o.toString() + ","
                + serverHttpRequest.toString() + methodParameter + serverHttpResponse + mediaType);
        return o;
    }

    @ExceptionHandler(value = Exception.class)
    public Object exception(Exception exception) {
        if (exception instanceof HttpMessageNotReadableException)
            //封装具体参数
            return ResultMessage.failure(ResultCode.PARAM_TYPE_BIND_ERROR);
        else
            return ResultMessage.failure(ResultCode.INTERFACE_INNER_INVOKE_ERROR);
    }

    /**
     * 对于校验封装
     * @param exception
     * @return
     */
    public Map<String, Object> methodArgumentNotValidException(MethodArgumentNotValidException exception) {
        BindingResult bindingResult = exception.getBindingResult();
        Map<String, Object> result = new HashMap<>();
        //获取验证错误的总数量
        result.put("error_count", bindingResult.getErrorCount());
        //获取每个验证失败的属性
        List<FieldError> errors = exception.getFieldErrors();
        errors.stream().forEach(error->result.put(error.getField(), error.getDefaultMessage()));
        return result;
    }

}
