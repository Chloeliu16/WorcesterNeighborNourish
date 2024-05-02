package com.worcester.neighbor.nourish.controller;

import com.worcester.neighbor.nourish.dto.request.ReserveRequest;
import com.worcester.neighbor.nourish.dto.response.ReserveResponse;
import com.worcester.neighbor.nourish.service.ReserveService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class ReserveFoodTest {

    @Mock
    private ReserveService reserveService;

    @InjectMocks
    private ReserveFood reserveFoodController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testReserveFood() {
        ReserveRequest reserveRequest = new ReserveRequest();
        reserveRequest.setRestUsername("restUser");
        reserveRequest.setCusUsername("cusUser");
        reserveRequest.setFoodName("Pasta");
        reserveRequest.setAmount(2);

        when(reserveService.reserveFood("restUser", "cusUser", "Pasta", 2)).thenReturn("Success");

        ReserveResponse reserveResponse = reserveFoodController.reserve(reserveRequest);

        assertTrue(reserveResponse.isSuccess());
    }
}
