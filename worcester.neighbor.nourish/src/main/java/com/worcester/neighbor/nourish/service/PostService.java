package com.worcester.neighbor.nourish.service;

import com.worcester.neighbor.nourish.dto.FoodInfo;
import com.worcester.neighbor.nourish.model.Food;
import com.worcester.neighbor.nourish.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    private final FoodRepository foodRepository;

    @Autowired
    public PostService(FoodRepository  foodRepository) {
        this.foodRepository = foodRepository;
    }

    public boolean postFood(FoodInfo foodInfo) {
        try {
            Food food = foodRepository.findByRestusernameAndFoodtypeAndFoodname(foodInfo.getRestUserName(), foodInfo.getFoodType(), foodInfo.getFoodName());
            if (food != null) {
                int amount = food.getAmount();
                amount += foodInfo.getAmount();
                food.setAmount(amount);
            } else {
                food = new Food();
                food.setRestusername(foodInfo.getRestUserName());
                food.setFoodname(foodInfo.getFoodName());
                food.setFoodtype(foodInfo.getFoodType());
                food.setAmount(foodInfo.getAmount());
            }
            foodRepository.saveAndFlush(food);
            return true;
        }
        catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
