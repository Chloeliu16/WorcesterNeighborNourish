package com.worcester.neighbor.nourish.controller;

import com.worcester.neighbor.nourish.dto.request.DonationRequest;
import com.worcester.neighbor.nourish.dto.response.DonationResponse;
import com.worcester.neighbor.nourish.service.DonationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DonationTest {

    @Mock
    private DonationService donationService;

    @InjectMocks
    private Donation donationController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testDonation() {
        DonationRequest donationRequest = new DonationRequest();
        donationRequest.setDonorType("Individual");
        donationRequest.setName("John Smith");
        donationRequest.setEmail("john@example.com");
        donationRequest.setPhone("1234567890");
        donationRequest.setTypeOfDonatedFood("Vegetables");
        donationRequest.setQuantityOfDonations("100kg");
        donationRequest.setOther("Urgent");

        when(donationService.donationAdd(
                "Individual",
                "John Smith",
                "john@example.com",
                "1234567890",
                "Vegetables",
                "100kg",
                "Urgent")).thenReturn("Donation processed successfully");

        DonationResponse donationResponse = donationController.donation(donationRequest);

        assertEquals(false, donationResponse.isSuccess());
        assertEquals("Donation processed successfully", donationResponse.getFailureReason());
    }
}
