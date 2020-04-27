package com.example.bootMp.common.exception;
import com.example.bootMp.common.base.BaseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Usage: 异常拦截，统一日志记录
 * @Author: gjq
 * @Date: 2019/3/25 3:26 PM
 */
@ControllerAdvice
public class RestExceptionHandler {

    private final Logger log = LoggerFactory.getLogger(RestExceptionHandler.class);

    /**
     * 认证异常拦截
     *
     * @param e
     * @return
     */
    @ExceptionHandler(ApiRuntimeException.class)
    @ResponseBody
    public ResponseEntity handler(Throwable e) {
        ApiRuntimeException exception = (ApiRuntimeException) e;
        log.debug("RuntimeException:{}", exception);
        log.info("RuntimeException:{}", exception.getErrorMessage());
        HttpStatus status = HttpStatus.resolve(exception.getErrorCode());
        return new ResponseEntity<>(BaseResult.exception(exception.getErrorCode()+"", exception.getErrorMessage()),
                status == null ? HttpStatus.INTERNAL_SERVER_ERROR : status);
    }
}
