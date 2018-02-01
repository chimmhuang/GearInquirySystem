package com.gear.manager.service;

import com.gear.common.pojo.EasyUIDataGridResult;
import com.gear.common.pojo.GearResult;
import com.gear.pojo.TbGear;

/**
 * 齿轮服务接口
 */
public interface GearService {

    EasyUIDataGridResult getGearList(int startPage,int pageSize);
    TbGear getGearById(int gearId);
    GearResult getGearDescById(int gearId);
    GearResult addGear(TbGear gear,String desc);
    GearResult updateGear(TbGear gear,String desc);
    GearResult deleteGear(String ids);
}
