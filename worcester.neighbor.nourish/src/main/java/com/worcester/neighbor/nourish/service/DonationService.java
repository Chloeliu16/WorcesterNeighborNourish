package com.worcester.neighbor.nourish.service;

import com.worcester.neighbor.nourish.model.donation.Donation;
import com.worcester.neighbor.nourish.model.restaurant.Restaurant;
import com.worcester.neighbor.nourish.repository.customer.CustomerRepository;
import com.worcester.neighbor.nourish.repository.donation.DonationRepository;
import com.worcester.neighbor.nourish.repository.organization.OrganizationRepository;
import com.worcester.neighbor.nourish.repository.restaurant.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DonationService {
    private final DonationRepository donationRepository;

    @Autowired
    public DonationService(DonationRepository donationRepository) {
        this.donationRepository = donationRepository;
    }

    public String donationAdd(
            String donorType,
            String name,
            String email,
            String phone,
            String typeOfDonatedFood,
            String quantityOfDonations,
            String other) {
        try {
            Donation donor = new Donation();
            donor.setDonorType(donorType);
            donor.setName(name);
            donor.setEmail(email);
            donor.setPhone(phone);
            donor.setTypeOfdonatedFood(typeOfDonatedFood);
            donor.setQuantityOfDonations(quantityOfDonations);
            donor.setOther(other);
            donationRepository.saveAndFlush(donor);
            return "";
        } catch (Exception e) {
            e.printStackTrace();
            return "Donor Register Failed!";
        }
    }
}
