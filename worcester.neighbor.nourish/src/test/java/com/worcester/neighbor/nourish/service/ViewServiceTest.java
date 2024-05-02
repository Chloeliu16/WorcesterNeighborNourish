package com.worcester.neighbor.nourish.service;

import com.worcester.neighbor.nourish.dto.base.ActivityInfo;
import com.worcester.neighbor.nourish.dto.base.FoodInfo;
import com.worcester.neighbor.nourish.model.organization.Organization;
import com.worcester.neighbor.nourish.model.restaurant.Restaurant;
import com.worcester.neighbor.nourish.model.restaurant.Food;
import com.worcester.neighbor.nourish.model.restaurant.Category;
import com.worcester.neighbor.nourish.model.organization.Activity;
import com.worcester.neighbor.nourish.model.organization.Detail;
import com.worcester.neighbor.nourish.model.organization.Contact;
import com.worcester.neighbor.nourish.repository.organization.ActivityRepository;
import com.worcester.neighbor.nourish.repository.restaurant.FoodRepository;
import com.worcester.neighbor.nourish.service.ViewService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;

public class ViewServiceTest {

    @Mock
    private FoodRepository foodRepository;
    @Mock
    private ActivityRepository activityRepository;

    @InjectMocks
    private ViewService viewService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testViewFood() {
        List<Food> foods = new ArrayList<>();
        Food food = new Food();
        food.setFoodName("Pizza");
        food.setAmount(10);

        Restaurant restaurant = new Restaurant();
        restaurant.setRestname("Pizza Place");
        restaurant.setPhone("1234567890");
        restaurant.setEmail("contact@pizzaplace.com");
        restaurant.setAddress("123 Pizza St");

        Category category = new Category();
        category.setFoodtype("Italian");
        category.setFoodingredients("Cheese, Tomato Sauce");

        food.setRestaurant(restaurant);
        food.setCategory(category);

        foods.add(food);
        when(foodRepository.findAll()).thenReturn(foods);

        List<FoodInfo> result = viewService.viewFood();
        assertNotNull(result);
        assertEquals(1, result.size());
    }

    @Test
    public void testViewActivity() {
        List<Activity> activities = new ArrayList<>();
        Activity activity = new Activity();
        activity.setActivityName("Cooking Class");

        Organization organization = new Organization();
        organization.setOrgname("Community Center");

        Detail detail = new Detail();
        detail.setAddress("456 Community St");
        detail.setStartTime("09:00");
        detail.setEndTime("11:00");

        Contact contact = new Contact();
        contact.setName("John Doe");
        contact.setPhone("9876543210");
        contact.setEmail("john.doe@example.com");

        activity.setOrganization(organization);
        activity.setDetail(detail);
        activity.setContact(contact);

        activities.add(activity);
        when(activityRepository.findAll()).thenReturn(activities);

        List<ActivityInfo> result = viewService.viewActivity();
        assertNotNull(result);
        assertEquals(1, result.size());
    }
}
