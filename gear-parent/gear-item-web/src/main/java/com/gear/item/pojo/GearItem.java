package com.gear.item.pojo;

import com.gear.pojo.TbGear;

public class GearItem extends TbGear{

    public String[] getImages(){
        String image2 = this.getImage();
        if (image2 != null && !"".equals(image2)){
            String[] images = image2.split(",");
            return images;
        }
        return null;
    }

    public GearItem(){}

    public GearItem(TbGear gear){
        this.setCid(gear.getCid());
        this.setCreated(gear.getCreated());
        this.setDescription(gear.getDescription());
        this.setDiameter(gear.getDiameter());
        this.setGearId(gear.getGearId());
        this.setImage(gear.getImage());
        this.setModels(gear.getModels());
        this.setTeeth(gear.getTeeth());
        this.setTitle(gear.getTitle());
        this.setUpdated(gear.getUpdated());
    }

}
