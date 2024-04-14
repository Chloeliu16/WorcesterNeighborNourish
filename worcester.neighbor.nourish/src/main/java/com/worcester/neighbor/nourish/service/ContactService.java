package com.worcester.neighbor.nourish.service;

import com.worcester.neighbor.nourish.model.donation.Donation;
import com.worcester.neighbor.nourish.model.faqs.ContactHistory;
import com.worcester.neighbor.nourish.repository.donation.DonationRepository;
import com.worcester.neighbor.nourish.repository.faqs.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactService {
    private final ContactRepository contactRepository;

    @Autowired
    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public String contactAdd(
            String type,
            String email,
            String name,
            String detail)
    {
        try {
            ContactHistory contactHistory = new ContactHistory();
            contactHistory.setType(type);
            contactHistory.setEmail(email);
            contactHistory.setName(name);
            contactHistory.setDetail(detail);
            contactRepository.saveAndFlush(contactHistory);
            return "";
        } catch (Exception e) {
            e.printStackTrace();
            return "Information input failed.";
        }
    }
}
