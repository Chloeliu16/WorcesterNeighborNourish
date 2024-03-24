package com.worcester.neighbor.nourish.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodInfo {
    String restUserName;
    String restName;
    String address;
    String foodType;
    String foodName;
    int amount;
}
