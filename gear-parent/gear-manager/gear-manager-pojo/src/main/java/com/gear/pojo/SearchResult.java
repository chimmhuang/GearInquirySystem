package com.gear.pojo;

import java.io.Serializable;
import java.util.List;

public class SearchResult implements Serializable{

    private List<SearchGear> gearList;
    private long recordCount;//总记录数

    public List<SearchGear> getGearList() {
        return gearList;
    }

    public void setGearList(List<SearchGear> gearList) {
        this.gearList = gearList;
    }

    public long getRecordCount() {
        return recordCount;
    }

    public void setRecordCount(long recordCount) {
        this.recordCount = recordCount;
    }
}
