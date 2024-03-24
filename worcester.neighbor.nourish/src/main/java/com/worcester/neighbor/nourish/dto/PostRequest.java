package com.worcester.neighbor.nourish.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostRequest {
    String restUserName;
    String restName;
    String foodName;
    String foodType;
    int amount;
}
