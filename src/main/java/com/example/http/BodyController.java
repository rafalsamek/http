package com.example.http;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BodyController {

    @PutMapping("/body/lower")
    public String lower(@RequestBody String text) {
        return text.toLowerCase();
    }
}
