package com.worcester.neighbor.nourish.controller;


import com.worcester.neighbor.nourish.dto.request.PostActivityRequest;
import com.worcester.neighbor.nourish.dto.request.PostFeedbackRequest;
import com.worcester.neighbor.nourish.dto.request.PostFoodRequest;
import com.worcester.neighbor.nourish.dto.response.PostResponse;
import com.worcester.neighbor.nourish.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class Post {
    private final PostService postService;

    @Autowired
    public Post(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/postfood")
    public PostResponse post(@RequestBody PostFoodRequest postFoodRequest) {
        PostResponse postResponse = new PostResponse();
        String postOutput = "No post info!";
        if (postFoodRequest != null) {
            postOutput = postService.postFood(
                    postFoodRequest.getRestUsername(),
                    postFoodRequest.getFoodName(),
                    postFoodRequest.getFoodType(),
                    postFoodRequest.getFoodIngredients(),
                    postFoodRequest.getAmount()
            );
        }
        if (postOutput != "") {
            postResponse.setSuccess(false);
            postResponse.setFailureReason(postOutput);
        }
        return postResponse;
    }

    @PostMapping("/postactivity")
    public PostResponse post(@RequestBody PostActivityRequest postActivityRequest) {
        PostResponse postResponse = new PostResponse();
        String postOutput = "No post info!";
        if (postActivityRequest != null) {
            postOutput = postService.postActivity(
                    postActivityRequest.getActivity().getOrgUsername(),
                    postActivityRequest.getActivity().getActivityName(),
                    postActivityRequest.getActivity().getAddress(),
                    postActivityRequest.getActivity().getStartTime(),
                    postActivityRequest.getActivity().getEndTime(),
                    postActivityRequest.getActivity().getContactName(),
                    postActivityRequest.getActivity().getContactPhone(),
                    postActivityRequest.getActivity().getContactEmail()
            );
        }
        if (postOutput != "") {
            postResponse.setSuccess(false);
            postResponse.setFailureReason(postOutput);
        }
        return postResponse;
    }

    @PostMapping("/postfeedback")
    public PostResponse post(@RequestBody PostFeedbackRequest postFeedbackRequest) {
        PostResponse postResponse = new PostResponse();
        String postOutput = "No post info!";
        if (postFeedbackRequest != null) {
            postOutput = postService.postFeedback(
                    postFeedbackRequest.getCusUsername(),
                    postFeedbackRequest.getFeedback().getType(),
                    postFeedbackRequest.getFeedback().getInfo()
            );
        }
        if (postOutput != "") {
            postResponse.setSuccess(false);
            postResponse.setFailureReason(postOutput);
        }
        return postResponse;
    }
}
