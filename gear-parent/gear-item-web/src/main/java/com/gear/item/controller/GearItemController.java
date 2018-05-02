package com.gear.item.controller;

import com.gear.common.pojo.GearResult;
import com.gear.item.pojo.GearItem;
import com.gear.manager.service.GearService;
import com.gear.pojo.TbGear;
import com.gear.pojo.TbGearCrafts;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 展示齿轮详情页面
 */
@Controller
public class GearItemController {

    @Autowired
    private GearService gearService;

    /**
     * 根据ID查询单个齿轮信息详情
     * @param gearId
     * @param model
     * @return
     */
    @RequestMapping({"/gear/item/{gearId}","/item/desc/"})
    public String showGearItem(@PathVariable("gearId") String gearId, Model model){
        TbGear gear = null;
        TbGearCrafts gearCrafts = null;
        if (StringUtils.isNotEmpty(gearId)){
            gear = gearService.getGearById(Integer.parseInt(gearId));
            gearCrafts = gearService.getGearDescById(Integer.parseInt(gearId));
        }

        GearItem gearItem = new GearItem(gear);

        model.addAttribute("item",gearItem);
        model.addAttribute("itemDesc",gearCrafts);
        return "item";
    }
}
