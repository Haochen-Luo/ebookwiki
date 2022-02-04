package com.example.ebook.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
//@Controller
public class TestController {

    @RequestMapping("/hello")
    public String hello(){
        return "hahaha";
    }

}
