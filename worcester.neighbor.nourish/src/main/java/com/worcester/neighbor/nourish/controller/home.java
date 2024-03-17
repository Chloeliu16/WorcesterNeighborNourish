package com.worcester.neighbor.nourish.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class home {

    @GetMapping("/home")
    public String getHome() {
        return "welcome to home page!";
    }
}
