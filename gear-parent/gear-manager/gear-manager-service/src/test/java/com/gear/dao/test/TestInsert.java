package com.gear.dao.test;

import com.gear.pojo.TbGear;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 * 添加齿轮脚本
 */
public class TestInsert {

    @Test
    public void testInsertGear() throws Exception{
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");
        TbGearMapper gearMapper = applicationContext.getBean(TbGearMapper.class);

        TbGear gear = new TbGear();
        gear.setCid(1);
        gear.setCreated(new Date());
        gear.setDescription("齿轮测试");
        gear.setImage("http://tupian");
        gear.setModels("3");
        gear.setTeeth("23");
        gear.setTitle("齿轮标题");
        gear.setUpdated(new Date());

        int insert = gearMapper.insert(gear);
        System.out.println(insert);

    }
}
