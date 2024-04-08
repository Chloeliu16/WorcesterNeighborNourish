package com.worcester.neighbor.nourish.repository.restaurant;

import com.worcester.neighbor.nourish.model.restaurant.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {
    List<Food> findAll();
    List<Food> findByRestUsername(String restUsername);
    Food findByRestUsernameAndFoodName(String restUsername, String foodName);
    Food saveAndFlush(Food food);
}
