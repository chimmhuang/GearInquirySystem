package com.gear.manager.controller;

import com.gear.common.pojo.EasyUITreeNode;
import com.gear.common.pojo.GearResult;
import com.gear.manager.service.GearCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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


    /**
     * 添加齿轮分类
     * @param parentId 父节点，默认为0
     * @param name 分类名称
     * @return GearResult
     */
    @RequestMapping(value = "/gear/category/create",method = RequestMethod.POST)
    @ResponseBody
    public GearResult addGearCategory(@RequestParam(value = "parentId",defaultValue = "0") int parentId,String name){
        GearResult result = gearCategoryService.addGearCatgory(parentId, name);
        return result;
    }


    /**
     * 重命名齿轮分类名称
     * @param cid 分类ID
     * @param name 新的分类名称
     * @return
     */
    @RequestMapping("/gear/category/update")
    @ResponseBody
    public GearResult renameGearCategory(@RequestParam("id") int cid,String name){
        GearResult result = gearCategoryService.renameGearCatgory(cid, name);
        return result;
    }


    /**
     * 删除齿轮分类
     * @param cid 分类ID
     * @return
     */
    @RequestMapping("/gear/category/delete")
    @ResponseBody
    public GearResult deleteGearCatgory(@RequestParam("id") int cid){
        GearResult result = gearCategoryService.deleteGearCatgory(cid);
        return result;
    }



}
