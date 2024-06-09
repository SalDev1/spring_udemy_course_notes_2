package com.salcorps.springbootdemo4.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello-world")
    public String helloWorld() {
        String msg = "Hello World";
        return msg;
    }
}
