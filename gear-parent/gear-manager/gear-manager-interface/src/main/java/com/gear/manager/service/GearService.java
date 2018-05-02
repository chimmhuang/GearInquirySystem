package com.gear.manager.service;

import com.gear.common.pojo.EasyUIDataGridResult;
import com.gear.common.pojo.GearResult;
import com.gear.pojo.TbGear;
import com.gear.pojo.TbGearCrafts;

/**
 * 齿轮服务接口
 */
public interface GearService {

    EasyUIDataGridResult getGearList(int startPage,int pageSize);
    TbGear getGearById(int gearId);
    TbGearCrafts getGearDescById(int gearId);
    GearResult addGear(TbGear gear,String desc);
    GearResult updateGear(TbGear gear,String desc);
    GearResult deleteGear(String ids);
}
