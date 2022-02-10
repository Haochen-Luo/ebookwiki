package com.example.ebook.service;


import com.example.ebook.domain.Demo;
import com.example.ebook.mapper.DemoMapper;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DemoService {
    @Resource
    private DemoMapper demoMapper;

    public List<Demo> list(){
        return demoMapper.selectByExample(null);
    }
//    demoMapper.selectByExample(null);类似于 where. null 意味着select all



}
