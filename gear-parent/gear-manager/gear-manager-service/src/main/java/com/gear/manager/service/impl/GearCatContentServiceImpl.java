package com.gear.manager.service.impl;

import com.gear.common.pojo.EasyUIDataGridResult;
import com.gear.common.pojo.GearResult;
import com.gear.manager.service.GearCatContentService;
import com.gear.mapper.TbGearCraftsMapper;
import com.gear.mapper.TbGearMapper;
import com.gear.pojo.TbGear;
import com.gear.pojo.TbGearCrafts;
import com.gear.pojo.TbGearExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


/**
 * 分类内容管理Service
 */
@Service
public class GearCatContentServiceImpl implements GearCatContentService {


    @Autowired
    private TbGearMapper gearMapper;
    @Autowired
    private TbGearCraftsMapper gearCraftsMapper;

    /**
     * 查询该分类下的齿轮列表
     * @param categoryId 分类ID
     * @param startPage 起始页
     * @param pageSize 一页显示数
     * @return
     */
    @Override
    public EasyUIDataGridResult getGearList(Integer categoryId, Integer startPage, Integer pageSize) {
        //1.在执行查询之前配置分页条件，使用PageHelper的静态方法
        PageHelper.startPage(startPage,pageSize);

        //2.执行查询
        TbGearExample example = new TbGearExample();
        TbGearExample.Criteria criteria = example.createCriteria();
        criteria.andCidEqualTo(categoryId);
        List<TbGear> gears = gearMapper.selectByExample(example);

        //3.取分页信息。使用PageInfo对象取
        PageInfo<TbGear> pageInfo = new PageInfo<TbGear>(gears);

        //4.创建返回结果对象
        EasyUIDataGridResult result = new EasyUIDataGridResult();
        result.setTotal(pageInfo.getTotal());
        result.setRows(gears);
        return result;
    }


    /**
     * 添加该分类下的齿轮信息
     * @param gear 齿轮对象
     * @param content 齿轮描述
     * @return GearResult
     */
    @Override
    public GearResult addContent(TbGear gear,String content) {
        //补全pojo属性
        gear.setCreated(new Date());
        gear.setUpdated(new Date());

        //插入到对应的齿轮表
        gearMapper.insert(gear);

        //创建齿轮工艺对象
        TbGearCrafts gearCrafts = new TbGearCrafts();
        //补全pojo属性
        gearCrafts.setGearId(gear.getGearId());
        gearCrafts.setGearCraftsDesc(content);
        gearCrafts.setCreated(new Date());
        gearCrafts.setUpdated(new Date());

        //插入到对应的齿轮工艺表中
        gearCraftsMapper.insert(gearCrafts);

        return GearResult.ok();
    }

    /**
     * 修改该分类下选择的齿轮信息
     * @param gear 齿轮对象
     * @param content 齿轮描述
     * @return GearResult
     */
    @Override
    public GearResult editContent(TbGear gear, String content) {
        //添加齿轮更新时间
        gear.setUpdated(new Date());

        //创建齿轮工艺对象
        TbGearCrafts gearCrafts = new TbGearCrafts();
        //补全pojo对象
        gearCrafts.setUpdated(new Date());
        gearCrafts.setGearCraftsDesc(content);
        gearCrafts.setGearId(gear.getGearId());

        //执行更新操作
        gearMapper.updateByPrimaryKeySelective(gear);
        gearCraftsMapper.updateByPrimaryKeySelective(gearCrafts);


        return GearResult.ok();

    }
}
