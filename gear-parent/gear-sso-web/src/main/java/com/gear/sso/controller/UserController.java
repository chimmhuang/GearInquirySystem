package com.gear.sso.controller;

import com.gear.common.pojo.GearResult;
import com.gear.common.utils.CookieUtils;
import com.gear.sso.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @Value("${TOKEN_KEY}")
    private String TOKEN_KEY;

    /**
     * 用户登陆
     * @param username 用户名
     * @param password 密码
     * @param checkbox 是否记住用户
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/user/login")
    @ResponseBody
    public GearResult login(String username, String password, boolean checkbox,
                        HttpServletRequest request,
                        HttpServletResponse response){
        //调用登陆服务
        GearResult result = userService.login(username, password, checkbox);
        //判断是否需要向浏览器写cookie
//         if (result.getStatus() == 200 && checkbox){
//            //登陆成功，并且记住用户
//            //把token写入cookie中
//            String token = result.getData().toString();
//            CookieUtils.setCookie(request,response,TOKEN_KEY,token);
//        }
        if (result.getStatus() == 200){
            String token = result.getData().toString();
            CookieUtils.setCookie(request,response,TOKEN_KEY,token);
        }
        return result;
    }
}
