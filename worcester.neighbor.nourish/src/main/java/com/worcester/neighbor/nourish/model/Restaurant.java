package com.worcester.neighbor.nourish.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.IDENTITY;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Restaurant {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    // unique name for login
    String restaurantId;
    // complete name for display
    String restaurantName;
    String password;
    String phone;
    String address;
}
