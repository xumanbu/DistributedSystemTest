package com.bestxty.ds.service;

import com.bestxty.ds.bean.FogUser;

/**
 * Created by xty on 2016/8/31.
 * for project: DistributedSystemTest.
 */
public interface FogUserService {


    void saveUser(FogUser fogUser);

    FogUser getById(String userId);

    void updateUser(FogUser user);

}
