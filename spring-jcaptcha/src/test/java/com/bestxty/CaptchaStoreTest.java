package com.bestxty;

import com.bestxty.ds.jcaptcha.CacheService;
import com.octo.captcha.service.text.TextCaptchaService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

/**
 * Created by xty on 2016/9/4.
 * for project: DistributedSystemTest.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-jcaptcha-test.xml"})
public class CaptchaStoreTest extends AbstractJUnit4SpringContextTests {


    @Autowired
    private CacheService mCacheService;


    @Autowired
    private TextCaptchaService mTextCaptchaService;

    @Test
    public void testStore() {
        System.out.println(mCacheService == null);

        String id = UUID.randomUUID().toString();

        String text = mTextCaptchaService.getTextChallengeForID(id);

        System.out.println(text);

        String[] nums = text.split("\\+");

        int resi = Integer.parseInt(nums[0]) + Integer.parseInt(nums[1]);

        boolean res = mTextCaptchaService.validateResponseForID(id, String.valueOf(resi));

        System.out.println("res = " + res);

    }
}
