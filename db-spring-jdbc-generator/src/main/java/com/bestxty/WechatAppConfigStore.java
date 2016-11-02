package com.bestxty;

/**
 * @author xty
 *         Created by xty on 2016-09-29.
 */
public interface WechatAppConfigStore {

    WechatAppConfig getWechatAppConfigByAppId(String appId);

    WechatAppConfig getWechatAppConfig(String id);
}