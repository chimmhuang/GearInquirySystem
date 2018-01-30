package com.gear.manager.controller;

import com.gear.common.pojo.EasyUIDataGridResult;
import com.gear.common.pojo.GearResult;
import com.gear.manager.service.GearService;
import com.gear.pojo.TbGear;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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
        GearResult result = gearService.getGearDescById(gearId);
        return result;
    }

}