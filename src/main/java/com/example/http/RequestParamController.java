package com.example.http;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestParamController {

    @GetMapping("/param")
    public String concat(@RequestParam String left, @RequestParam String right) {
        return left.concat(right);
    }
}
