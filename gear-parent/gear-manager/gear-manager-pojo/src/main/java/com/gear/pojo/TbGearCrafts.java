package com.gear.pojo;

import java.io.Serializable;
import java.util.Date;

public class TbGearCrafts implements Serializable{
    private Integer gearId;

    private Date created;

    private Date updated;

    private String gearCraftsDesc;

    public Integer getGearId() {
        return gearId;
    }

    public void setGearId(Integer gearId) {
        this.gearId = gearId;
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

    public String getGearCraftsDesc() {
        return gearCraftsDesc;
    }

    public void setGearCraftsDesc(String gearCraftsDesc) {
        this.gearCraftsDesc = gearCraftsDesc == null ? null : gearCraftsDesc.trim();
    }
}