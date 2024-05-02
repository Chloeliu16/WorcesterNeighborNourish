package com.worcester.neighbor.nourish.controller;

import com.worcester.neighbor.nourish.dto.request.LoginRequest;
import com.worcester.neighbor.nourish.dto.response.LoginResponse;
import com.worcester.neighbor.nourish.service.LoginService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountLoginTest {

    @Mock
    private LoginService loginService;

    @InjectMocks
    private AccountLogin accountLogin;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testLoginCustomerSuccess() {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("customer123");
        loginRequest.setPassword("password");
        loginRequest.setAccountType(1);

        when(loginService.loginCustomer("customer123", "password")).thenReturn("");

        LoginResponse actualResponse = accountLogin.login(loginRequest);

        assertEquals(true, actualResponse.isSuccess());
    }
}
