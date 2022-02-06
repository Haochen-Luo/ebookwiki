package com.example.ebook.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
public class TestController {

    @GetMapping("/hello")
    public String hello(){
        return "hahaha";
    }

    @PostMapping("/hello/post")
    public String helloPost(String name){
        return "hello world, POST"+name;

    }
}
