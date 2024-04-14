package com.worcester.neighbor.nourish.repository.restaurant;

import com.worcester.neighbor.nourish.model.restaurant.Category;
import com.worcester.neighbor.nourish.model.restaurant.FoodOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{
    Category findByFoodtypeAndFoodingredients(String foodtype, String foodingredients);
    Category saveAndFlush(Category category);
}
