package com.bestxty.ds.web.controller.oauth;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
    private static final Logger logger = LogManager.getLogger(OAuthedController.class);

    @RequestMapping("/res")
    @ResponseBody
    public String oauthResrouce() {
        logger.info("test log--------------->");
        logger.debug("test log--------------->");
        logger.error("test log--------------->");
        logger.warn("test log--------------->");
        logger.trace("test log--------------->");
        logger.fatal("test log--------------->");
        return "oauthResrouce";
    }
}
