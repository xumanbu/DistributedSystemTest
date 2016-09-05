package com.bestxty.ds.service.captcha;

import com.octo.captcha.Captcha;
import com.octo.captcha.service.CaptchaServiceException;
import com.octo.captcha.service.captchastore.CaptchaAndLocale;
import com.octo.captcha.service.captchastore.CaptchaStore;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.Locale;

/**
 * Created by xty on 2016/9/4.
 * for project: DistributedSystemTest.
 */
public class MemcachedCaptchaStore implements CaptchaStore {


    @Resource
    private CacheService cacheService;

    @Override
    public boolean hasCaptcha(String id) {
        CaptchaAndLocale captcha = cacheService.getCaptcha(id);

        return captcha != null;
    }

    @Override
    public void storeCaptcha(String id, Captcha captcha) throws CaptchaServiceException {
        System.out.println("id = [" + id + "], captcha = [" + captcha + "]");
        try {

            cacheService.setCaptcha(id, new CaptchaAndLocale(captcha));

        } catch (Exception e) {

            throw new CaptchaServiceException(e);

        }
    }

    @Override
    public void storeCaptcha(String id, Captcha captcha, Locale locale) throws CaptchaServiceException {
        System.out.println("id = [" + id + "], captcha = [" + captcha + "], locale = [" + locale + "]");
        try {

            cacheService.setCaptcha(id, new CaptchaAndLocale(captcha, locale));

        } catch (Exception e) {

            throw new CaptchaServiceException(e);

        }
    }

    @Override
    public boolean removeCaptcha(String id) {
        return cacheService.removeCaptcha(id);

    }

    @Override
    public Captcha getCaptcha(String id) throws CaptchaServiceException {
        System.out.println("id = " + id);
        CaptchaAndLocale captchaAndLocale = cacheService.getCaptcha(id);

        return captchaAndLocale != null ? (captchaAndLocale.getCaptcha()) : null;
    }

    @Override
    public Locale getLocale(String id) throws CaptchaServiceException {
        CaptchaAndLocale captchaAndLocale = cacheService.getCaptcha(id);
        return captchaAndLocale != null ? (captchaAndLocale.getLocale()) : null;
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public Collection getKeys() {
        return null;
    }

    @Override
    public void empty() {

    }
}
