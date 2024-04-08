package com.worcester.neighbor.nourish.dto.request;

import com.worcester.neighbor.nourish.dto.base.FeedbackInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostFeedbackRequest {
    String cusUsername;
    FeedbackInfo feedback;
}
