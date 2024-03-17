package com.worcester.neighbor.nourish.service;

import com.worcester.neighbor.nourish.dto.FoodInfo;
import com.worcester.neighbor.nourish.model.Food;
import com.worcester.neighbor.nourish.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ViewService {
    private final FoodRepository foodRepository;

    @Autowired
    public ViewService(FoodRepository  foodRepository) {
        this.foodRepository = foodRepository;
    }
    public List<FoodInfo> viewFood() {
        try {
            List<Food> allFoods = this.foodRepository.findAll();
            List<FoodInfo> allFoodInfo = new ArrayList<>();
            for (Food food:allFoods) {
                FoodInfo foodInfo = new FoodInfo(food.getRestaurant(), food.getRestaurant(), food.getAmount());
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
