package com.example.http;

import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RequestParamController {

    @GetMapping("/param")
    public String concat(@RequestParam String left, @RequestParam(required = false, defaultValue = "") String right) {
        return left.concat(right);
    }

    @GetMapping("/param/add")
    public Integer add(@RequestParam List<Integer> numbers) {
        int result = 0;
        for (Integer number : numbers) {
            result += number;
        }

        return result;
    }
}
