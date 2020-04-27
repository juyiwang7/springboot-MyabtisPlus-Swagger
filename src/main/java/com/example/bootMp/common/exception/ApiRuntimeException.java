package com.example.bootMp.common.exception;


import com.example.bootMp.common.enums.ErrorMessageEnum;

public class ApiRuntimeException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private Integer errorCode;
    private String errorName;
    private String errorMessage;

    public ApiRuntimeException() {
    }

    public ApiRuntimeException(String message) {
        super(message);
    }

    public ApiRuntimeException(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public ApiRuntimeException(Throwable cause) {
        super(cause);
    }

    public ApiRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public ApiRuntimeException(ErrorMessageEnum error) {
        super(error.getMsg());
        this.errorCode = error.getCode();
        this.errorName = error.name();
        this.errorMessage = error.getMsg();
    }

    /**
     * 枚举异常+异常信息
     *
     * @param error
     * @param msg
     */
    public ApiRuntimeException(ErrorMessageEnum error, String msg) {
        super(error.getMsg() + ":" + msg);
        this.errorCode = error.getCode();
        this.errorName = error.name();
        this.errorMessage = error.getMsg() + ":" + msg;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public String getErrorName() {
        return errorName;
    }

    public void setErrorName(String errorName) {
        this.errorName = errorName;
    }
}
