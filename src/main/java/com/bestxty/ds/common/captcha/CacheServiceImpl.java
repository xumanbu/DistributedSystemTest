package com.bestxty.ds.common.captcha;

import com.google.code.ssm.Cache;
import com.google.code.ssm.api.format.SerializationType;
import com.google.code.ssm.providers.CacheException;
import com.octo.captcha.service.captchastore.CaptchaAndLocale;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeoutException;

/**
 * Created by xty on 2016/9/4.
 * for project: DistributedSystemTest.
 */
@Component
public class CacheServiceImpl implements CacheService {


    @Resource
    private Cache mCache;

    @Override
    public CaptchaAndLocale getCaptcha(String id) {
        try {
            return mCache.get(id, SerializationType.JAVA);
        } catch (TimeoutException | CacheException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void setCaptcha(String id, CaptchaAndLocale captchaAndLocale) {
        try {
            mCache.set(id, 3600, captchaAndLocale, SerializationType.JAVA);
        } catch (TimeoutException | CacheException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean removeCaptcha(String id) {
        try {
            return mCache.delete(id);
        } catch (TimeoutException | CacheException e) {
            e.printStackTrace();
        }
        return false;
    }
}
