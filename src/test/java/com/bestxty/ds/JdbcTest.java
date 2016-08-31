package com.bestxty.ds;

import com.bestxty.ds.bean.FogUser;
import com.bestxty.ds.dao.FogUserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by xty on 2016/8/31.
 * for project: DistributedSystemTest.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-config.xml"})
public class JdbcTest {


    @Resource
    private FogUserMapper mUserMapper;

    @Test
    @Transactional
    public void testUserInsert() {

        FogUser user = new FogUser();
        user.setFogUserId(1);
        user.setToken("xxxxxxx");
        user.setUserid("1232");

        mUserMapper.insertSelective(user);
    }
}
