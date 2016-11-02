package com.bestxty;

import java.util.Date;

/**
 * Created by xty on 2016/9/26.
 * for project: Wechat-lib.
 */
public class WechatAppConfig {

    private String id;

    private String appId;

    private String secret;

    private boolean enabled;

    private boolean locked;

    private Date createTime;

    public WechatAppConfig() {
    }

    public WechatAppConfig(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "WechatAppConfig{" +
                "id='" + id + '\'' +
                ", appId='" + appId + '\'' +
                ", secret='" + secret + '\'' +
                ", enabled=" + enabled +
                ", locked=" + locked +
                ", createTime=" + createTime +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId == null ? null : appId.trim();
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret == null ? null : secret.trim();
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
