package com.bestxty.ds.web.controller.captcha;

import com.octo.captcha.service.image.ImageCaptchaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Created by xty on 2016/9/4.
 * for project: DistributedSystemTest.
 */
@Controller
@RequestMapping("/captcha")
public class CaptchaController {

    @Autowired
    private ImageCaptchaService imageCaptchaService;

    @RequestMapping
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) {

        System.out.println(imageCaptchaService);
        try {
            ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
            String captchaId = request.getSession().getId();
            System.out.println("captchaId = " + captchaId);
            BufferedImage challenge = imageCaptchaService.getImageChallengeForID(captchaId, request.getLocale());

            response.setHeader("Cache-Control", "no-store");
            response.setHeader("Pragma", "no-cache");
            response.setDateHeader("Expires", 0L);
            response.setContentType("image/jpeg");

            ImageIO.write(challenge, "jpeg", jpegOutputStream);
            byte[] captchaChallengeAsJpeg = jpegOutputStream.toByteArray();

            ServletOutputStream respOs = response.getOutputStream();
            respOs.write(captchaChallengeAsJpeg);
            respOs.flush();
            respOs.close();
        } catch (IOException e) {
//            logger.error("generate captcha image error: {}", e.getMessage());
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/doLogin", method = RequestMethod.POST)
    @ResponseBody
    public Boolean login(String captcha, HttpServletRequest request) {
        System.out.println(imageCaptchaService);
        System.out.println("captcha = " + captcha);
        System.out.println(request.getSession().getId());

        Boolean isResponseCorrect = imageCaptchaService.validateResponseForID(request.getSession().getId(), captcha);
        if (isResponseCorrect) {
            // 继续校验用户名密码等..
        }

        return isResponseCorrect;
    }
}
