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

    public String reserveFood(FoodInfo foodInfo, String user) {
        try {
            String rname = foodInfo.getRestName();
            Restaurant rest = restaurantRepository.findByRestname(rname);
            String rusername = rest.getRestusername();
            Food food = foodRepository.findByRestusernameAndFoodtypeAndFoodname(rusername, foodInfo.getFoodType(), foodInfo.getFoodName());
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
