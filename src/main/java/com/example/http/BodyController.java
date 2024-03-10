package com.example.http;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

class User {
    private String name;
    private String surname;

    public User(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}

@RestController
public class BodyController {

    @PutMapping("/body/lower")
    public String lower(@RequestBody String text) {
        return text.toLowerCase();
    }

    @PostMapping("/body/save")
    public String save(@RequestBody User user) {
        return user.getName() + " " + user.getSurname() + " saved!";
    }

    @PutMapping("/body/save")
    public User put(@RequestBody User user) {
        return user;
    }
}
