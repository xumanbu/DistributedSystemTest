package com.bestxty.ds;

import com.bestxty.ds.bean.FogUser;
import com.bestxty.ds.service.FogUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by xty on 2016/8/31.
 * for project: DistributedSystemTest.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-config.xml"})
public class UserServiceTest {

    @Autowired
    private FogUserService mUserService;


    @Test
    public void testCache() throws InterruptedException {
        FogUser fogUser = new FogUser();
        fogUser.setToken("test token2");
        fogUser.setUserid("xty2");

        mUserService.saveUser(fogUser);


        FogUser user = mUserService.getById("xty2");

        System.out.println("user = " + user);

        Thread.sleep(5000);

        user.setToken("updated. token2");

        mUserService.updateUser(user);


        System.out.println("user update.");

        user = mUserService.getById("xty2");

        System.out.println("user = " + user);


    }

}
