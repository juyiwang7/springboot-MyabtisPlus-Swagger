package com.example.bootMp.api;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public interface LoginService {
    Map<String,Object> login(String username, String password, HttpServletResponse response);
}
