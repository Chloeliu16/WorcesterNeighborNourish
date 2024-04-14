package com.worcester.neighbor.nourish.service;

import com.worcester.neighbor.nourish.dto.base.ActivityInfo;
import com.worcester.neighbor.nourish.dto.base.FoodInfo;
import com.worcester.neighbor.nourish.dto.base.MaintenanceInfo;
import com.worcester.neighbor.nourish.dto.base.OrderInfo;
import com.worcester.neighbor.nourish.model.Maintenance.Maintenance;
import com.worcester.neighbor.nourish.model.organization.Activity;
import com.worcester.neighbor.nourish.model.restaurant.Food;
import com.worcester.neighbor.nourish.model.restaurant.FoodOrder;
import com.worcester.neighbor.nourish.repository.MaintenanceRepository;
import com.worcester.neighbor.nourish.repository.organization.InfoRepository;
import com.worcester.neighbor.nourish.repository.restaurant.FoodOrderRepository;
import com.worcester.neighbor.nourish.repository.restaurant.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ViewService {
    private final FoodRepository foodRepository;
    private final InfoRepository infoRepository;
    private final FoodOrderRepository foodOrderRepository;
    private final MaintenanceRepository maintenanceRepository;

    @Autowired
    public ViewService(
            FoodRepository  foodRepository,
            InfoRepository infoRepository,
            FoodOrderRepository foodOrderRepository,
            MaintenanceRepository maintenanceRepository
    ) {
        this.foodRepository = foodRepository;
        this.infoRepository = infoRepository;
        this.foodOrderRepository = foodOrderRepository;
        this.maintenanceRepository = maintenanceRepository;
    }

    private List<FoodInfo> parseFood(List<Food> foods) {
        List<FoodInfo> allFoodInfo = new ArrayList<>();
        for (Food food:foods) {
            FoodInfo foodInfo = new FoodInfo(
                    food.getRestUsername(),
                    food.getRestaurant().getRestname(),
                    food.getRestaurant().getPhone(),
                    food.getRestaurant().getEmail(),
                    food.getRestaurant().getAddress(),
                    food.getFoodName(),
                    food.getCategory().getFoodtype(),
                    food.getCategory().getFoodingredients(),
                    food.getAmount()
            );
            allFoodInfo.add(foodInfo);
        }
        return allFoodInfo;
    }

    public List<FoodInfo> viewFood() {
        try {
            List<Food> allFoods = this.foodRepository.findAll();
            return parseFood(allFoods);
        }
        catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<FoodInfo> viewFood(String restUsername) {
        try {
            List<Food> allFoods = this.foodRepository.findByRestUsername(restUsername);
            return parseFood(allFoods);
        }
        catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private List<ActivityInfo> parseActivity(List<Activity> activities) {
        List<ActivityInfo> allActivityInfo = new ArrayList<>();
        for (Activity activity :activities) {
            ActivityInfo activityInfo = new ActivityInfo(
                    activity.getOrgUsername(),
                    activity.getOrganization().getOrgname(),
                    activity.getActivityName(),
                    activity.getDetail().getAddress(),
                    activity.getDetail().getStartTime(),
                    activity.getDetail().getEndTime(),
                    activity.getContact().getName(),
                    activity.getContact().getPhone(),
                    activity.getContact().getEmail()
            );
            allActivityInfo.add(activityInfo);
        }
        return allActivityInfo;
    }
    public List<ActivityInfo> viewActivity() {
        try {
            List<Activity> allActivities = this.infoRepository.findAll();
            return parseActivity(allActivities);
        }
        catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<ActivityInfo> viewActivity(String orgUsername) {
        try {
            List<Activity> allActivities = this.infoRepository.findByOrgUsername(orgUsername);
            return parseActivity(allActivities);
        }
        catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private List<OrderInfo> parseFoodOrder(List<FoodOrder> orders) {
        List<OrderInfo> out = new ArrayList<>();
        for (FoodOrder order:orders) {
            OrderInfo orderInfo = new OrderInfo();
            orderInfo.setOrderNum(order.getOrderNum());
            orderInfo.setCusName(order.getCustomer().getCusname());
            orderInfo.setRestName(order.getRestaurant().getRestname());
            orderInfo.setFoodName(order.getFoodName());
            orderInfo.setAmount(order.getAmount());
            orderInfo.setStatus(order.getStatus().getOrderStatus());
            out.add(orderInfo);
        }
        return out;
    }
    public List<OrderInfo> viewCustomerOrders(
            String cusUsername
    ) {
        try {
            List<FoodOrder> allOrders = this.foodOrderRepository.findByCusUsername(cusUsername);
            return parseFoodOrder(allOrders);
        }
        catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<OrderInfo> viewRestaurantOrders(
            String restUsername
    ) {
        try {
            List<FoodOrder> allOrders = this.foodOrderRepository.findByRestUsername(restUsername);
            return parseFoodOrder(allOrders);
        }
        catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<MaintenanceInfo> viewMaintenance() {
        try {
            List<Maintenance> allMaintenance = this.maintenanceRepository.findAll();
            List<MaintenanceInfo> allMaintenanceInfo = new ArrayList<>();
            for (Maintenance maintenance:allMaintenance) {
                MaintenanceInfo tmp = new MaintenanceInfo();
                tmp.setName(maintenance.getName());
                tmp.setPhone(maintenance.getPhone());
                tmp.setEmail(maintenance.getEmail());
                tmp.setResponsibility(maintenance.getResponsibility());
                allMaintenanceInfo.add(tmp);
            }
            return allMaintenanceInfo;
        }
        catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
