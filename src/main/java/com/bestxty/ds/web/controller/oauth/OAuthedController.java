package com.bestxty.ds.web.controller.oauth;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by xty on 2016/9/4.
 * for project: DistributedSystemTest.
 */
@Controller
@RequestMapping("/oauthed")
public class OAuthedController {


    @RequestMapping("/res")
    @ResponseBody
    public String oauthResrouce() {
        return "oauthResrouce";
    }
}
