package com.worcester.neighbor.nourish.controller;

import com.worcester.neighbor.nourish.dto.request.ViewActivityRequest;
import com.worcester.neighbor.nourish.dto.request.ViewFoodRequest;
import com.worcester.neighbor.nourish.dto.request.ViewOrderRequest;
import com.worcester.neighbor.nourish.dto.response.*;
import com.worcester.neighbor.nourish.service.ViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class View {
    private final ViewService viewService;

    @Autowired
    public View(ViewService viewService) {
        this.viewService = viewService;
    }

    @GetMapping("/view")
    public ViewResponse view() {
        ViewResponse viewResponse = new ViewResponse();
        viewResponse.setFoods(viewService.viewFood());
        viewResponse.setActivities(viewService.viewActivity());
        if (viewResponse.getFoods() == null && viewResponse.getActivities() == null) {
            viewResponse.setSuccess(false);
        }
        return viewResponse;
    }

    @PostMapping("/vieworder")
    public ViewOrderResponse viewOrder(@RequestBody ViewOrderRequest viewOrderRequest) {
        System.out.println(viewOrderRequest);
        ViewOrderResponse viewOrderResponse = new ViewOrderResponse();
        if (viewOrderRequest.getCusUsername() != null) {
            viewOrderResponse.setOrders(viewService.viewCustomerOrders(viewOrderRequest.getCusUsername()));
        } else if (viewOrderRequest.getRestUsername() != null) {
            viewOrderResponse.setOrders(viewService.viewRestaurantOrders(viewOrderRequest.getRestUsername()));
        }
        return viewOrderResponse;
    }

    @PostMapping("/viewfood")
    public ViewFoodResponse viewFood(@RequestBody ViewFoodRequest viewFoodRequest) {
        ViewFoodResponse viewFoodResponse = new ViewFoodResponse();
        viewFoodResponse.setFoods(viewService.viewFood(viewFoodRequest.getRestUsername()));
        return viewFoodResponse;
    }

    @PostMapping("/viewactivity")
    public ViewActivityResponse viewActivity(@RequestBody ViewActivityRequest viewActivityRequest) {
        ViewActivityResponse viewActivityResponse = new ViewActivityResponse();
        viewActivityResponse.setActivities(viewService.viewActivity(viewActivityRequest.getOrgUsername()));
        return viewActivityResponse;
    }

    @GetMapping("/viewmaintenance")
    public ViewMaintenanceResponse viewMaintenacne() {
        ViewMaintenanceResponse viewMaintenanceResponse = new ViewMaintenanceResponse();
        viewMaintenanceResponse.setMaintenances(viewService.viewMaintenance());
        return viewMaintenanceResponse;
    }
}
