package com.example.ebook.service;

import com.example.ebook.domain.Ebook;
import com.example.ebook.mapper.EbookMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EbookService {

    @Resource
    private EbookMapper ebookMapper;

    public List<Ebook> list(){
        return ebookMapper.selectByExample(null);
    }
//    ebookMapper.selectByExample(null);类似于 where. null 意味着select all
}
