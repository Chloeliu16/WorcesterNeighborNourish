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

    public String postFood(
            String supplierUsername,
            int supplierType,
            String foodName,
            String foodType,
            String foodIngredients,
            int postAmount
    ) {
        try {
            Food food = foodRepository.findBySupplierUsernameAndSupplierTypeAndFoodName(supplierUsername, supplierType, foodName);
            if (food != null) {
                int amount = food.getAmount();
                amount += postAmount;
                food.setAmount(amount);
            } else {
                food = new Food();
                food.setSupplierUsername(supplierUsername);
                food.setSupplierType(supplierType);
                food.setFoodName(foodName);
                food.setFoodType(foodType);
                food.setFoodIngredients(foodIngredients);
                food.setAmount(postAmount);
            }
            foodRepository.saveAndFlush(food);
            return "";
        }
        catch(Exception e) {
            e.printStackTrace();
            return "Post food failed!";
        }
    }
}
