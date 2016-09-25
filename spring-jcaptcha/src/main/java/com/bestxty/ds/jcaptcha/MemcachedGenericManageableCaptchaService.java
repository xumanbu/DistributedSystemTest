package com.bestxty.ds.jcaptcha;

import com.octo.captcha.Captcha;
import com.octo.captcha.engine.CaptchaEngine;
import com.octo.captcha.image.ImageCaptcha;
import com.octo.captcha.service.AbstractManageableCaptchaService;
import com.octo.captcha.service.CaptchaServiceException;
import com.octo.captcha.service.multitype.MultiTypeCaptchaService;
import com.octo.captcha.sound.SoundCaptcha;
import com.octo.captcha.text.TextCaptcha;

import javax.sound.sampled.AudioInputStream;
import java.awt.image.BufferedImage;
import java.util.Locale;

/**
 * Created by xty on 2016/9/4.
 * for project: DistributedSystemTest.
 */
public class MemcachedGenericManageableCaptchaService extends AbstractManageableCaptchaService implements MultiTypeCaptchaService {


    protected MemcachedGenericManageableCaptchaService(MemcachedCaptchaStore captchaStore, CaptchaEngine captchaEngine, int minGuarantedStorageDelayInSeconds, int maxCaptchaStoreSize) {
        super(captchaStore, captchaEngine, minGuarantedStorageDelayInSeconds, maxCaptchaStoreSize);
    }

    protected MemcachedGenericManageableCaptchaService(MemcachedCaptchaStore captchaStore, CaptchaEngine captchaEngine, int minGuarantedStorageDelayInSeconds, int maxCaptchaStoreSize, int captchaStoreLoadBeforeGarbageCollection) {
        super(captchaStore, captchaEngine, minGuarantedStorageDelayInSeconds, maxCaptchaStoreSize, captchaStoreLoadBeforeGarbageCollection);
    }


    @Override
    protected Object getChallengeClone(Captcha captcha) {
        Class captchaClass = captcha.getClass();

        if (ImageCaptcha.class.isAssignableFrom(captchaClass)) {
            BufferedImage challenge1 = (BufferedImage) captcha.getChallenge();
            BufferedImage clone1 = new BufferedImage(challenge1.getWidth(), challenge1.getHeight(), challenge1.getType());
            clone1.getGraphics().drawImage(challenge1, 0, 0, clone1.getWidth(), clone1.getHeight(), null);
            clone1.getGraphics().dispose();
            return clone1;
        } else if (SoundCaptcha.class.isAssignableFrom(captchaClass)) {
            AudioInputStream challenge = (AudioInputStream) captcha.getChallenge();
            return new AudioInputStream(challenge, challenge.getFormat(), challenge.getFrameLength());
        } else if (TextCaptcha.class.isAssignableFrom(captchaClass)) {
            return String.valueOf(captcha.getChallenge());
        } else {
            throw new CaptchaServiceException("Unknown captcha type, can\'t clone challenge captchaClass:\'" + captcha.getClass() + "\'");
        }
    }

    @Override
    public BufferedImage getImageChallengeForID(String ID) throws CaptchaServiceException {
        return (BufferedImage) this.getChallengeForID(ID);
    }

    @Override
    public BufferedImage getImageChallengeForID(String ID, Locale locale) throws CaptchaServiceException {
        return (BufferedImage) this.getChallengeForID(ID, locale);
    }

    @Override
    public AudioInputStream getSoundChallengeForID(String ID) throws CaptchaServiceException {
        return (AudioInputStream) this.getChallengeForID(ID);
    }

    @Override
    public AudioInputStream getSoundChallengeForID(String ID, Locale locale) throws CaptchaServiceException {
        return (AudioInputStream) this.getChallengeForID(ID, locale);
    }

    @Override
    public String getTextChallengeForID(String ID) throws CaptchaServiceException {
        return (String) this.getChallengeForID(ID);
    }

    @Override
    public String getTextChallengeForID(String ID, Locale locale) throws CaptchaServiceException {
        return (String) this.getChallengeForID(ID, locale);
    }
}
