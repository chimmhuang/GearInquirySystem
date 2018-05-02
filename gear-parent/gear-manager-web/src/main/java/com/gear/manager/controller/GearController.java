package com.gear.manager.controller;

import com.gear.common.pojo.EasyUIDataGridResult;
import com.gear.common.pojo.GearResult;
import com.gear.manager.service.GearService;
import com.gear.pojo.TbGear;
import com.gear.pojo.TbGearCrafts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 齿轮管理Controller
 */
@Controller
public class GearController {

    @Autowired
    private GearService gearService;


    /**
     * 分页查询所有齿轮
     * @param page 当前页数
     * @param rows 一页显示数
     * @return EasyUIDataGridResult
     */
    @RequestMapping("/gear/list")
    @ResponseBody
    public EasyUIDataGridResult getGearList(Integer page,Integer rows){
        EasyUIDataGridResult gearList = gearService.getGearList(page, rows);
        return gearList;
    }


    /**
     * 通过ID查找齿轮
     * @param gearId 齿轮ID
     * @return TbGear
     */
    @RequestMapping("/gear/{gearId}")
    @ResponseBody
    public TbGear getGearById(Integer gearId){
        TbGear gear = gearService.getGearById(gearId);
        return gear;
    }


    /**
     * 通过ID查找齿轮描述
     * @param gearId 齿轮ID
     * @return GearResult
     */
    @RequestMapping("/gear/desc/{gearId}")
    @ResponseBody
    public GearResult getGearDescById(@PathVariable("gearId") Integer gearId){
        TbGearCrafts gearCrafts = gearService.getGearDescById(gearId);
        GearResult result = new GearResult(gearCrafts);
        return result;
    }


    /**
     * 添加齿轮
     * @param gear 齿轮对象
     * @param desc 描述
     * @return GearResult
     */
    @RequestMapping(value = "/gear/save",method = RequestMethod.POST)
    @ResponseBody
    public GearResult addGear(TbGear gear,String desc){
        GearResult result = gearService.addGear(gear, desc);
        return result;
    }


    /**
     * 更新齿轮
     * @param gear 齿轮对象
     * @param desc 齿轮描述
     * @return GearResult
     */
    @RequestMapping(value = "/gear/update",method = RequestMethod.POST)
    @ResponseBody
    public GearResult updateGear(TbGear gear,String desc){
        GearResult result = gearService.updateGear(gear, desc);
        return result;
    }


    /**
     * 删除齿轮
     * @param ids 选中的齿轮ID
     * @return GearResult
     */
    @RequestMapping(value = "/gear/delete",method = RequestMethod.POST)
    @ResponseBody
    public GearResult deleteGear(String ids){
        GearResult result = gearService.deleteGear(ids);
        return result;
    }


}
