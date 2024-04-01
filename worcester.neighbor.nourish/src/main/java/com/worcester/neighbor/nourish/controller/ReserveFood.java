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
        String reserveOutput = "No reserve info!";
        if (reserveRequest != null) {
            reserveOutput = reserveService.reserveFood(
                    reserveRequest.getSupplierUsername(),
                    reserveRequest.getSupplierType(),
                    reserveRequest.getFoodName(),
                    reserveRequest.getAmount()
            );
        }
        if (reserveOutput != "") {
            reserveResponse.setSuccess(false);
            reserveResponse.setFailureReason(reserveOutput);
        }
        return reserveResponse;
    }
}
