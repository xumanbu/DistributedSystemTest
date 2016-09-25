package com.bestxty.ds.jcaptcha;

import com.octo.captcha.service.captchastore.CaptchaAndLocale;

/**
 * Created by xty on 2016/9/4.
 * for project: DistributedSystemTest.
 */
public interface CacheService {
    CaptchaAndLocale getCaptcha(String id);

    void setCaptcha(String id, CaptchaAndLocale captchaAndLocale);

    boolean removeCaptcha(String id);
}
