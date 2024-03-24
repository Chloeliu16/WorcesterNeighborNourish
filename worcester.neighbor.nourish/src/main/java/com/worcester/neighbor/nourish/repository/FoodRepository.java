package com.worcester.neighbor.nourish.repository;

import com.worcester.neighbor.nourish.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {
    List<Food> findAll();
//    Food findByRusernameAndFoodtypeAndFoodname(String rusername, String foodtype, String foodname);
    Food findByRestusernameAndFoodtypeAndFoodname(String restusername, String foodtype, String foodname);
    Food saveAndFlush(Food food);
}
