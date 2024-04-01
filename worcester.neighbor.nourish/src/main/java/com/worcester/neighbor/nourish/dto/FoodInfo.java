package com.worcester.neighbor.nourish.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodInfo {
    String supplierUsername;
    int supplierType;
    String supplierName;
    String supplierPhone;
    String supplierEmail;
    String supplierAddress;
    String foodName;
    String foodType;
    String foodIngredients;
    int amount;
}
