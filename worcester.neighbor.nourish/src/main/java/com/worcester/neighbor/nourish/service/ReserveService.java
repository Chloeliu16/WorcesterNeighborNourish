package com.worcester.neighbor.nourish.service;

import com.worcester.neighbor.nourish.dto.FoodInfo;
import com.worcester.neighbor.nourish.model.Food;
import com.worcester.neighbor.nourish.model.Restaurant;
import com.worcester.neighbor.nourish.repository.FoodRepository;
import com.worcester.neighbor.nourish.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReserveService {
    private final FoodRepository foodRepository;
    private final RestaurantRepository restaurantRepository;

    @Autowired
    public ReserveService(FoodRepository  foodRepository, RestaurantRepository restaurantRepository) {
        this.foodRepository = foodRepository;
        this.restaurantRepository = restaurantRepository;
    }

    public String reserveFood(
            String supplierUsername,
            int supplierType,
            String foodName,
            int reserveAmount
    ) {
        try {
            Food food = foodRepository.findBySupplierUsernameAndSupplierTypeAndFoodName(supplierUsername, supplierType, foodName);
            if (food == null || food.getAmount() < reserveAmount) {
                return "No food or not enough food available!";
            } else {
                food.setAmount(food.getAmount() - reserveAmount);
            }
            foodRepository.saveAndFlush(food);
            return "";
        }
        catch(Exception e) {
            e.printStackTrace();
            return "Reserve food failed!";
        }
    }
}
