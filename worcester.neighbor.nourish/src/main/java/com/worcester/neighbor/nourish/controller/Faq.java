package com.worcester.neighbor.nourish.controller;

import com.worcester.neighbor.nourish.dto.response.FaqResponse;
import com.worcester.neighbor.nourish.service.FaqService;
import com.worcester.neighbor.nourish.service.ReserveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class Faq {
    private final FaqService faqService;
    @Autowired
    public Faq(FaqService faqService) {
        this.faqService = faqService;
    }
    @GetMapping("/faqs")
    public FaqResponse viewFAQ(){
        FaqResponse faqs = new FaqResponse();
        faqs.setFaqs(faqService.showFAQs());
        return faqs;
    }
}


