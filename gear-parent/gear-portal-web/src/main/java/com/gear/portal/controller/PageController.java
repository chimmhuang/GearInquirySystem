package com.gear.portal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    /**
     * 展示首页
     * @return
     */
    @RequestMapping("/")
    public String showIndex(){
        return "index";
    }

    /**
     * 展示指定页面
     * @param page
     * @return
     */
    @RequestMapping("/{page}")
    public String showPage(@PathVariable("page") String page){
        return page;
    }
}
