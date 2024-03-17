package com.worcester.neighbor.nourish.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RegisterRequest {
    String password;
    String phone;

    // Fields just for user
    String userId;
    String userName;

    // Fields just for restaurant
    String restaurantId;
    String restaurantName;
    String address;

    // Constructor just for user
    public RegisterRequest(
            String userId,
            String userName,
            String password,
            String phone
    ) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.phone = phone;
    }

    // Constructor just for restaurant
    public RegisterRequest(
            String restaurantId,
            String restaurantName,
            String password,
            String phone,
            String address
    ) {
        this.restaurantId = restaurantId;
        this.restaurantName = restaurantName;
        this.password = password;
        this.phone = phone;
        this.address = address;
    }
}

