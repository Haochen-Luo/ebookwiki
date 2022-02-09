package com.example.ebook.service;

import com.example.ebook.domain.Test;
import com.example.ebook.mapper.TestMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


//加了service spring 才能扫描进来
@Service
public class TestService {

//    使用@resource来注入
    @Resource
    private TestMapper testMapper;

    public List<Test> list(){
        return testMapper.list();
    }


}
