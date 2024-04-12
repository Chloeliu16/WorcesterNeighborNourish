package com.worcester.neighbor.nourish.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VolunteerResponse {
    boolean success = true;
    String failureReason;
}
