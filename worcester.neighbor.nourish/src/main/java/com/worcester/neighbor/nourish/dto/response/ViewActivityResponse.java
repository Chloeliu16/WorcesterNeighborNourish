package com.worcester.neighbor.nourish.dto.response;

import com.worcester.neighbor.nourish.dto.base.ActivityInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ViewActivityResponse {
    boolean success = true;
    List<ActivityInfo> activities;
}
