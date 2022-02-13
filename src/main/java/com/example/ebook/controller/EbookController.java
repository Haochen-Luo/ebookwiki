package com.example.ebook.controller;

import com.example.ebook.domain.Ebook;
import com.example.ebook.request.EbookRequest;
import com.example.ebook.resp.CommonResp;
import com.example.ebook.resp.EbookResp;
import com.example.ebook.service.EbookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/ebook")
public class EbookController {

    @Resource
    private EbookService ebookService;

    @GetMapping("/list")
    public CommonResp list(EbookRequest ebookRequest){
        CommonResp<List<EbookResp>> listCommonResp = new CommonResp<>();
        List<EbookResp> list = ebookService.list(ebookRequest);
        listCommonResp.setContent(list);
        return listCommonResp;

    }

}
