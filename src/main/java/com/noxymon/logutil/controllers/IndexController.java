package com.noxymon.logutil.controllers;

import com.google.cloud.logging.Severity;
import id.alfadigital.lunar.LunarLogger;
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
        LunarLogger lunarLogger = new LunarLogger();
        lunarLogger.logName("test-sena")
                .withClass(this.getClass())
                .withLevel(Severity.INFO)
                .log("ini testing biasa");
        try {
            testError();
        } catch (RuntimeException ex) {
            lunarLogger.logName("test-sena")
                    .withClass(this.getClass())
                    .withLevel(Severity.INFO)
                    .trace(ex.getMessage(), ex);
        }
        return new ResponseEntity(null, HttpStatus.ACCEPTED);
    }

    private void testError() throws RuntimeException {
        throw new RuntimeException("ajdgjsdhgajsdgajhdgsajdgjhagsdjad");
    }

}
