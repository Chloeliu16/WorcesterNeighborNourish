package com.worcester.neighbor.nourish.service;

import com.worcester.neighbor.nourish.dto.base.FaqInfo;
import com.worcester.neighbor.nourish.dto.base.FoodInfo;
import com.worcester.neighbor.nourish.model.faqs.Faq;
import com.worcester.neighbor.nourish.model.restaurant.Food;
import com.worcester.neighbor.nourish.repository.faqs.FaqRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FaqService {
    @Autowired
    private FaqRepository faqRepository;

    public  List<FaqInfo> showFAQs() {
        List<FaqInfo> allFaqInfo = new ArrayList<>();
        List<Faq> faqs = faqRepository.findAll();
        for(Faq faq: faqs) {
            FaqInfo faqInfo = new FaqInfo(
                faq.getId(),
                faq.getQuestion(),
                faq.getAnswer()
            );
            allFaqInfo.add(faqInfo);
        }
        return allFaqInfo;
    }
}
