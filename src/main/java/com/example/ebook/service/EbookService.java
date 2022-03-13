package com.example.ebook.service;

import com.example.ebook.domain.Ebook;
import com.example.ebook.domain.EbookExample;
import com.example.ebook.mapper.EbookMapper;
import com.example.ebook.request.EbookRequest;
import com.example.ebook.resp.EbookResp;
import com.example.ebook.resp.PageResp;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class EbookService {

    @Resource
    private EbookMapper ebookMapper;

    private static final Logger LOG = LoggerFactory.getLogger(EbookService.class);
// 原本是List<Ebook>
//    有了List<EbookResp>可以把List<Ebook>换成List<EbookResp>
//    public List<Ebook> list(EbookRequest ebookRequest){
    public  PageResp<EbookResp> list(EbookRequest ebookRequest){



        EbookExample ebookExample = new EbookExample();
//        Criteria 相当于 where条件
        EbookExample.Criteria criteria = ebookExample.createCriteria();
        if(!ObjectUtils.isEmpty(ebookRequest.getName())){
        criteria.andNameLike("%"+ebookRequest.getName()+"%");}


        List<Ebook> ebookList = ebookMapper.selectByExample(ebookExample);


        PageHelper.startPage(1, 3);
        PageInfo<Ebook> pageInfo = new PageInfo<>(ebookList);
        LOG.info("总行数：{}", pageInfo.getTotal());
        LOG.info("总页数：{}", pageInfo.getPages());


        List<EbookResp> respList = new ArrayList<>();
        for(Ebook ebook: ebookList){
            EbookResp ebookResp = new EbookResp();
            BeanUtils.copyProperties(ebook,ebookResp);
//            ebookResp.setId(1233L);

            respList.add(ebookResp);
        }

        PageResp<EbookResp> pageResp = new PageResp();
        pageResp.setTotal(pageInfo.getTotal());
        pageResp.setList(respList);

        return pageResp;


    }
//    ebookMapper.selectByExample(null);类似于 where. null 意味着select all
}
