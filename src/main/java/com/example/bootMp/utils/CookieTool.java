package com.example.bootMp.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Usage:
 * @Author: gjq
 * @Date: 2019/10/6
 */
public class CookieTool {

    /**
     * 获取cookie
     *
     * @param request
     * @param key
     * @return
     */
    public static String getCookies(HttpServletRequest request, String key) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(key)) {
                    return cookie.getValue();
                }
            }
        }

        return null;
    }

    public static void setCookies(HttpServletResponse response, String key, String value) {
        Cookie myCookie=new Cookie(key,value);
        myCookie.setMaxAge(60*60*24);
        response.addCookie(myCookie);
    }
}
