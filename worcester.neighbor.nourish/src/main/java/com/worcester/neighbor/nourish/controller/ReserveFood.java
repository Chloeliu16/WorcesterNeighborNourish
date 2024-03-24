package com.worcester.neighbor.nourish.controller;

import com.worcester.neighbor.nourish.dto.FoodInfo;
import com.worcester.neighbor.nourish.dto.PostResponse;
import com.worcester.neighbor.nourish.dto.ReserveRequest;
import com.worcester.neighbor.nourish.dto.ReserveResponse;
import com.worcester.neighbor.nourish.service.PostService;
import com.worcester.neighbor.nourish.service.ReserveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reserve")
@CrossOrigin(origins = "*")
public class ReserveFood {
    private final ReserveService reserveService;

    @Autowired
    public ReserveFood(ReserveService reserveService) {
        this.reserveService = reserveService;
    }

    @PostMapping
    public ReserveResponse reserve(@RequestBody ReserveRequest reserveRequest) {
        ReserveResponse reserveResponse = new ReserveResponse();
        FoodInfo foodInfo = new FoodInfo();
        foodInfo.setRestName(reserveRequest.getRestName());
        foodInfo.setFoodType(reserveRequest.getFoodType());
        foodInfo.setFoodName(reserveRequest.getFoodName());
        foodInfo.setAmount(reserveRequest.getAmount());
        String reserveOutput = reserveService.reserveFood(foodInfo, reserveRequest.getUser());
        if (reserveOutput != "") {
            reserveResponse.setSuccess(false);
            reserveResponse.setFailureReason(reserveOutput);
        }
        return reserveResponse;
    }
}
