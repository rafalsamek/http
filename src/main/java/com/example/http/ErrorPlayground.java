package com.example.http;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorPlayground {
    @GetMapping("/error/1")
    public ResponseEntity<String> test1() {
//        return ResponseEntity.ok("Test");
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Princess is in another castle");
    }

    @ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
    @GetMapping("/error/2")
    public String test2() {
        return "Princess is in another castle";
    }

    @GetMapping("/error/3")
    public String test3() {
        throw new RuntimeException();
    }

    @ExceptionHandler(RuntimeException.class)
    public String handle(RuntimeException e) {
        return "Ups something went wrong";
    }
}
