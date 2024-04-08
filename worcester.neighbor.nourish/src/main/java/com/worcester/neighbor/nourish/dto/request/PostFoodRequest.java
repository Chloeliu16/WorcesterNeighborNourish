package com.worcester.neighbor.nourish.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostFoodRequest {
    String restUsername;
    String foodName;
    String foodType;
    String foodIngredients;
    int amount;
}
