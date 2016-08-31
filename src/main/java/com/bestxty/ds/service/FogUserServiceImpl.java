package com.bestxty.ds.service;

import com.bestxty.ds.bean.FogUser;
import com.bestxty.ds.bean.FogUserExample;
import com.bestxty.ds.dao.FogUserMapper;
import com.google.code.ssm.api.ParameterDataUpdateContent;
import com.google.code.ssm.api.ParameterValueKeyProvider;
import com.google.code.ssm.api.ReadThroughSingleCache;
import com.google.code.ssm.api.UpdateSingleCache;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by xty on 2016/8/31.
 * for project: DistributedSystemTest.
 */
@Service
public class FogUserServiceImpl implements FogUserService {

    private static final String NAMESPACE = "ns";
    @Resource
    private FogUserMapper mUserMapper;


    public void saveUser(FogUser fogUser) {
        mUserMapper.insertSelective(fogUser);
    }


    @ReadThroughSingleCache(namespace = NAMESPACE, expiration = 3600)
    public FogUser getById(@ParameterValueKeyProvider String userId) {

        FogUserExample example = new FogUserExample();

        example.createCriteria().andUseridEqualTo(userId);

        System.err.println("select user from database.");

        return mUserMapper.selectByExample(example).get(0);
    }

    @UpdateSingleCache(namespace = NAMESPACE, expiration = 3600)
    public void updateUser(@ParameterValueKeyProvider @ParameterDataUpdateContent FogUser user) {
        System.out.println("update user .");
        mUserMapper.updateByPrimaryKey(user);
    }
}
