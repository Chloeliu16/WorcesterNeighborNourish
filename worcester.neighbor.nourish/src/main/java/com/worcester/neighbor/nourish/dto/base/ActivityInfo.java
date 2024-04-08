package com.worcester.neighbor.nourish.dto.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActivityInfo {
    String orgUsername;
    // orgName is not required for PostActivityRequest.
    String orgName;
    String activityName;
    String address;
    String startTime;
    String endTime;
    String contactName;
    String contactPhone;
    String contactEmail;
}
