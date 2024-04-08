package com.worcester.neighbor.nourish.dto.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodInfo {
    String restUsername;
    String restName;
    String restPhone;
    String restEmail;
    String restAddress;
    String foodName;
    String foodType;
    String foodIngredients;
    int amount;
}
