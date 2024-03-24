package com.worcester.neighbor.nourish.service;

import com.worcester.neighbor.nourish.dto.FoodInfo;
import com.worcester.neighbor.nourish.model.Food;
import com.worcester.neighbor.nourish.model.Restaurant;
import com.worcester.neighbor.nourish.repository.FoodRepository;
import com.worcester.neighbor.nourish.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ViewService {
    private final FoodRepository foodRepository;
    private final RestaurantRepository restaurantRepository;

    @Autowired
    public ViewService(FoodRepository  foodRepository, RestaurantRepository restaurantRepository) {
        this.foodRepository = foodRepository;
        this.restaurantRepository = restaurantRepository;
    }

    public List<FoodInfo> viewFood() {
        try {
            List<Food> allFoods = this.foodRepository.findAll();
            List<FoodInfo> allFoodInfo = new ArrayList<>();
            for (Food food:allFoods) {
                String restUserName = food.getRestusername();
                Restaurant rest = restaurantRepository.findByRestusername(restUserName);
                String rName = rest.getRestname();
                String address = rest.getAddress();
                FoodInfo foodInfo = new FoodInfo(restUserName, rName, address, food.getFoodtype(), food.getFoodname(), food.getAmount());
                allFoodInfo.add(foodInfo);
            }
            return allFoodInfo;
        }
        catch(Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
