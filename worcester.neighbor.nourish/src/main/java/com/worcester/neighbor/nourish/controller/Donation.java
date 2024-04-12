package com.worcester.neighbor.nourish.controller;

import com.worcester.neighbor.nourish.dto.request.DonationRequest;
import com.worcester.neighbor.nourish.dto.request.RegisterRequest;
import com.worcester.neighbor.nourish.dto.response.DonationResponse;
import com.worcester.neighbor.nourish.dto.response.RegisterResponse;
import com.worcester.neighbor.nourish.service.DonationService;
import com.worcester.neighbor.nourish.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/donation")
@CrossOrigin(origins = "*")
public class Donation {
    private final DonationService donationService;

    @Autowired
    public Donation(DonationService donationService) {
        this.donationService = donationService;
    }

    @PostMapping
    public DonationResponse donation(@RequestBody DonationRequest donationRequest) {
        DonationResponse donationResponse = new DonationResponse();
        String donationOutput = "No donation info!";

        if (donationRequest != null) {
            donationOutput = donationService.donationAdd(
                    donationRequest.getDonorType(),
                    donationRequest.getName(),
                    donationRequest.getEmail(),
                    donationRequest.getPhone(),
                    donationRequest.getTypeOfDonatedFood(),
                    donationRequest.getQuantityOfDonations(),
                    donationRequest.getOther()
            );
        }
        if (donationOutput != "") {
            donationResponse.setSuccess(false);
            donationResponse.setFailureReason(donationOutput);
        }
        return donationResponse;
    }
}
