package com.example.bootMp.api;

import com.example.bootMp.common.component.TokenComponent;
import com.example.bootMp.common.enums.ErrorMessageEnum;
import com.example.bootMp.common.exception.ApiRuntimeException;
import com.example.bootMp.entity.User;
import com.example.bootMp.service.IUserService;
import com.example.bootMp.utils.PasswordHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private IUserService userService;
    @Autowired
    private TokenComponent tokenComponent;

    @Override
    public Map<String, Object> login(String username, String password, HttpServletResponse response) {
        User user = userService.getAvailableUserByName(username, true);
        if (user == null){
            throw new ApiRuntimeException(ErrorMessageEnum.USER_NOT_EXIST);
        }
        password = PasswordHandler.convertToMD5(password);
        if (!user.getPassword().equals(password)) {
            throw new ApiRuntimeException(ErrorMessageEnum.AUTH_FAIL);
        }
        // 颁发Token
        String token = generateUserToken(user);
        Map<String,Object> resultMap = new HashMap<>(2);
        resultMap.put("token", token);
        resultMap.put("username", username);
        resultMap.put("usertype", user.getUserType());
        return resultMap;
    }

    /**
     * 签发Token，UserDomain转化为CurrentUser
     *
     * @param user
     * @return
     */
    public String generateUserToken(User user) {
        if (user == null) {
            throw new ApiRuntimeException(ErrorMessageEnum.ERROR, "generateUserToken user == null");
        }
        Map<String,Object> userMap = new HashMap<>(3);
        userMap.put("id", user.getId());
        userMap.put("username", user.getUsername());
        userMap.put("userType", user.getUserType());
        String token = tokenComponent.generateToken(user.getId(), userMap);
        return token;
    }
}
