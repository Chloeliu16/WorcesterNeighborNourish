package com.worcester.neighbor.nourish.controller;

import com.worcester.neighbor.nourish.dto.request.LoginRequest;
import com.worcester.neighbor.nourish.dto.response.LoginResponse;
import com.worcester.neighbor.nourish.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
@CrossOrigin(origins = "*")//all domains are allowed
public class AccountLogin {
    private final LoginService loginService;

    @Autowired
    public AccountLogin(LoginService loginService) { this.loginService = loginService; }

    @PostMapping
    public LoginResponse login(@RequestBody LoginRequest loginRequest) {
        LoginResponse loginResponse = new LoginResponse();
        String loginOutput = "No login info!";
        if (loginRequest != null) {
            if (loginRequest.getAccountType() == 1) {
                loginOutput = loginService.loginCustomer(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                );
            } else if (loginRequest.getAccountType() == 2) {
                loginOutput = loginService.loginRestaurant(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                );
            } else if (loginRequest.getAccountType() == 3) {
                loginOutput = loginService.loginOrgnization(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                );
            } else {
                loginOutput = "Wrong account type!";
            }
        }
        if (loginOutput != "") {
            loginResponse.setSuccess(false);
            loginResponse.setFailureReason(loginOutput);
        }
        return loginResponse;
    }
}
