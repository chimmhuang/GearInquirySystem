package com.gear.manager.service;

import com.gear.common.pojo.EasyUIDataGridResult;
import com.gear.common.pojo.GearResult;
import com.gear.pojo.TbGear;

public interface GearCatContentService {

    EasyUIDataGridResult getGearList(Integer categoryId,Integer startPage,Integer pageSize);
    GearResult addContent(TbGear gear,String content);
    GearResult editContent(TbGear gear,String content);
}
