package com.hr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;

/**
 * Created by Administrator on 2017/6/12 0012.
 */
@Controller
@RequestMapping("session")
public class SessionController {

    @RequestMapping("test")
    public void test(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        // 第一次 true ， 第二次false（重启或超时后失效）
        System.out.println(session.isNew());

        session.setAttribute("test","value");

        // session 存在服务端的内存中
        // cookie 存在客户端本地，由浏览器进行维护
    }
}
