package com.bestxty.ds.web.controller.user;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

    private static final Logger logger = LogManager.getLogger(FogUserController.class);

//    @Autowired
//    private FogUserService mUserService;

    public FogUserController() {
    }

    @RequestMapping("/add")
    @ResponseBody
    public String create(@RequestParam(value = "token") String token) {

        logger.info("SpringMvc Controller Test.");
//        FogUser fogUser = new FogUser();
//        fogUser.setToken(token);
//        fogUser.setUserid("xty3");
//
//        mUserService.saveUser(fogUser);

        return "create new user success-" + token;
    }

    @RequestMapping("/get")
    @ResponseBody
    public String get(@RequestParam(value = "userId") String userId) {

//        return "get  user success-" + mUserService.getById(userId).toString();
        return "get  user success-";
    }

    @RequestMapping("/update")
    @ResponseBody
    public String update(@RequestParam(value = "userId") String userId) {

//        FogUser user = mUserService.getById(userId);
//
//        user.setToken("updated .token ");
//
//        mUserService.updateUser(user);

//        return "update  user success-" + user.getToken();
        return "update  user success-";
    }
}
