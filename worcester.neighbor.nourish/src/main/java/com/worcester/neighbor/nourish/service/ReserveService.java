package com.worcester.neighbor.nourish.service;

import com.worcester.neighbor.nourish.model.customer.Customer;
import com.worcester.neighbor.nourish.model.restaurant.Food;
import com.worcester.neighbor.nourish.model.restaurant.ReserveFood;
import com.worcester.neighbor.nourish.model.restaurant.Restaurant;
import com.worcester.neighbor.nourish.model.restaurant.Status;
import com.worcester.neighbor.nourish.repository.customer.CustomerRepository;
import com.worcester.neighbor.nourish.repository.restaurant.ReserveFoodRepository;
import com.worcester.neighbor.nourish.repository.restaurant.FoodRepository;
import com.worcester.neighbor.nourish.repository.restaurant.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Random;

@Service
public class ReserveService {
    private final FoodRepository foodRepository;
    private final ReserveFoodRepository reserveFoodRepository;
    private final RestaurantRepository restaurantRepository;
    private final CustomerRepository customerRepository;

    @Autowired
    public ReserveService(
            FoodRepository  foodRepository,
            ReserveFoodRepository reserveFoodRepository,
            RestaurantRepository restaurantRepository,
            CustomerRepository customerRepository
    ) {
        this.foodRepository = foodRepository;
        this.reserveFoodRepository = reserveFoodRepository;
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
            ReserveFood reserveFood = new ReserveFood();
            Restaurant restaurant = restaurantRepository.findByRestusername(restUsername);
            Customer customer = customerRepository.findByCususername(cusUsername);
            reserveFood.setFoodName(foodName);
            reserveFood.setCusUsername(cusUsername);
            reserveFood.setRestUsername(restUsername);
            reserveFood.setAmount(amount);
            reserveFood.setTimstamp(new Timestamp(System.currentTimeMillis()));

            Status status = new Status();
            status.setOrderStatus(orderStatus);
            status.setReserveFood(reserveFood);
            reserveFood.setStatus(status);

            reserveFood.setRestaurant(restaurant);
            reserveFood.setCustomer(customer);

            String orderNum = generateOrderNum();
            reserveFood.setOrderNum(orderNum);
            reserveFoodRepository.saveAndFlush(reserveFood);
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
