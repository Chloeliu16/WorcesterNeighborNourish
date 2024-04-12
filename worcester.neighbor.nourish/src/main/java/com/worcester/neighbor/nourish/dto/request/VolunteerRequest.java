package com.worcester.neighbor.nourish.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VolunteerRequest {
    String name;
    String age;
    String career;
    String email;
    String phone;
    String city;
    String zipcode;
    String availability;
}
