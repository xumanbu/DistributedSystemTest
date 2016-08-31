package com.bestxty.ds.bean;

import com.google.code.ssm.api.CacheKeyMethod;

import java.io.Serializable;

public class FogUser implements Serializable {
    private static final long serialVersionUID = 5156108490825077651L;
    private Integer fogUserId;

    private String userid;

    private String token;

    public Integer getFogUserId() {
        return fogUserId;
    }

    public void setFogUserId(Integer fogUserId) {
        this.fogUserId = fogUserId;
    }


    @CacheKeyMethod
    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token == null ? null : token.trim();
    }

    @Override
    public String toString() {
        return "FogUser{" +
                "fogUserId=" + fogUserId +
                ", userid='" + userid + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}