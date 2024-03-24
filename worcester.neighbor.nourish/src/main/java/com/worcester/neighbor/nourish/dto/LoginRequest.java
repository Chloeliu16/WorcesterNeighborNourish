package com.worcester.neighbor.nourish.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {
    String password;
    String userNameId;
    // 1 for restaurant, 2 for user, 3 for organization
    int accountType;
}
