package com.worcester.neighbor.nourish.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DonationRequest {
    String donorType;
    String name;
    String email;
    String phone;
    String typeOfDonatedFood;
    String quantityOfDonations;
    String other;
}