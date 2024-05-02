package com.worcester.neighbor.nourish.controller;

import com.worcester.neighbor.nourish.dto.request.RegisterRequest;
import com.worcester.neighbor.nourish.dto.response.RegisterResponse;
import com.worcester.neighbor.nourish.service.RegisterService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountRegisterTest {

    @Mock
    private RegisterService registerService;

    @InjectMocks
    private AccountRegister accountRegister;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testRegisterCustomerSuccess() {
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setUsername("newUser");
        registerRequest.setName("John");
        registerRequest.setPassword("strongpassword");
        registerRequest.setPhone("1234567890");
        registerRequest.setEmail("johndoe@example.com");
        registerRequest.setAccountType(1);

        RegisterResponse expectedResponse = new RegisterResponse();
        expectedResponse.setSuccess(true);
        expectedResponse.setFailureReason("");

        when(registerService.registerCustomer("newUser", "John", "strongpassword", "1234567890", "johndoe@example.com")).thenReturn("");

        RegisterResponse actualResponse = accountRegister.register(registerRequest);

        assertEquals(true, actualResponse.isSuccess());
    }
}
