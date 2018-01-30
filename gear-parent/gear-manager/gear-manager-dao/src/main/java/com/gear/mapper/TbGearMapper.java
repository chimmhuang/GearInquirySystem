package com.gear.mapper;

import com.gear.pojo.TbGear;
import com.gear.pojo.TbGearExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbGearMapper {
    int countByExample(TbGearExample example);

    int deleteByExample(TbGearExample example);

    int deleteByPrimaryKey(Integer gearId);

    int insert(TbGear record);

    int insertSelective(TbGear record);

    List<TbGear> selectByExample(TbGearExample example);

    TbGear selectByPrimaryKey(Integer gearId);

    int updateByExampleSelective(@Param("record") TbGear record, @Param("example") TbGearExample example);

    int updateByExample(@Param("record") TbGear record, @Param("example") TbGearExample example);

    int updateByPrimaryKeySelective(TbGear record);

    int updateByPrimaryKey(TbGear record);
}