package com.gear.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 后台页面管理Controller
 */
@Controller
public class PageController {


    /**
     * 展示首页
     * @return view视图
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
    public String showPage(@PathVariable String page){
        return page;
    }
}
