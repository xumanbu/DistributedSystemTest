package com.bestxty.ds.oauth2.service;

import com.bestxty.ds.data.bean.FogUser;
import com.bestxty.ds.data.bean.FogUserExample;
import com.bestxty.ds.data.dao.FogUserMapper;
import com.bestxty.ds.oauth2.FogUserDetails;
import com.google.code.ssm.api.ParameterDataUpdateContent;
import com.google.code.ssm.api.ParameterValueKeyProvider;
import com.google.code.ssm.api.ReadThroughSingleCache;
import com.google.code.ssm.api.UpdateSingleCache;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by xty on 2016/8/31.
 * for project: DistributedSystemTest.
 */
@Service("userService")
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

        example.createCriteria().andIdEqualTo(userId);

        System.err.println("select user from database.");

        return mUserMapper.selectByExample(example).get(0);
    }

    @UpdateSingleCache(namespace = NAMESPACE, expiration = 3600)
    public void updateUser(@ParameterValueKeyProvider @ParameterDataUpdateContent FogUser user) {
        System.out.println("update user .");
        mUserMapper.updateByPrimaryKey(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        FogUserExample example = new FogUserExample();
        example.createCriteria().andIdEqualTo(username);
        List<FogUser> user = mUserMapper.selectByExample(example);

        if (user == null || user.size() == 0) {
            System.out.println("Not found any user for username[" + username + "]");
            throw new UsernameNotFoundException("Not found any user for username[" + username + "]");
        }

        return new FogUserDetails(user.get(0));
    }
}
