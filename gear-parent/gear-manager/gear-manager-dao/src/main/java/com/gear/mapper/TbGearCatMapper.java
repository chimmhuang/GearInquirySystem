package com.gear.mapper;

import com.gear.pojo.TbGearCat;
import com.gear.pojo.TbGearCatExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbGearCatMapper {
    int countByExample(TbGearCatExample example);

    int deleteByExample(TbGearCatExample example);

    int deleteByPrimaryKey(Integer cid);

    int insert(TbGearCat record);

    int insertSelective(TbGearCat record);

    List<TbGearCat> selectByExample(TbGearCatExample example);

    TbGearCat selectByPrimaryKey(Integer cid);

    int updateByExampleSelective(@Param("record") TbGearCat record, @Param("example") TbGearCatExample example);

    int updateByExample(@Param("record") TbGearCat record, @Param("example") TbGearCatExample example);

    int updateByPrimaryKeySelective(TbGearCat record);

    int updateByPrimaryKey(TbGearCat record);
}