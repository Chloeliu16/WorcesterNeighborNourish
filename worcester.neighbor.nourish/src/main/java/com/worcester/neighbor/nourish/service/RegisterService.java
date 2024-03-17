package com.worcester.neighbor.nourish.service;

import com.worcester.neighbor.nourish.model.Restaurant;
import com.worcester.neighbor.nourish.model.User;
import com.worcester.neighbor.nourish.repository.RestaurantRepository;
import com.worcester.neighbor.nourish.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {
    private final RestaurantRepository restaurantRepository;
    private final UserRepository userRepository;

    @Autowired
    public RegisterService(RestaurantRepository restaurantRepository, UserRepository userRepository) {
        this.restaurantRepository = restaurantRepository;
        this.userRepository = userRepository;
    }

    public String registerRestaurant(
            String restaurantId,
            String restaurantName,
            String password,
            String phone,
            String address
    ) {
        try {
            Restaurant exist = restaurantRepository.findByRestaurantId(restaurantId);
            if (exist != null) {
                return "Not unique register id!";
            }
            Restaurant account = new Restaurant();
            account.setRestaurantId(restaurantId);
            account.setRestaurantName(restaurantName);
            account.setPassword(password);
            account.setPhone(phone);
            account.setAddress(address);
            restaurantRepository.saveAndFlush(account);
            return "";
        }
        catch (Exception e) {
            e.printStackTrace();
            return "Register Failed!";
        }
    }

    public String registerUser(
            String userId,
            String userName,
            String password,
            String phone
    ) {
        try {
            User exist = userRepository.findByUserId(userId);
            if (exist != null) {
                return "Not unique register id!";
            }
            User account = new User();
            account.setUserId(userId);
            account.setUserName(userName);
            account.setPassword(password);
            account.setPhone(phone);
            userRepository.saveAndFlush(account);
            return "";
        }
        catch (Exception e) {
            e.printStackTrace();
            return "Register Failed!";
        }

    }
}
