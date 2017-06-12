package com.hr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2017/6/12 0012.
 */
@Controller
@RequestMapping("/cookie")
public class CookieController {


    @RequestMapping("test")
    public void test(HttpServletRequest request, HttpServletResponse response) {

        // 通过此方法来获得 cookie
        Cookie[] cookies = request.getCookies();

        //第一次请求不会有 cookie，当 addCookie 返回的时候，第二次请求就会有了
        if (null != cookies){
            for (Cookie cookie : cookies){
                System.out.println(cookie.getName());
                System.out.println(cookie.getValue());
            }
        }

        Cookie cookie = new Cookie("testCookie2","testCookieValue");
        cookie.setMaxAge(Integer.MAX_VALUE);
        cookie.setPath("/");//表示根目录下都可以访问该cookie

        //如果这样设置，那么该cookie只会在 https,ssl 等加密传输协议中传输，但是本身不会把cookie加密
        //在http 请求中，该cookie 将不会被传输
        //cookie.setSecure(true);


        //用这个方法来添加 cookie
        response.addCookie(cookie);

        try {
            response.getWriter().write("1111");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
