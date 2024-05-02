package com.worcester.neighbor.nourish.service;

import com.worcester.neighbor.nourish.model.restaurant.Food;
import com.worcester.neighbor.nourish.model.restaurant.ReserveFood;
import com.worcester.neighbor.nourish.repository.customer.CustomerRepository;
import com.worcester.neighbor.nourish.repository.restaurant.FoodRepository;
import com.worcester.neighbor.nourish.repository.restaurant.ReserveFoodRepository;
import com.worcester.neighbor.nourish.repository.restaurant.RestaurantRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class ReserveServiceTest {

    @Mock
    private FoodRepository foodRepository;
    @Mock
    private ReserveFoodRepository reserveFoodRepository;
    @Mock
    private RestaurantRepository restaurantRepository;
    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private ReserveService reserveService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testReserveFood_EnoughFoodAvailable() {
        String restUsername = "testRestaurant";
        String cusUsername = "testCustomer";
        String foodName = "Pizza";
        int reserveAmount = 2;

        Food food = new Food();
        food.setAmount(5); // More than reserveAmount

        when(foodRepository.findByRestUsernameAndFoodName(restUsername, foodName)).thenReturn(food);

        String result = reserveService.reserveFood(restUsername, cusUsername, foodName, reserveAmount);
        assertEquals("Success", result);
        verify(foodRepository).saveAndFlush(food);
        verify(reserveFoodRepository).saveAndFlush(any(ReserveFood.class));
    }
    @Test
    public void testReserveFood_ExceptionHandling() {
        String restUsername = "testRestaurant";
        String cusUsername = "testCustomer";
        String foodName = "Pizza";
        int reserveAmount = 5;

        when(foodRepository.findByRestUsernameAndFoodName(restUsername, foodName)).thenThrow(new RuntimeException("Database error"));

        String result = reserveService.reserveFood(restUsername, cusUsername, foodName, reserveAmount);
        assertEquals("Reserve food failed!", result);
    }
}
