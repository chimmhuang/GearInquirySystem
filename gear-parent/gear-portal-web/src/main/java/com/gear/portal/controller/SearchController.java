package com.gear.portal.controller;

import com.gear.manager.service.SearchGearService;
import com.gear.pojo.SearchResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.UnsupportedEncodingException;

/**
 * 齿轮搜索Controller
 */
@Controller
public class SearchController {

    @Autowired
    private SearchGearService searchGearService;
    @Value("${SEARCH_RESULT_ROWS}")
    private Integer SEARCH_RESULT_ROWS;

    /**
     * 搜索齿轮信息
     * @param model
     * @param title
     * @param page
     * @return
     * @throws UnsupportedEncodingException
     */
    @RequestMapping("/gear/search")
    public String searchGear(Model model, String title,
                             @RequestParam(value = "page",defaultValue = "1")Integer page) throws UnsupportedEncodingException {

        //需要对请求参数进行转码处理
//        title = new String(title.getBytes("iso-8859-1"),"utf-8");

        SearchResult result = searchGearService.searchGearByName(title,page,SEARCH_RESULT_ROWS);

        model.addAttribute("gearList",result.getGearList());
        model.addAttribute("query",title);
        model.addAttribute("totalPages",result.getRecordCount());
        model.addAttribute("page",page);
        return "search";
    }
    @RequestMapping("/search/gear/search")
    public String search(Model model, String title,
                             @RequestParam(value = "page",defaultValue = "1")Integer page) throws UnsupportedEncodingException {

        //需要对请求参数进行转码处理
        title = new String(title.getBytes("iso-8859-1"),"utf-8");

        SearchResult result = searchGearService.searchGearByName(title,page,SEARCH_RESULT_ROWS);

        model.addAttribute("gearList",result.getGearList());
        model.addAttribute("query",title);
        model.addAttribute("totalpage",result.getRecordCount());
        model.addAttribute("page",page);
        return "search";
    }
}
