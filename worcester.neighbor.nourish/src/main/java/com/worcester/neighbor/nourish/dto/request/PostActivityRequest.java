package com.worcester.neighbor.nourish.dto.request;

import com.worcester.neighbor.nourish.dto.base.ActivityInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostActivityRequest {
    ActivityInfo activity;
}
