package com.bestxty.ds.service;

import com.bestxty.ds.bean.FogUser;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Created by xty on 2016/8/31.
 * for project: DistributedSystemTest.
 */
public interface FogUserService extends UserDetailsService {


    void saveUser(FogUser fogUser);

    FogUser getById(String userId);

    void updateUser(FogUser user);

}
