package com.worcester.neighbor.nourish.service;

import com.worcester.neighbor.nourish.dto.FoodInfo;
import com.worcester.neighbor.nourish.model.Food;
import com.worcester.neighbor.nourish.model.Organization;
import com.worcester.neighbor.nourish.model.Restaurant;
import com.worcester.neighbor.nourish.repository.FoodRepository;
import com.worcester.neighbor.nourish.repository.OrganizationRepository;
import com.worcester.neighbor.nourish.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ViewService {
    private final FoodRepository foodRepository;
    private final RestaurantRepository restaurantRepository;
    private final OrganizationRepository organizationRepository;

    @Autowired
    public ViewService(FoodRepository  foodRepository, RestaurantRepository restaurantRepository, OrganizationRepository organizationRepository) {
        this.foodRepository = foodRepository;
        this.restaurantRepository = restaurantRepository;
        this.organizationRepository = organizationRepository;
    }

    public List<FoodInfo> viewFood() {
        try {
            List<Food> allFoods = this.foodRepository.findAll();
            List<FoodInfo> allFoodInfo = new ArrayList<>();
            for (Food food:allFoods) {
                int supplierType = food.getSupplierType();
                FoodInfo foodInfo = new FoodInfo(
                        food.getSupplierUsername(),
                        food.getSupplierType(),
                        "", // supplierName
                        "", // supplierPhone
                        "", // supplierEmail
                        "", // supplierAddress
                        food.getFoodName(),
                        food.getFoodType(),
                        food.getFoodIngredients(),
                        food.getAmount()
                );
                if (supplierType == 1) {
                    Restaurant rest = restaurantRepository.findByRestusername(food.getSupplierUsername());
                    foodInfo.setSupplierName(rest.getRestname());
                    foodInfo.setSupplierPhone(rest.getPhone());
                    foodInfo.setSupplierEmail(rest.getEmail());
                    foodInfo.setSupplierAddress(rest.getAddress());
                } else {
                    Organization org = organizationRepository.findByOrgusername(food.getSupplierUsername());
                    foodInfo.setSupplierName(org.getOrgname());
                    foodInfo.setSupplierPhone(org.getPhone());
                    foodInfo.setSupplierEmail(org.getEmail());
                    foodInfo.setSupplierAddress(org.getAddress());
                }
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
