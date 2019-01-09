package com.noxymon.logutil.controllers;

import com.noxymon.logutil.utils.LogUtil;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class IndexController {

    @RequestMapping("/log")
    public HttpEntity test(){
        LogUtil.withLogName("test-app")
                .info("testing blablabsclasjadhsakdda");
        return new ResponseEntity(null, HttpStatus.ACCEPTED);
    }

}
