package com.bestxty.ds.web.controller;

import com.bestxty.ds.bean.FogUser;
import com.bestxty.ds.service.FogUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by xty on 2016/8/31.
 * for project: DistributedSystemTest.
 */
@Controller
@RequestMapping("/user")
public class FogUserController {

    @Autowired
    private FogUserService mUserService;

    public FogUserController() {
        System.out.println("FogUserController.FogUserController----------->");
    }

    @RequestMapping("/add")
    @ResponseBody
    public String create(@RequestParam(value = "token") String token) {

        FogUser fogUser = new FogUser();
        fogUser.setToken(token);
        fogUser.setUserid("xty3");

        mUserService.saveUser(fogUser);

        return "create new user success-" + token;
    }

    @RequestMapping("/get")
    @ResponseBody
    public String get(@RequestParam(value = "userId") String userId) {

        return "get  user success-" + mUserService.getById(userId).toString();
    }

    @RequestMapping("/update")
    @ResponseBody
    public String update(@RequestParam(value = "userId") String userId) {

        FogUser user = mUserService.getById(userId);

        user.setToken("updated .token ");

        mUserService.updateUser(user);

        return "update  user success-" + user.getToken();
    }
}
