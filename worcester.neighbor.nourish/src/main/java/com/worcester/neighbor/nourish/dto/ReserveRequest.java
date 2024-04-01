package com.worcester.neighbor.nourish.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReserveRequest {
    String supplierUsername;
    // 1 for restaurant, 2 for organization
    int supplierType;

    String cusUsername;

    String foodName;
    int amount;
}
