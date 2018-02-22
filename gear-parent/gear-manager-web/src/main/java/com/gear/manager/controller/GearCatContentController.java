package com.gear.manager.controller;

import com.gear.common.pojo.EasyUIDataGridResult;
import com.gear.common.pojo.GearResult;
import com.gear.manager.service.GearCatContentService;
import com.gear.pojo.TbGear;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 分类内容Controller
 */
@Controller
public class GearCatContentController {

    @Autowired
    private GearCatContentService contentService;


    /**
     * 查询该分类的齿轮列表
     * @param categoryId 分类ID
     * @param page 起始页
     * @param rows 一页显示数
     * @return
     */
    @RequestMapping("/gear/query/list")
    @ResponseBody
    public EasyUIDataGridResult getGearList(Integer categoryId,Integer page,Integer rows){
        EasyUIDataGridResult result = contentService.getGearList(categoryId, page, rows);
        return result;
    }


    /**
     * 添加该分类的齿轮信息
     * @param gear 齿轮对象
     * @param content 齿轮内容介绍
     * @return
     */
    @RequestMapping(value = "/content/save",method = RequestMethod.POST)
    @ResponseBody
    public GearResult addContent(TbGear gear,String content){
        GearResult result = contentService.addContent(gear, content);
        return result;
    }


    /**
     * 修改该分类下选择的齿轮信息
     * @param gear 齿轮对象
     * @param content 齿轮描述
     * @return
     */
    @RequestMapping(value = "/content/edit",method = RequestMethod.POST)
    @ResponseBody
    public GearResult editContent(TbGear gear,String content){
        GearResult result = contentService.editContent(gear, content);
        return result;
    }


}
