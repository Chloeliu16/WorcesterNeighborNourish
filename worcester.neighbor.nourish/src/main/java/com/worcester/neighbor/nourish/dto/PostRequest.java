package com.worcester.neighbor.nourish.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostRequest {
    String supplierUsername;
    // 1 for restaurant, 2 for organization
    int supplierType;

    String foodName;
    String foodType;
    String foodIngredients;
    int amount;
}
