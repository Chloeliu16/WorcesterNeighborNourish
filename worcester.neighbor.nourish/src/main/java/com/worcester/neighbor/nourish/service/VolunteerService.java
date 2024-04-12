package com.worcester.neighbor.nourish.service;

import com.worcester.neighbor.nourish.model.Volunteer.Volunteer;
import com.worcester.neighbor.nourish.model.donation.Donation;
import com.worcester.neighbor.nourish.repository.Volunteer.VolunteerRepository;
import com.worcester.neighbor.nourish.repository.donation.DonationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VolunteerService {

    private final VolunteerRepository volunteerRepository;

    @Autowired
    public VolunteerService(VolunteerRepository volunteerRepository) {
        this.volunteerRepository = volunteerRepository;
    }

    public String volunteerAdd(
            String name,
            String age,
            String career,
            String email,
            String phone,
            String city,
            String zipcode,
            String availability)
    {
        try {
            Volunteer volunteer = new Volunteer();
            volunteer.setName(name);
            volunteer.setAge(age);
            volunteer.setCareer(career);
            volunteer.setEmail(email);
            volunteer.setPhone(phone);
            volunteer.setCity(city);
            volunteer.setZipcode(zipcode);
            volunteer.setAvailability(availability);
            volunteerRepository.saveAndFlush(volunteer);
            return "";
        } catch (Exception e) {
            e.printStackTrace();
            return "Donor Register Failed!";
        }
    }


}
