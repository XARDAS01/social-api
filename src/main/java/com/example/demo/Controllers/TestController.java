package com.example.demo.Controllers;

import org.springframework.web.bind.annotation.GetMapping;

public class TestController {
    @GetMapping("/")
    private String testController () {
        return "Hello world!";
    }
}
