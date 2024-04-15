package com.worcester.neighbor.nourish.controller;

import com.worcester.neighbor.nourish.dto.request.DonationRequest;
import com.worcester.neighbor.nourish.dto.request.VolunteerRequest;
import com.worcester.neighbor.nourish.dto.response.DonationResponse;
import com.worcester.neighbor.nourish.dto.response.VolunteerResponse;
import com.worcester.neighbor.nourish.service.DonationService;
import com.worcester.neighbor.nourish.service.VolunteerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/volunteer")
@CrossOrigin(origins = "*")
public class Volunteer {
    private final VolunteerService volunteerService;

    @Autowired
    public Volunteer(VolunteerService volunteerService) {
        this.volunteerService = volunteerService;
    }

    @PostMapping
    public VolunteerResponse volunteerRegister(@RequestBody VolunteerRequest volunteerRequest) {
        System.out.println("Hello, world!");
        System.out.println(volunteerRequest);
        VolunteerResponse volunteerResponse = new VolunteerResponse();
        String volunteerOutput = "No volunteer info!";

        if (volunteerRequest != null) {
            volunteerOutput = volunteerService.volunteerAdd(
                    volunteerRequest.getName(),
                    volunteerRequest.getAge(),
                    volunteerRequest.getCareer(),
                    volunteerRequest.getEmail(),
                    volunteerRequest.getPhone(),
                    volunteerRequest.getCity(),
                    volunteerRequest.getZipcode(),
                    volunteerRequest.getAvailability()
            );
        }
        if (volunteerOutput != "") {
            volunteerResponse.setSuccess(false);
            volunteerResponse.setFailureReason(volunteerOutput);
        }
        return volunteerResponse;
    }
}
