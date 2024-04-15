package com.worcester.neighbor.nourish.service;

import com.worcester.neighbor.nourish.model.faqs.FaqContact;
import com.worcester.neighbor.nourish.repository.faqs.FaqContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactService {
    private final FaqContactRepository faqContactRepository;

    @Autowired
    public ContactService(FaqContactRepository faqContactRepository) {
        this.faqContactRepository = faqContactRepository;
    }

    public String contactAdd(
            String type,
            String email,
            String name,
            String detail)
    {
        try {
            FaqContact faqContact = new FaqContact();
            faqContact.setType(type);
            faqContact.setEmail(email);
            faqContact.setName(name);
            faqContact.setDetail(detail);
            faqContactRepository.saveAndFlush(faqContact);
            return "";
        } catch (Exception e) {
            e.printStackTrace();
            return "Information input failed.";
        }
    }
}
