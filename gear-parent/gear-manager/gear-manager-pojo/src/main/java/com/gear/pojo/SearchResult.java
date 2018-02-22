package com.gear.pojo;

import java.io.Serializable;
import java.util.List;

public class SearchResult implements Serializable{

    private List<TbGear> gearList;
    private long recordCount;//总记录数

    public List<TbGear> getGearList() {
        return gearList;
    }

    public void setGearList(List<TbGear> gearList) {
        this.gearList = gearList;
    }

    public long getRecordCount() {
        return recordCount;
    }

    public void setRecordCount(long recordCount) {
        this.recordCount = recordCount;
    }
}
