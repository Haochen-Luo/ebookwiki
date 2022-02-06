package com.example.ebook.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
public class TestController {


    @Value("${test.hello:DEFAULT_VALUE}")
    private String testHello;

    @GetMapping("/hello")
    public String hello(){
        return "hahaha"+testHello;
    }

    @PostMapping("/hello/post")
    public String helloPost(String name){
        return "hello world, POST"+name;

    }



}
