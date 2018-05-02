package com.gear.mapper;

import com.gear.pojo.TbGearCrafts;
import com.gear.pojo.TbGearCraftsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbGearCraftsMapper {
    int countByExample(TbGearCraftsExample example);

    int deleteByExample(TbGearCraftsExample example);

    int deleteByPrimaryKey(Integer gearId);

    int insert(TbGearCrafts record);

    int insertSelective(TbGearCrafts record);

    List<TbGearCrafts> selectByExampleWithBLOBs(TbGearCraftsExample example);

    List<TbGearCrafts> selectByExample(TbGearCraftsExample example);

    TbGearCrafts selectByPrimaryKey(Integer gearId);

    int updateByExampleSelective(@Param("record") TbGearCrafts record, @Param("example") TbGearCraftsExample example);

    int updateByExampleWithBLOBs(@Param("record") TbGearCrafts record, @Param("example") TbGearCraftsExample example);

    int updateByExample(@Param("record") TbGearCrafts record, @Param("example") TbGearCraftsExample example);

    int updateByPrimaryKeySelective(TbGearCrafts record);

    int updateByPrimaryKeyWithBLOBs(TbGearCrafts record);

    int updateByPrimaryKey(TbGearCrafts record);
}