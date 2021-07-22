package com.example.spring_awesome.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/a")
public class HelloWorld {
    @RequestMapping("/b")
    public String hello(@RequestParam("t") String t) {
        System.out.println(t);
        return t;
    }

    @RequestMapping("/c")
    public String world(@RequestParam("t") String t) {
        System.out.println("world" + t);
        return t;
    }
}
