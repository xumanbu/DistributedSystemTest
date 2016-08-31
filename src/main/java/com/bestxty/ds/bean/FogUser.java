package com.bestxty.ds.bean;

public class FogUser {
    private Integer fogUserId;

    private String userid;

    private String token;

    public Integer getFogUserId() {
        return fogUserId;
    }

    public void setFogUserId(Integer fogUserId) {
        this.fogUserId = fogUserId;
    }

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
}