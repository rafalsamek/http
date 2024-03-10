package com.example.http;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

public class ErrorPlayground {
    @GetMapping("/error/1")
    public ResponseEntity<String> test1() {
        return ResponseEntity.ok("Test");
    }
}
