package com.gear.manager.service;

import com.gear.common.pojo.EasyUITreeNode;

import java.util.List;

public interface GearCategoryService {

    List<EasyUITreeNode> getGearCatList(int parentId);
}
