package com.worcester.neighbor.nourish.dto.request;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    String username;
    String name;
    String password;
    String phone;
    String email;
    // For restaurant and organization
    String address;
    // For restaurant
    String certificate;
    int accountType;
}

