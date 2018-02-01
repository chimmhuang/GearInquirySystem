package com.gear.manager.service.impl;

import com.gear.common.pojo.EasyUITreeNode;
import com.gear.manager.service.GearCategoryService;
import com.gear.mapper.TbGearCatMapper;
import com.gear.pojo.TbGearCat;
import com.gear.pojo.TbGearCatExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 齿轮分类Service
 */
@Service
public class GearCatgoryServiceImpl implements GearCategoryService{


    @Autowired
    private TbGearCatMapper gearCatMapper;

    /**
     * 查询齿轮分类
     * @param parentId 父节点
     * @return List<EasyUITreeNode>
     */
    @Override
    public List<EasyUITreeNode> getGearCatList(int parentId) {
        //根据父节点ID查询子节点列表，设置查询条件
        TbGearCatExample example = new TbGearCatExample();
        TbGearCatExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(parentId);

        //执行查询
        List<TbGearCat> list = gearCatMapper.selectByExample(example);
        //转换成EasyUITreeNode列表
        List<EasyUITreeNode> resultList = new ArrayList<>();
        for (TbGearCat gearCat : list) {
            EasyUITreeNode easyUITreeNode = new EasyUITreeNode();
            easyUITreeNode.setId(gearCat.getCid().longValue());
            //如果节点下有子节点"closed"，如果没有子节点"open"
            easyUITreeNode.setState(gearCat.getIsParent()?"closed":"open");
            easyUITreeNode.setText(gearCat.getName());
            resultList.add(easyUITreeNode);
        }
        return resultList;
    }
}
