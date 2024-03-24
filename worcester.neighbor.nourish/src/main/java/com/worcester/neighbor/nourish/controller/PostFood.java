package com.worcester.neighbor.nourish.controller;


import com.worcester.neighbor.nourish.dto.FoodInfo;
import com.worcester.neighbor.nourish.dto.PostRequest;
import com.worcester.neighbor.nourish.dto.PostResponse;
import com.worcester.neighbor.nourish.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/post")
@CrossOrigin(origins = "*")
public class PostFood {
    private final PostService postService;

    @Autowired
    public PostFood(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public PostResponse post(@RequestBody PostRequest postRequest) {
        PostResponse postResponse = new PostResponse();
        FoodInfo foodInfo = new FoodInfo();
        System.out.println("restaurant name: " + postRequest.getRestName());
        foodInfo.setRestName(postRequest.getRestName());
        foodInfo.setRestUserName(postRequest.getRestUserName());
        foodInfo.setFoodName(postRequest.getFoodName());
        foodInfo.setFoodType(postRequest.getFoodType());
        foodInfo.setAmount(postRequest.getAmount());
        postResponse.setSuccess(postService.postFood(foodInfo));
        return postResponse;
    }
}
