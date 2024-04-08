package com.worcester.neighbor.nourish.controller;

import com.worcester.neighbor.nourish.dto.request.ReserveRequest;
import com.worcester.neighbor.nourish.dto.response.ReserveResponse;
import com.worcester.neighbor.nourish.service.ReserveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class ReserveFood {
    private final ReserveService reserveService;

    @Autowired
    public ReserveFood(ReserveService reserveService) {
        this.reserveService = reserveService;
    }

    @PostMapping("/reserve")
    public ReserveResponse reserve(@RequestBody ReserveRequest reserveRequest) {
        ReserveResponse reserveResponse = new ReserveResponse();
        String reserveOutput = "No reserve info!";
        if (reserveRequest != null) {
            reserveOutput = reserveService.reserveFood(
                    reserveRequest.getRestUsername(),
                    reserveRequest.getCusUsername(),
                    reserveRequest.getFoodName(),
                    reserveRequest.getAmount()
            );
        }
        if (reserveOutput != "Success") {
            reserveResponse.setSuccess(false);
            reserveResponse.setFailureReason(reserveOutput);
        }
        return reserveResponse;
    }
}
