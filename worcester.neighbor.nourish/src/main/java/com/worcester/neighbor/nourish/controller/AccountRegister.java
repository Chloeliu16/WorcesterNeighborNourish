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
            if (registerRequest.getRestUserName() != null) {
                registerOutput = registerService.registerRestaurant(
                        registerRequest.getRestUserName(),
                        registerRequest.getRestName(),
                        registerRequest.getPassword(),
                        registerRequest.getPhone(),
                        registerRequest.getAddress(),
                        registerRequest.getEmail()
                );
            } else if (registerRequest.getCusUserName() != null) {
                registerOutput = registerService.registerCustomer(
                        registerRequest.getCusUserName(),
                        registerRequest.getCusName(),
                        registerRequest.getPassword(),
                        registerRequest.getPhone(),
                        registerRequest.getEmail()
                );
            } else if (registerRequest.getOrgUserName() !=null) {
                registerOutput = registerService.registerOrganization(
                        registerRequest.getOrgUserName(),
                        registerRequest.getOrgName(),
                        registerRequest.getPassword(),
                        registerRequest.getType(),
                        registerRequest.getEmail(),
                        registerRequest.getCertificateNum()
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
