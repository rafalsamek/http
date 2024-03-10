package com.example.http.communication;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestHeaderController {

    @GetMapping(value = "/headers/secret", consumes = "text/plain")
    public String execute(@RequestHeader("Auth") String secret) {
        // better to use message digest instead of equals
        if ("topSecretPassword123!".equals(secret)) {
            return "WORKING ON IT";
        } else {
            return "ACCESS DENIED!";
        }
    }
}
