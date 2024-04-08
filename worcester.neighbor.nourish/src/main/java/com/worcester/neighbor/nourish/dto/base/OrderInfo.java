package com.worcester.neighbor.nourish.dto.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderInfo {
    String orderNum;
    String cusName;
    String restName;
    String foodName;
    int amount;
    String status;
}
