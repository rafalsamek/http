package com.example.http;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestHeaderController {

    @GetMapping("/headers/secret")
    public String execute(@RequestHeader("Auth") String secret) {
        if ("topSecretPassword123!".equals(secret)) {
            return "WORKING ON IT";
        } else {
            return "ACCESS DENIED!";
        }
    }
}
