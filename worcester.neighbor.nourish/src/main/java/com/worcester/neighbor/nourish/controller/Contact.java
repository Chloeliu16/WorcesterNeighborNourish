package com.worcester.neighbor.nourish.controller;

import com.worcester.neighbor.nourish.dto.request.ContactRequest;
import com.worcester.neighbor.nourish.dto.request.DonationRequest;
import com.worcester.neighbor.nourish.dto.response.ContactResponse;
import com.worcester.neighbor.nourish.dto.response.DonationResponse;
import com.worcester.neighbor.nourish.service.ContactService;
import com.worcester.neighbor.nourish.service.DonationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contactus")
@CrossOrigin(origins = "*")
public class Contact {
    private final ContactService contactService;

    @Autowired
    public Contact(ContactService contactService) {
        this.contactService = contactService;
    }

    @PostMapping
    public ContactResponse contact(@RequestBody ContactRequest contactRequest) {
        ContactResponse contactResponse = new ContactResponse();
        String contactOutput = "No info!";

        if (contactRequest != null) {
            contactOutput = contactService.contactAdd(
                    contactRequest.getType(),
                    contactRequest.getEmail(),
                    contactRequest.getName(),
                    contactRequest.getDetail()
            );
        }
        if (contactOutput != "") {
            contactResponse.setSuccess(false);
            contactResponse.setFailureReason(contactOutput);
        }
        return contactResponse;
    }
}
