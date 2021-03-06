package com.gear.pojo;

import java.io.Serializable;
import java.util.Date;

public class TbGear implements Serializable{
    private Integer gearId;

    private String title;

    private String description;

    private String teeth = "0";

    private String diameter = "0";

    private String models = "0";

    private String image;

    private Integer cid = 1;

    private Date created;

    private Date updated;

    public Integer getGearId() {
        return gearId;
    }

    public void setGearId(Integer gearId) {
        this.gearId = gearId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getTeeth() {
        return teeth;
    }

    public void setTeeth(String teeth) {
        this.teeth = teeth == null ? null : teeth.trim();
    }

    public String getDiameter() {
        return diameter;
    }

    public void setDiameter(String diameter) {
        this.diameter = diameter == null ? null : diameter.trim();
    }

    public String getModels() {
        return models;
    }

    public void setModels(String models) {
        this.models = models == null ? null : models.trim();
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }
}