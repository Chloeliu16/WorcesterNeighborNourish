package com.worcester.neighbor.nourish.service;

import com.worcester.neighbor.nourish.model.restaurant.Category;
import com.worcester.neighbor.nourish.model.restaurant.Food;
import com.worcester.neighbor.nourish.model.restaurant.Restaurant;
import com.worcester.neighbor.nourish.repository.restaurant.CategoryRepository;
import com.worcester.neighbor.nourish.repository.restaurant.FoodRepository;
import com.worcester.neighbor.nourish.repository.restaurant.RestaurantRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.ArgumentMatchers.any;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PostServiceTest {

    @Mock
    private RestaurantRepository restaurantRepository;
    @Mock
    private CategoryRepository categoryRepository;
    @Mock
    private FoodRepository foodRepository;

    @InjectMocks
    private PostService postService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testPostFood() {
        String restUsername = "restUser";
        String foodName = "Pizza";
        String foodType = "Italian";
        String foodIngredients = "Cheese, Tomato Sauce";
        int postAmount = 10;

        Category category = new Category();
        category.setFoodtype(foodType);
        category.setFoodingredients(foodIngredients);

        Restaurant restaurant = new Restaurant();
        restaurant.setRestusername(restUsername);
        restaurant.setFoods(new ArrayList<>());

        Food food = new Food();
        food.setRestUsername(restUsername);
        food.setFoodName(foodName);
        food.setCategory(category);
        food.setRestaurant(restaurant);

        when(categoryRepository.findByFoodtypeAndFoodingredients(foodType, foodIngredients)).thenReturn(null);
        when(restaurantRepository.findByRestusername(restUsername)).thenReturn(restaurant);
        when(foodRepository.findByRestUsernameAndFoodName(restUsername, foodName)).thenReturn(null);
        when(categoryRepository.saveAndFlush(any(Category.class))).thenReturn(category);
        when(foodRepository.saveAndFlush(any(Food.class))).thenReturn(food);

        String result = postService.postFood(restUsername, foodName, foodType, foodIngredients, postAmount);

        assertEquals("", result);
        verify(foodRepository).saveAndFlush(any(Food.class));
    }
}
