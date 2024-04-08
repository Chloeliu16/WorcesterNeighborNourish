package com.worcester.neighbor.nourish.service;

import com.worcester.neighbor.nourish.model.customer.Customer;
import com.worcester.neighbor.nourish.model.restaurant.Food;
import com.worcester.neighbor.nourish.model.restaurant.FoodOrder;
import com.worcester.neighbor.nourish.model.restaurant.Restaurant;
import com.worcester.neighbor.nourish.model.restaurant.Status;
import com.worcester.neighbor.nourish.repository.customer.CustomerRepository;
import com.worcester.neighbor.nourish.repository.restaurant.FoodOrderRepository;
import com.worcester.neighbor.nourish.repository.restaurant.FoodRepository;
import com.worcester.neighbor.nourish.repository.restaurant.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class ReserveService {
    private final FoodRepository foodRepository;
    private final FoodOrderRepository foodOrderRepository;
    private final RestaurantRepository restaurantRepository;
    private final CustomerRepository customerRepository;

    @Autowired
    public ReserveService(
            FoodRepository  foodRepository,
            FoodOrderRepository foodOrderRepository,
            RestaurantRepository restaurantRepository,
            CustomerRepository customerRepository
    ) {
        this.foodRepository = foodRepository;
        this.foodOrderRepository = foodOrderRepository;
        this.restaurantRepository = restaurantRepository;
        this.customerRepository = customerRepository;
    }

    public String reserveFood(
            String restUsername,
            String cusUsername,
            String foodName,
            int reserveAmount
    ) {
        try {
            Food food = foodRepository.findByRestUsernameAndFoodName(restUsername, foodName);
            String orderStatus = "";
            if (food == null || food.getAmount() < reserveAmount) {
                orderStatus = "No food or not enough food available!";
            } else {
                food.setAmount(food.getAmount() - reserveAmount);
                foodRepository.saveAndFlush(food);
                orderStatus = "Success";
            }
            putOrder(
                    cusUsername,
                    restUsername,
                    foodName,
                    reserveAmount,
                    orderStatus
            );
            return orderStatus;
        }
        catch(Exception e) {
            e.printStackTrace();
            return "Reserve food failed!";
        }
    }

    private String putOrder(
             String cusUsername,
             String restUsername,
             String foodName,
             int amount,
             String orderStatus
    ) {
        try {
            FoodOrder foodOrder = new FoodOrder();
            Restaurant restaurant = restaurantRepository.findByRestusername(restUsername);
            Customer customer = customerRepository.findByCususername(cusUsername);
            foodOrder.setFoodName(foodName);
            foodOrder.setCusUsername(cusUsername);
            foodOrder.setRestUsername(restUsername);
            foodOrder.setAmount(amount);

            Status status = new Status();
            status.setOrderStatus(orderStatus);
            status.setFoodOrder(foodOrder);
            foodOrder.setStatus(status);

            foodOrder.setRestaurant(restaurant);
            foodOrder.setCustomer(customer);

            String orderNum = generateOrderNum();
            foodOrder.setOrderNum(orderNum);
            foodOrderRepository.saveAndFlush(foodOrder);
            return orderNum;
        }
        catch(Exception e) {
            e.printStackTrace();
            return "Put order failed!";
        }
    }

    private String generateOrderNum() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvxyz";
        String orderNum = "";
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            orderNum += chars.charAt(random.nextInt(chars.length()));
        }
        return orderNum;
    }
}
