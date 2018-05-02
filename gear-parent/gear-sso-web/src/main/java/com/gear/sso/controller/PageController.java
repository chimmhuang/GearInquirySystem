package com.gear.sso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 页面展示Controller
 */
@Controller
public class PageController {

    @RequestMapping("/")
    public String showLogin(){
        return "login";
    }

    @RequestMapping("/{page}")
    public String showPage(String page){
        return  page;
    }
}
