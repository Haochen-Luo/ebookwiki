package com.example.ebook.controller;


import com.example.ebook.domain.Test;
import com.example.ebook.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


@RestController
public class TestController {

    private static final Logger LOG = LoggerFactory.getLogger(TestController.class);

    @Value("${test.hello:DEFAULT_VALUE}")
    private String testHello;

    @Resource
    private TestService testService;

    @GetMapping("/hello")
    public String hello(){
        return "hahaha"+testHello;
    }

//    这个不能在浏览器上直接访问
//    会返回no explicit mapping 的错误
    @PostMapping("/hello/post")
    public String helloPost(String name){
        return "hello world, POST"+name;
    }

    @GetMapping("/test/list")
    public List<Test> list(){
        return testService.list();
    }


}
