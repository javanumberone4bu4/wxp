package com.rimi.item.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * cookie工具类
 *
 * @author Wang Xiaoping
 * @date 2019/9/23 12:27
 */
public final class CookieUtils {
    private CookieUtils(){}
    public static String getCookies(HttpServletRequest request,String name){
        Cookie[] cookies = request.getCookies();
        if (cookies!=null) {
            for (Cookie cookie : cookies) {
                String name1 = cookie.getName();
                if (name1.equals(name)) {
                    return cookie.getValue();
                }
            }
        }
        return "";
    }
    public static void cookie(String name, String value,int time, HttpServletResponse response){
        Cookie cookie=new Cookie(name,value);
        cookie.setMaxAge(time);
        response.addCookie(cookie);

    }
    public static void cookie(String name,String value,int time,String path,HttpServletResponse response){
        Cookie cookie=new Cookie(name,value);
        cookie.setMaxAge(time);
        cookie.setPath(path);
        response.addCookie(cookie);
    }
    public static void cookie(String name,String value,HttpServletResponse response){
        cookie(name,value,-1,response);

    }
}
