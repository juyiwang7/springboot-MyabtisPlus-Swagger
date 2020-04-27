package com.example.bootMp.common.enums;

/**
 * @Usage: 错误代码枚举
 * @Author: gjq
 * @Date: 2019/3/25 3:26 PM
 */
public enum ErrorMessageEnum {
    USER_NOT_LOGIN(401, "User not login or timeout", "用户未登录或登录超时"),
    TOKEN_ERROR(401, "Token invalid", "Token不合法或已失效"),
    ERROR(500, "Error", "程序异常"),
    EXIST(500, "Existed", "已存在"),
    NOT_EXIST(500, "Not existed", "不存在"),
    NOT_NULL(500, "Not null", "不为空"),
    NETWORK_ERROR(500, "Network Error", "网络错误"),
    AUTH_FAIL(500, "Auth fail, please check username and password.", "认证未通过, 请检查用户名或密码是否正确"),
    USER_NOT_EXIST(500, "User not exist.", "用户名不存在"),
    USER_PAUSED(500, "User was paused", "该用户暂时停止使用，请联系管理员"),
    PROJECT_NOT_EXIST(500, "Project not exist, please create the project first", "项目不存在，首先创建该项目"),
    ERROR_TYPE_NOT_EXIST(500, "ErrorType not exist, please create the ErrorType first", "错误类型不存在，首先创建该错误类型"),
    ERROR_CODE_ALREADY_EXIST(500, "ErrorCode already exist, please create the check the errorCode", "错误码已经存在，请检查错误码"),
    ERROR_CODE_SAVE_FAIL(500, "ErrorCode save fail, please try it later", "保存错误码失败，请稍后再试"),
    ERROR_CODE_UPDATE_FAIL(500, "ErrorCode update fail, please try it later", "更新错误码失败，请稍后再试"),
    ERROR_CODE_INSERT_ES_FAIL(500, "ErrorCode insert ES fail, please try it later", "错误码插入ES失败，请稍后再试"),
    ;

    private final int code;
    private final String zhMsg;
    private final String enMsg;

    ErrorMessageEnum(int code, String enMsg, String zhMsg) {
        this.code = code;
        this.zhMsg = zhMsg;
        this.enMsg = enMsg;
    }

    public int getCode() {
        return code;
    }

    /**
     * 获取当下语言的返回信息
     *
     * @return
     */
    public String getMsg() {
        return zhMsg;
    }

    public String getZhMsg() {
        return zhMsg;
    }

    public String getEnMsg() {
        return enMsg;
    }

    public String getEnumCode(String enumInfo){
        for(ErrorMessageEnum errorMessageEnum : values()){
            if(errorMessageEnum.toString().equals(enumInfo)){
                return String.valueOf(errorMessageEnum.getCode());
            }
        }
        return null;
    }
}
