package com.worcester.neighbor.nourish.service;

import com.worcester.neighbor.nourish.model.donation.Donation;
import com.worcester.neighbor.nourish.repository.donation.DonationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.ArgumentMatchers.any;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doThrow;

public class DonationServiceTest {

    @Mock
    private DonationRepository donationRepository;

    @InjectMocks
    private DonationService donationService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testDonationAddSuccess() {

        String donorType = "Individual";
        String name = "John Doe";
        String email = "john.doe@example.com";
        String phone = "1234567890";
        String typeOfDonatedFood = "Canned Goods";
        String quantityOfDonations = "100 cans";
        String other = "Urgent";

        Donation mockDonation = new Donation();
        mockDonation.setDonorType(donorType);
        mockDonation.setName(name);
        mockDonation.setEmail(email);
        mockDonation.setPhone(phone);
        mockDonation.setTypeOfdonatedFood(typeOfDonatedFood);
        mockDonation.setQuantityOfDonations(quantityOfDonations);
        mockDonation.setOther(other);

        when(donationRepository.saveAndFlush(any(Donation.class))).thenReturn(mockDonation);

        String result = donationService.donationAdd(donorType, name, email, phone, typeOfDonatedFood, quantityOfDonations, other);

        assertEquals("", result, "The result should be an empty string indicating success.");
        verify(donationRepository).saveAndFlush(any(Donation.class));
    }

    @Test
    public void testDonationAddFailure() {

        String donorType = "Individual";
        String name = "Jane Doe";
        String email = "jane.doe@example.com";
        String phone = "0987654321";
        String typeOfDonatedFood = "Fresh Produce";
        String quantityOfDonations = "50 lbs";
        String other = "Non-urgent";

        doThrow(new RuntimeException("Database Error")).when(donationRepository).saveAndFlush(any(Donation.class));

        String result = donationService.donationAdd(donorType, name, email, phone, typeOfDonatedFood, quantityOfDonations, other);

        assertEquals("Donor Register Failed!", result, "The result should indicate a failure to register the donor.");
    }
}
