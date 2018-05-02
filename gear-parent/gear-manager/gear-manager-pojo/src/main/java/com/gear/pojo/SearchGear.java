package com.gear.pojo;

import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.Date;

public class SearchGear extends TbGear{

    public SearchGear(){}

    public SearchGear(TbGear gear){
        this.setCid(gear.getCid());
        this.setCreated(gear.getCreated());
        this.setDescription(gear.getDescription());
        this.setDiameter(gear.getDiameter());
        this.setGearId(gear.getGearId());
        this.setImage(getOneImage(gear.getImage()));
        this.setModels(gear.getModels());
        this.setTeeth(gear.getTeeth());
        this.setTitle(gear.getTitle());
        this.setUpdated(gear.getUpdated());
    }

    public String getOneImage(String image) {
        if (image != null && !"".equals(image)){
            String[] images = image.split(",");
            return images[0];
        }
        return null;
    }
}
