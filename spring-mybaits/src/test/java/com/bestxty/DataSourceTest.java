package com.bestxty;

import com.bestxty.ds.data.bean.FogUser;
import com.bestxty.ds.data.dao.FogUserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Unit test for simple App.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybaits-test.xml"})
public class DataSourceTest {

    @Resource
    private FogUserMapper mUserMapper;

    @Test
    @Transactional
    @Rollback(value = false)
    public void testUserInsert() {

        Assert.assertNotNull(mUserMapper);

        FogUser user = new FogUser();
        user.setId(1 + "");
        user.setToken("xxxxxxx");
//        user.setUserid("1232");

        mUserMapper.insertSelective(user);
    }
}
