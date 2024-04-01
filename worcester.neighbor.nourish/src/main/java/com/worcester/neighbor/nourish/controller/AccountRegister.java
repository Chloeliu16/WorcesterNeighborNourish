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

    @PostMapping
    public RegisterResponse register(@RequestBody RegisterRequest registerRequest) {
        RegisterResponse registerResponse = new RegisterResponse();
        String registerOutput = "No registration info!";

        if (registerRequest != null) {
            if (registerRequest.getAccountType() == 1) {
                registerOutput = registerService.registerCustomer(
                        registerRequest.getUsername(),
                        registerRequest.getName(),
                        registerRequest.getPassword(),
                        registerRequest.getPhone(),
                        registerRequest.getEmail()
                );
            } else if (registerRequest.getAccountType() == 2) {
                registerOutput = registerService.registerRestaurant(
                        registerRequest.getUsername(),
                        registerRequest.getName(),
                        registerRequest.getPassword(),
                        registerRequest.getPhone(),
                        registerRequest.getEmail(),
                        registerRequest.getAddress(),
                        registerRequest.getCertificate()
                );
            } else if (registerRequest.getAccountType() == 3) {
                registerOutput = registerService.registerOrganization(
                        registerRequest.getUsername(),
                        registerRequest.getName(),
                        registerRequest.getPassword(),
                        registerRequest.getPhone(),
                        registerRequest.getEmail(),
                        registerRequest.getAddress()
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
