package com.example.bootMp.api;

import com.example.bootMp.annotation.Auth;
import com.example.bootMp.common.component.TokenComponent;
import com.example.bootMp.common.enums.ErrorMessageEnum;
import com.example.bootMp.common.exception.ApiRuntimeException;
import com.example.bootMp.entity.User;
import com.example.bootMp.utils.CookieTool;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 和@Auth注解绑定
 */
@Aspect
@Component
public class AuthController {
    private final static Logger LOGGER = LoggerFactory.getLogger(AuthController.class);
    @Autowired
    private TokenComponent tokenComponent;

    @Pointcut(value = "@annotation(com.example.bootMp.annotation.Auth)")
    public void pointCut(){}

    @Around(value = "pointCut()")
    public Object before(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("======验证用户是否已经认证！！=======");
        LOGGER.info("执行Auth切面：" + proceedingJoinPoint.getSignature().getName());
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

        HttpServletRequest request = attributes.getRequest();
        Object[] args = proceedingJoinPoint.getArgs();
        if (BooleanUtils.isTrue(true)) {
            String token = CookieTool.getCookies(request, "token");
            User user = authUser(token);
            args[0] = user;
        }
        return proceedingJoinPoint.proceed(args);
    }

    @After(value = "pointCut() && @annotation(auth)")
    public void after(Auth auth){
        System.out.println("======用在定义的方法之后！！=======");
    }

    private User authUser(String token) {
        if (StringUtils.isBlank(token)) {
            throw new ApiRuntimeException(ErrorMessageEnum.TOKEN_ERROR);
        }

        // JWT Token 验证，获取用户信息
        Map user = tokenComponent.getClaimsFromToken(token);

        // 登录失效
        if (user == null) {
            throw new ApiRuntimeException(ErrorMessageEnum.TOKEN_ERROR);
        }

        User user1 = new User();
        user1.setUsername((String) user.get("username"));
        user1.setUserType((String) user.get("userType"));
        user1.setId((String) user.get("id"));
        return user1;
    }
}
