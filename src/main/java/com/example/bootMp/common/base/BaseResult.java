package com.example.bootMp.common.base;

import com.example.bootMp.common.enums.ErrorMessageEnum;

import java.util.Set;

/**
 * @Usage: 返回结果集封装
 * @Author: wwyz
 * @Date: 2019/3/21 4:33 PM
 */
public class BaseResult<T> {
    private static final long serialVersionUID = 1L;

    private static final String CODE = "0";
    private static final String ERROR = "500";

    private String code;

    private String msg;

    private Boolean success;

    private T data;

    private Integer count;

    public BaseResult() {

    }

    public BaseResult(String code, boolean success) {
        this.code = code;
        this.success = success;
    }

    public BaseResult(String code, String msg, boolean success) {
        this.code = code;
        this.msg = msg;
        this.success = success;
    }

    public BaseResult(String code, T data, boolean success) {
        this.code = code;
        this.data = data;
        this.success = success;
    }

    public BaseResult(String code, String msg, Boolean success, T data, Integer count) {
        this.code = code;
        this.msg = msg;
        this.success = success;
        this.data = data;
        this.count = count;
    }

    public BaseResult(String code, String msg, T data, boolean success) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.success = success;
    }

    public BaseResult(T data, boolean success) {
        this.data = data;
        this.success = success;
    }

    public static BaseResult error() {
        return error(ERROR, "未知异常，请联系管理员");
    }

    public static BaseResult error(String msg) {
        return error(ERROR, msg);
    }

    public static BaseResult error(ErrorMessageEnum errorMessageEnum) {
        return error(ERROR, errorMessageEnum.getMsg());
    }

    public static BaseResult error(ErrorMessageEnum errorMessageEnum, String msg) {
        return error(ERROR, errorMessageEnum.getMsg() + ":" + msg);
    }

    public static BaseResult error(String code, String msg) {
        return new BaseResult(code, msg, false);
    }

    public static BaseResult ok(String msg) {
        return new BaseResult(CODE, msg, true);
    }

    public static <T> BaseResult<T> ok(T result) {
        return new BaseResult<T>(CODE, result, true);
    }

    public static <T> BaseResult<T> ok(T result, Integer count) {
        return new BaseResult<>(CODE, "success", true, result, count);
    }

    public static <T> BaseResult<Set<T>> ok(Set<T> result) {
        return ok(result, result == null ? 0 : result.size());
    }

    public static <T> BaseResult<T> ok(String msg, T result) {
        return new BaseResult(CODE, msg, result, true);
    }

    public static BaseResult ok() {
        return new BaseResult(CODE, true);
    }

    public static <T> BaseResult<T> exception(String code, T data) {
        return new BaseResult<T>(code, "", data, false);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Integer getCount() {
        return count;
    }

    public BaseResult setCount(Integer count) {
        this.count = count;
        return this;
    }

    @Override
    public String toString() {
        return "BaseResult{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", success=" + success +
                ", result=" + data +
                '}';
    }
}
