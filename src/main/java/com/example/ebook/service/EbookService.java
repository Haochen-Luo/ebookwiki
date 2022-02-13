package com.example.ebook.service;

import com.example.ebook.domain.Ebook;
import com.example.ebook.domain.EbookExample;
import com.example.ebook.mapper.EbookMapper;
import com.example.ebook.request.EbookRequest;
import com.example.ebook.resp.EbookResp;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class EbookService {

    @Resource
    private EbookMapper ebookMapper;

// 原本是List<Ebook>
//    有了List<EbookResp>可以把List<Ebook>换成List<EbookResp>
//    public List<Ebook> list(EbookRequest ebookRequest){
    public List<EbookResp> list(EbookRequest ebookRequest){
        EbookExample ebookExample = new EbookExample();
//        Criteria 相当于 where条件
        EbookExample.Criteria criteria = ebookExample.createCriteria();
        criteria.andNameLike("%"+ebookRequest.getName()+"%");
        List<Ebook> ebookList = ebookMapper.selectByExample(ebookExample);
        List<EbookResp> respList = new ArrayList<>();
        for(Ebook ebook: ebookList){
            EbookResp ebookResp = new EbookResp();
            BeanUtils.copyProperties(ebook,ebookResp);
//            ebookResp.setId(1233L);
            respList.add(ebookResp);
        }

        return respList;
    }
//    ebookMapper.selectByExample(null);类似于 where. null 意味着select all
}
