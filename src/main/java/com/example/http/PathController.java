package com.example.http;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PathController {

    @GetMapping("/path/{name}")
    public String uppercase(@PathVariable String name) {
        return name.toUpperCase();
    }

    @GetMapping("/add/{a}/{b}")
    public Integer add(@PathVariable int a, @PathVariable int b) {
        return a + b;
    }
}
