package com.worcester.neighbor.nourish.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReserveRequest {
    String restUsername;
    String cusUsername;
    String foodName;
    int amount;
}
