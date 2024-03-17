package com.worcester.neighbor.nourish.controller;

import com.worcester.neighbor.nourish.dto.RegisterRequest;
import com.worcester.neighbor.nourish.dto.RegisterResponse;
import com.worcester.neighbor.nourish.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/register")
@CrossOrigin(origins = "*")
public class AccountRegister {
    private final RegisterService registerService;

    @Autowired
    public AccountRegister(RegisterService registerService) {this.registerService = registerService; }

    @GetMapping
    public RegisterResponse register(@RequestBody RegisterRequest registerRequest) {
        RegisterResponse registerResponse = new RegisterResponse();
        String registerOutput = "No registration info!";
        if (registerRequest != null) {
            if (registerRequest.getRestaurantId() != null) {
                registerOutput = registerService.registerRestaurant(
                        registerRequest.getRestaurantId(),
                        registerRequest.getRestaurantName(),
                        registerRequest.getPassword(),
                        registerRequest.getPhone(),
                        registerRequest.getAddress()
                );
            } else if (registerRequest.getUserId() != null) {
                registerOutput = registerService.registerUser(
                        registerRequest.getUserId(),
                        registerRequest.getUserName(),
                        registerRequest.getPassword(),
                        registerRequest.getPhone()
                );
            } else {
                registerOutput = "No id specified!";
            }
        }
        if (registerOutput != "") {
            registerResponse.setSuccess(false);
            registerResponse.setFailureReason(registerOutput);
        }
        return registerResponse;
    }
}
