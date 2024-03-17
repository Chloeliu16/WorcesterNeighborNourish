package com.worcester.neighbor.nourish.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ViewResponse {
    boolean success = true;
    List<FoodInfo> foods;
}
