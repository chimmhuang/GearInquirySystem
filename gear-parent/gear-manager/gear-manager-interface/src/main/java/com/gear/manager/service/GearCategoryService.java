package com.gear.manager.service;

import com.gear.common.pojo.EasyUITreeNode;
import com.gear.common.pojo.GearResult;
import com.gear.pojo.TbGearCat;

import java.util.List;

public interface GearCategoryService {

    List<EasyUITreeNode> getGearCatList(int parentId);
    GearResult addGearCatgory(int parentId, String name);
    GearResult renameGearCatgory(int cid,String name);
    GearResult deleteGearCatgory(int cid);
}
