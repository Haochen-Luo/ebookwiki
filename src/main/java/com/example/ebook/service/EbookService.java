package com.example.ebook.service;

import com.example.ebook.domain.Ebook;
import com.example.ebook.domain.EbookExample;
import com.example.ebook.mapper.EbookMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EbookService {

    @Resource
    private EbookMapper ebookMapper;

    public List<Ebook> list(String name){
        EbookExample ebookExample = new EbookExample();
//        Criteria 相当于 where条件
        EbookExample.Criteria criteria = ebookExample.createCriteria();
        criteria.andNameLike("%"+name+"%");
        return ebookMapper.selectByExample(ebookExample);
    }
//    ebookMapper.selectByExample(null);类似于 where. null 意味着select all
}
