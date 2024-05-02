package com.worcester.neighbor.nourish.controller;

import com.worcester.neighbor.nourish.dto.base.ActivityInfo;
import com.worcester.neighbor.nourish.dto.base.FoodInfo;
import com.worcester.neighbor.nourish.dto.base.MaintenanceInfo;
import com.worcester.neighbor.nourish.dto.base.OrderInfo;
import com.worcester.neighbor.nourish.dto.request.ViewActivityRequest;
import com.worcester.neighbor.nourish.dto.request.ViewFoodRequest;
import com.worcester.neighbor.nourish.dto.request.ViewOrderRequest;
import com.worcester.neighbor.nourish.dto.response.*;
import com.worcester.neighbor.nourish.service.ViewService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

class ViewTest {
    @Mock
    ViewService viewService;
    @InjectMocks
    View view;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testView() {
        when(viewService.viewFood()).thenReturn(List.of(new FoodInfo("restUsername", "restName", "restPhone", "restEmail", "restAddress", "foodName", "foodType", "foodIngredients", 0)));
        when(viewService.viewActivity()).thenReturn(List.of(new ActivityInfo("orgUsername", "orgName", "activityName", "address", "startTime", "endTime", "contactName", "contactPhone", "contactEmail")));

        ViewResponse result = view.view();
        Assertions.assertEquals(new ViewResponse(true, List.of(new FoodInfo("restUsername", "restName", "restPhone", "restEmail", "restAddress", "foodName", "foodType", "foodIngredients", 0)), List.of(new ActivityInfo("orgUsername", "orgName", "activityName", "address", "startTime", "endTime", "contactName", "contactPhone", "contactEmail"))), result);
    }

    @Test
    void testViewOrder() {
        when(viewService.viewCustomerOrders(anyString())).thenReturn(List.of(new OrderInfo("orderNum", "cusName", "restName", "foodName", 0, "status")));
        when(viewService.viewRestaurantOrders(anyString())).thenReturn(List.of(new OrderInfo("orderNum", "cusName", "restName", "foodName", 0, "status")));

        ViewOrderResponse result = view.viewOrder(new ViewOrderRequest("cusUsername", "restUsername"));
        Assertions.assertEquals(new ViewOrderResponse(true, List.of(new OrderInfo("orderNum", "cusName", "restName", "foodName", 0, "status"))), result);
    }

    @Test
    void testViewFood() {
        when(viewService.viewFood(anyString())).thenReturn(List.of(new FoodInfo("restUsername", "restName", "restPhone", "restEmail", "restAddress", "foodName", "foodType", "foodIngredients", 0)));

        ViewFoodResponse result = view.viewFood(new ViewFoodRequest("restUsername"));
        Assertions.assertEquals(new ViewFoodResponse(true, List.of(new FoodInfo("restUsername", "restName", "restPhone", "restEmail", "restAddress", "foodName", "foodType", "foodIngredients", 0))), result);
    }

    @Test
    void testViewActivity() {
        when(viewService.viewActivity(anyString())).thenReturn(List.of(new ActivityInfo("orgUsername", "orgName", "activityName", "address", "startTime", "endTime", "contactName", "contactPhone", "contactEmail")));

        ViewActivityResponse result = view.viewActivity(new ViewActivityRequest("orgUsername"));
        Assertions.assertEquals(new ViewActivityResponse(true, List.of(new ActivityInfo("orgUsername", "orgName", "activityName", "address", "startTime", "endTime", "contactName", "contactPhone", "contactEmail"))), result);
    }

    @Test
    void testViewMaintenacne() {
        when(viewService.viewMaintenance()).thenReturn(List.of(new MaintenanceInfo("name", "email", "phone", "responsibility")));

        ViewMaintenanceResponse result = view.viewMaintenacne();
        Assertions.assertEquals(new ViewMaintenanceResponse(true, List.of(new MaintenanceInfo("name", "email", "phone", "responsibility"))), result);
    }
}
