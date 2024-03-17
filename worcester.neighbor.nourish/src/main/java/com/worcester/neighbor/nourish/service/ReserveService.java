package com.worcester.neighbor.nourish.service;

import com.worcester.neighbor.nourish.dto.FoodInfo;
import com.worcester.neighbor.nourish.model.Food;
import com.worcester.neighbor.nourish.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReserveService {
    private final FoodRepository foodRepository;

    @Autowired
    public ReserveService(FoodRepository  foodRepository) {
        this.foodRepository = foodRepository;
    }

    public String reserveFood(FoodInfo foodInfo, String user) {
        try {
            Food food = foodRepository.findByRestaurantAndFood(foodInfo.getRestaurant(), foodInfo.getFood());
            if (food == null || food.getAmount() < foodInfo.getAmount()) {
                return "No food or not enough food available!";
            } else {
                food.setAmount(food.getAmount() - foodInfo.getAmount());
            }
            foodRepository.saveAndFlush(food);
            return "";
        }
        catch(Exception e) {
            e.printStackTrace();
            return "ReserveFood Failed!";
        }
    }
}
