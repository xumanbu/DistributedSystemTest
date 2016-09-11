package com.bestxty.ds.bean;

import com.google.code.ssm.api.CacheKeyMethod;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FogUser implements Serializable {
    private static final long serialVersionUID = -6694748868504187674L;
    private Integer fogUserId;

    private String userid;

    private String token;

    private String username;

    private String password;


    private List<Privilege> privileges = new ArrayList<>();

    public List<Privilege> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(List<Privilege> privileges) {
        this.privileges = privileges;
    }

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }


    @Override
    public String toString() {
        return "FogUser{" +
                "fogUserId=" + fogUserId +
                ", userid='" + userid + '\'' +
                ", token='" + token + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", privileges=" + privileges +
                '}';
    }
}