package com.worcester.neighbor.nourish.service;

import com.worcester.neighbor.nourish.model.customer.Customer;
import com.worcester.neighbor.nourish.model.customer.Feedback;
import com.worcester.neighbor.nourish.model.organization.Contact;
import com.worcester.neighbor.nourish.model.organization.Detail;
import com.worcester.neighbor.nourish.model.organization.Activity;
import com.worcester.neighbor.nourish.model.organization.Organization;
import com.worcester.neighbor.nourish.model.restaurant.Category;
import com.worcester.neighbor.nourish.model.restaurant.Food;
import com.worcester.neighbor.nourish.model.restaurant.Restaurant;
import com.worcester.neighbor.nourish.repository.customer.CustomerRepository;
import com.worcester.neighbor.nourish.repository.organization.OrganizationRepository;
import com.worcester.neighbor.nourish.repository.restaurant.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    private final CustomerRepository customerRepository;
    private final RestaurantRepository restaurantRepository;
    private final OrganizationRepository organizationRepository;

    @Autowired
    public PostService(
            CustomerRepository customerRepository,
            RestaurantRepository restaurantRepository,
            OrganizationRepository organizationRepository
            ) {
        this.customerRepository = customerRepository;
        this.restaurantRepository = restaurantRepository;
        this.organizationRepository = organizationRepository;
    }

    public String postFood(
            String restUsername,
            String foodName,
            String foodType,
            String foodIngredients,
            int postAmount
    ) {
        try {
            Restaurant restaurant = restaurantRepository.findByRestusername(restUsername);
            List<Food> allFoods = restaurant.getFoods();
            boolean existFood = false;
            for (int i = 0; i < allFoods.size(); i++) {
                Food tmp = allFoods.get(i);
                if (tmp.getFoodName() == foodName) {
                    tmp.setAmount(tmp.getAmount() + postAmount);
                    allFoods.set(i, tmp);
                    existFood = true;
                    break;
                }
            }

            if (!existFood) {
                Food food = new Food();
                food.setRestUsername(restUsername);
                food.setFoodName(foodName);

                Category category = new Category();
                category.setFoodType(foodType);
                category.setFoodIngredients(foodIngredients);
                category.setFood(food);

                food.setCategory(category);
                food.setAmount(postAmount);
                food.setRestaurant(restaurant);
                allFoods.add(food);
            }

            restaurant.setFoods(allFoods);
            restaurantRepository.saveAndFlush(restaurant);
            return "";
        }
        catch(Exception e) {
            e.printStackTrace();
            return "Post food failed!";
        }
    }

    public String postInfo(
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

            activity.setOrganization(organization);

            allActivities.add(activity);
            organization.setActivities(allActivities);
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
            Feedback feedback = new Feedback();
            feedback.setType(type);
            feedback.setInfo(info);
            feedback.setCusUsername(cusUsername);
            feedback.setCustomer(customer);

            allFeedbacks.add(feedback);
            customer.setFeedbacks(allFeedbacks);
            customerRepository.saveAndFlush(customer);
            return "";
        }
        catch(Exception e) {
            e.printStackTrace();
            return "Post feedback failed!";
        }
    }
}
