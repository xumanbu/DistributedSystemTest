package com.bestxty.ds;

import com.bestxty.ds.bean.IUserDao;
import com.bestxty.ds.bean.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by xty on 2016/8/31.
 * for project: DistributedSystemTest.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-config.xml"})
public class MemCachedTest {


    @Resource
    private IUserDao mUserDao;


    @Test
    public void testUserDao() {
        User user = new User();
        user.setPassword("123456");
        user.setUserId("1");
        user.setUsername("swjjxyxty");

        System.out.println("create user = " + user);

        mUserDao.saveUser(user);


        user = mUserDao.getById("1");

        System.out.println("get user by id  = " + user);

        user.setUsername("12fggg");

        mUserDao.updateUser(user);


        System.out.println("update user = " + user);

        user = mUserDao.getById("1");

        System.out.println("get user by id again = " + user);

        mUserDao.deleteUser("1");


    }


}
