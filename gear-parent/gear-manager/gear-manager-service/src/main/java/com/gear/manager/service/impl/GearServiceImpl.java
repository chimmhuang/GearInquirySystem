package com.gear.manager.service.impl;

import com.gear.common.pojo.EasyUIDataGridResult;
import com.gear.common.pojo.GearResult;
import com.gear.manager.service.GearService;
import com.gear.mapper.TbGearMapper;
import com.gear.pojo.TbGear;
import com.gear.pojo.TbGearExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 齿轮模块Service
 */
@Service
public class GearServiceImpl implements GearService{

    @Autowired
    private TbGearMapper gearMapper;


    /**
     * 查询齿轮列表
     * @param startPage 起始页数
     * @param pageSize 一页显示数
     * @return EasyUIDataGridResult
     */
    @Override
    public EasyUIDataGridResult getGearList(int startPage, int pageSize) {
        //1.在执行查询之前配置分页条件，使用PageHelper的静态方法
        PageHelper.startPage(startPage,pageSize);

        //2.执行查询（因为Service层有applicationContext，所以直接new example）
        TbGearExample example = new TbGearExample();
        List<TbGear> gearList = gearMapper.selectByExample(example);//不给example赋值，即为查询所有

        //3.取分页信息。使用PageInfo对象取
        PageInfo<TbGear> pageInfo = new PageInfo<>(gearList);

        //4.创建返回结果对象
        EasyUIDataGridResult result = new EasyUIDataGridResult();
        result.setTotal(pageInfo.getTotal());
        result.setRows(gearList);

        return result;
    }

    /**
     * 通过ID查询单个齿轮
     * @param gearId 齿轮ID
     * @return TbGear
     */
    @Override
    public TbGear getGearById(int gearId) {
        TbGear gear = gearMapper.selectByPrimaryKey(gearId);
        return gear;
    }

    /**
     * 通过ID查询齿轮描述
     * @param gearId 齿轮ID
     * @return GearResult
     */
    @Override
    public GearResult getGearDescById(int gearId) {
        TbGear gear = gearMapper.selectByPrimaryKey(gearId);
        return GearResult.ok(gear);
    }
}
