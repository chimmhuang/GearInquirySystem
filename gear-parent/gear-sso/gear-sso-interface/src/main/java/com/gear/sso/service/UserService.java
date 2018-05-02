package com.gear.sso.service;

import com.gear.common.pojo.GearResult;

public interface UserService {

    GearResult login(String username,String password,boolean isRemember);
    GearResult getUserByToken(String token);
}
