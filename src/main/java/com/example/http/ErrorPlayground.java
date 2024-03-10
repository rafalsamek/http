package com.example.http;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorPlayground {
    @GetMapping("/error/1")
    public ResponseEntity<String> test1() {
//        return ResponseEntity.ok("Test");
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Princess is in another castle");
    }
}
