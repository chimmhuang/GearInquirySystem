package com.gear.manager.service.impl;

import com.gear.common.pojo.EasyUITreeNode;
import com.gear.common.pojo.GearResult;
import com.gear.manager.service.GearCategoryService;
import com.gear.mapper.TbGearCatMapper;
import com.gear.pojo.TbGearCat;
import com.gear.pojo.TbGearCatExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
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

    /**
     * 添加齿轮分类
     * @param parentId 父节点
     * @param name 分类名称
     * @return TbGearCat
     */
    @Override
    public GearResult addGearCatgory(int parentId, String name) {
        //创建一个pojo对象
        TbGearCat gearCategory = new TbGearCat();
        //补全对象属性
        gearCategory.setParentId(parentId);
        gearCategory.setName(name);
        gearCategory.setIsParent(false);
        gearCategory.setCreated(new Date());
        gearCategory.setUpdated(new Date());

        //添加内容列表
        gearCatMapper.insert(gearCategory);//插入完成后，gearCategory的新id被写入(需要修改mapper)
        //判断父节点的isParent是否为true
        TbGearCat parent = gearCatMapper.selectByPrimaryKey(gearCategory.getParentId());
        if (!parent.getIsParent()){
            //如果父节点为叶子节点应该改为父节点
            parent.setIsParent(true);
            //更新父节点
            gearCatMapper.updateByPrimaryKey(parent);
        }

        return GearResult.ok(gearCategory);
    }

    /**
     * 重命名齿轮分类名称
     * @param cid 分类名称ID
     * @param name 新的名称
     * @return GearResult
     */
    @Override
    public GearResult renameGearCatgory(int cid, String name) {
        //创建更新条件
        TbGearCatExample example = new TbGearCatExample();
        TbGearCatExample.Criteria criteria = example.createCriteria();
        criteria.andCidEqualTo(cid);

        //创建更新的内容
        TbGearCat gearCategory = new TbGearCat();
        gearCategory.setName(name);
        //执行更新
        gearCatMapper.updateByExampleSelective(gearCategory,example);

        return GearResult.ok();
    }


    /**
     * 删除分类
     * @param cid
     * @return
     */
    @Override
    public GearResult deleteGearCatgory(int cid) {
        //通过id查询该分类信息
        TbGearCat gearCategory = gearCatMapper.selectByPrimaryKey(cid);
        if(gearCategory.getIsParent()){
            //如果此分类下面有子分类，查询这些子分类的ID
            TbGearCatExample example = new TbGearCatExample();
            TbGearCatExample.Criteria criteria = example.createCriteria();
            criteria.andParentIdEqualTo(cid);
            List<TbGearCat> categories = gearCatMapper.selectByExample(example);

            if (categories.size() != 0 ){
                //遍历这些子分类，一个一个删除
                for (TbGearCat category : categories) {
                    deleteGearCatgory(category.getCid());
                }
            }else{
                //查询不到子分类了，需要更改isParent
                gearCategory.setIsParent(false);
                //写入数据库
                gearCatMapper.updateByPrimaryKey(gearCategory);
            }
        }

        //删除该分类信息
        gearCatMapper.deleteByPrimaryKey(cid);

        //删完之后，检查父节点的信息，是否需要更改isParent
        if (gearCategory.getParentId() != 0){
            TbGearCatExample parentExample = new TbGearCatExample();
            TbGearCatExample.Criteria parentCriteria = parentExample.createCriteria();
            parentCriteria.andParentIdEqualTo(gearCategory.getParentId());
            List<TbGearCat> list = gearCatMapper.selectByExample(parentExample);
            if (list.size() == 0){
                TbGearCat parent = gearCatMapper.selectByPrimaryKey(gearCategory.getParentId());
                parent.setIsParent(false);
                gearCatMapper.updateByPrimaryKey(parent);
            }
        }

        return GearResult.ok();
    }
}
