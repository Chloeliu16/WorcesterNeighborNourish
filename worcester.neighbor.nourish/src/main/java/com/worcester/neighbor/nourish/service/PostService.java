package com.worcester.neighbor.nourish.service;

import com.worcester.neighbor.nourish.model.customer.Customer;
import com.worcester.neighbor.nourish.model.customer.Feedback;
import com.worcester.neighbor.nourish.model.customer.PostFeedback;
import com.worcester.neighbor.nourish.model.organization.*;
import com.worcester.neighbor.nourish.model.restaurant.Category;
import com.worcester.neighbor.nourish.model.restaurant.Food;
import com.worcester.neighbor.nourish.model.restaurant.PostFood;
import com.worcester.neighbor.nourish.model.restaurant.Restaurant;
import com.worcester.neighbor.nourish.repository.customer.CustomerRepository;
import com.worcester.neighbor.nourish.repository.organization.OrganizationRepository;
import com.worcester.neighbor.nourish.repository.restaurant.CategoryRepository;
import com.worcester.neighbor.nourish.repository.restaurant.FoodRepository;
import com.worcester.neighbor.nourish.repository.restaurant.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {
    private final CustomerRepository customerRepository;
    private final RestaurantRepository restaurantRepository;
    private final OrganizationRepository organizationRepository;

    private final CategoryRepository categoryRepository;

    private final FoodRepository foodRepository;

    @Autowired
    public PostService(
            CustomerRepository customerRepository,
            RestaurantRepository restaurantRepository,
            OrganizationRepository organizationRepository,
            CategoryRepository categoryRepository,
            FoodRepository foodRepository
            ) {
        this.customerRepository = customerRepository;
        this.restaurantRepository = restaurantRepository;
        this.organizationRepository = organizationRepository;
        this.categoryRepository = categoryRepository;
        this.foodRepository = foodRepository;
    }

    public String postFood(
            String restUsername,
            String foodName,
            String foodType,
            String foodIngredients,
            int postAmount
    ) {
        try {
            Category category = categoryRepository.findByFoodtypeAndFoodingredients(foodType, foodIngredients);
            if (category == null) {
                category = new Category();
                category.setFoodtype(foodType);
                category.setFoodingredients(foodIngredients);
                category = categoryRepository.saveAndFlush(category);
           }

            Restaurant restaurant = restaurantRepository.findByRestusername(restUsername);
            Food food = foodRepository.findByRestUsernameAndFoodName(restUsername, foodName);
            if (food == null) {
                food = new Food();
                food.setRestUsername(restUsername);
                food.setFoodName(foodName);
                food.setAmount(postAmount);

                List<Food> foods = category.getFoods();
                if (foods == null) {
                    foods = new ArrayList<>();
                }
                foods.add(food);
                category.setFoods(foods);
                food.setCategory(category);

                foods = restaurant.getFoods();
                if (foods == null) {
                    foods = new ArrayList<>();
                }
                foods.add(food);
                restaurant.setFoods(foods);
                food.setRestaurant(restaurant);
            } else {
                food.setAmount(food.getAmount() + postAmount);
            }

            List<PostFood> foodPosts = food.getPosts();
            if (foodPosts == null) {
                foodPosts = new ArrayList<>();
            }
            PostFood post = new PostFood();
            post.setStatus("posted");
            post.setTimestamp(new Timestamp(System.currentTimeMillis()));
            post.setPostAmount(postAmount);

            List<PostFood> restPosts = restaurant.getPosts();
            if (restPosts == null) {
                restPosts = new ArrayList<>();
            }
            restPosts.add(post);
            post.setRestaurant(restaurant);
            restaurant.setPosts(restPosts);

            post.setFood(food);
            post.setRestaurant(restaurant);
            foodPosts.add(post);
            food.setPosts(foodPosts);

            foodRepository.saveAndFlush(food);
            return "";
        }
        catch(Exception e) {
            e.printStackTrace();
            return "Post food failed!";
        }
    }

    public String postActivity(
            String orgUsername,
            String activityName,
            String address,
            String startTime,
            String endTime,
            String contactName,
            String contactPhone,
            String contactEmail
    ) {
        try {
            Organization organization = organizationRepository.findByOrgusername(orgUsername);
            List<Activity> allActivities = organization.getActivities();
            List<PostActivity> allPosts = organization.getPosts();
            Activity activity = new Activity();
            activity.setActivityName(activityName);
            activity.setOrgUsername(orgUsername);

            Detail detail = new Detail();
            detail.setAddress(address);
            detail.setStartTime(startTime);
            detail.setEndTime(endTime);
            detail.setActivity(activity);
            activity.setDetail(detail);

            Contact contact = new Contact();
            contact.setName(contactName);
            contact.setPhone(contactPhone);
            contact.setEmail(contactEmail);
            contact.setActivity(activity);
            activity.setContact(contact);

            PostActivity postActivity = new PostActivity();
            postActivity.setStatus("posted");
            postActivity.setTimestamp(new Timestamp(System.currentTimeMillis()));
            postActivity.setActivity(activity);
            postActivity.setOrganization(organization);
            activity.setPostActivity(postActivity);
            activity.setOrganization(organization);

            allActivities.add(activity);
            allPosts.add(postActivity);
            organization.setActivities(allActivities);
            organization.setPosts(allPosts);
            organizationRepository.saveAndFlush(organization);
            return "";
        }
        catch(Exception e) {
            e.printStackTrace();
            return "Post info failed!";
        }
    }

    public String postFeedback(
            String cusUsername,
            String type,
            String info
    ) {
        try {
            Customer customer = customerRepository.findByCususername(cusUsername);
            List<Feedback> allFeedbacks = customer.getFeedbacks();
            List<PostFeedback> allPosts = customer.getPosts();
            Feedback feedback = new Feedback();
            feedback.setType(type);
            feedback.setInfo(info);
            feedback.setCusUsername(cusUsername);

            PostFeedback postFeedback = new PostFeedback();
            postFeedback.setTimestamp(new Timestamp(System.currentTimeMillis()));
            postFeedback.setStatus("posted");
            postFeedback.setFeedback(feedback);
            postFeedback.setCustomer(customer);
            feedback.setPostFeedback(postFeedback);
            feedback.setCustomer(customer);

            allFeedbacks.add(feedback);
            allPosts.add(postFeedback);
            customer.setFeedbacks(allFeedbacks);
            customer.setPosts(allPosts);
            customerRepository.saveAndFlush(customer);
            return "";
        }
        catch(Exception e) {
            e.printStackTrace();
            return "Post feedback failed!";
        }
    }
}
