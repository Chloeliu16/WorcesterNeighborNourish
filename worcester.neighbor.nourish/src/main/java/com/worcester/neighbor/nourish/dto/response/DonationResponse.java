package com.worcester.neighbor.nourish.dto.response;

import com.worcester.neighbor.nourish.dto.base.DonationInfo;
import com.worcester.neighbor.nourish.dto.base.FaqInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DonationResponse {
    boolean success = true;
    String failureReason;
}


