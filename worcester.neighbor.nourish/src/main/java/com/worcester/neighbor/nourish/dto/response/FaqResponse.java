package com.worcester.neighbor.nourish.dto.response;

import com.worcester.neighbor.nourish.dto.base.FaqInfo;
import com.worcester.neighbor.nourish.dto.base.FoodInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FaqResponse {
    boolean success = true;
    List<FaqInfo> faqs;
}
