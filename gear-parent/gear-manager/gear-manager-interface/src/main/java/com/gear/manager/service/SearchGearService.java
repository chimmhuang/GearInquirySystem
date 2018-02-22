package com.gear.manager.service;

import com.gear.common.pojo.GearResult;
import com.gear.pojo.SearchResult;

public interface SearchGearService {

    GearResult importGearsToIndex();
    SearchResult searchGearByName(String name,Integer startPage,Integer pageSize);
}
