package com.worcester.neighbor.nourish.dto.response;

import com.worcester.neighbor.nourish.dto.base.OrderInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ViewOrderResponse {
    boolean success = true;
    List<OrderInfo> orders;
}
