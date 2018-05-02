package com.gear.manager.service.impl;

import com.gear.common.pojo.GearResult;
import com.gear.manager.service.SearchGearService;
import com.gear.mapper.TbGearMapper;
import com.gear.pojo.SearchGear;
import com.gear.pojo.SearchResult;
import com.gear.pojo.TbGear;
import com.gear.pojo.TbGearExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 齿轮搜索服务
 */
@Service
public class SearchGearServiceImpl implements SearchGearService{

    @Autowired
    private TbGearMapper gearMapper;

    /**
     * 导入齿轮信息到索引库
     * @return
     */
    @Override
    public GearResult importGearsToIndex() {
        return null;
    }


    /**
     * 通过名称查询齿轮
     * @return List<TbGear>
     */
    @Override
    public SearchResult searchGearByName(String name,Integer startPage,Integer pageSize) {
        //1.在执行查询之前配置分页条件，使用PageHelper的静态方法
        PageHelper.startPage(startPage,pageSize);

        //2.设置查询条件，执行查询
        TbGearExample example = new TbGearExample();
        TbGearExample.Criteria criteria = example.createCriteria();

        name = "%" + name + "%";

        criteria.andTitleLike(name);
        List<TbGear> gearList = gearMapper.selectByExample(example);

        //3.取分页信息。使用PageInfo对象取
        PageInfo<TbGear> pageInfo = new PageInfo<>(gearList);

        //将TbGear转换为SearchGear
        List<SearchGear> searchGearList = new ArrayList<>();
        for (TbGear gear : gearList) {
            searchGearList.add(new SearchGear(gear));
        }

        //4.创建返回结果对象
        SearchResult result = new SearchResult();
        result.setGearList(searchGearList);
        result.setRecordCount(pageInfo.getTotal());

        return result;
    }


}
