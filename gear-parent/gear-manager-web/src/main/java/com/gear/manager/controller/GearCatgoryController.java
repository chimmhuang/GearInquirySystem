package com.gear.manager.controller;

import com.gear.common.pojo.EasyUITreeNode;
import com.gear.manager.service.GearCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 齿轮分类Controller
 */
@Controller
public class GearCatgoryController {

    @Autowired
    private GearCategoryService gearCategoryService;


    /**
     * 通过父节点查询齿轮分类信息
     * @param parentId 父节点ID，默认为0
     * @return List<EasyUITreeNode>
     */
    @RequestMapping({"/gear/cat/list","/item/cat/list","/gear/category/list"})
    @ResponseBody
    public List<EasyUITreeNode> getGearCatByParentId(@RequestParam(value = "id",defaultValue = "0") int parentId){
        List<EasyUITreeNode> catList = gearCategoryService.getGearCatList(parentId);
        return catList;
    }
}
