package com.worcester.neighbor.nourish.service;

import com.worcester.neighbor.nourish.model.Restaurant;
import com.worcester.neighbor.nourish.model.User;
import com.worcester.neighbor.nourish.repository.RestaurantRepository;
import com.worcester.neighbor.nourish.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    private final RestaurantRepository restaurantRepository;
    private final UserRepository userRepository;

    @Autowired
    public LoginService(RestaurantRepository restaurantRepository, UserRepository userRepository) {
        this.restaurantRepository = restaurantRepository;
        this.userRepository = userRepository;
    }

    public String loginRestaurant(
            String restaurantId,
            String password
    ) {
        try {
            Restaurant exist = restaurantRepository.findByRestaurantIdAndPassword(restaurantId, password);
            if (exist == null) {
                return "Account does not exist or wrong password!";
            }
            return "";
        }
        catch (Exception e) {
            e.printStackTrace();
            return "Find account failed!";
        }
    }

    public String loginUser(
            String userId,
            String password
    ) {
        try {
            User exist = userRepository.findByUserIdAndPassword(userId, password);
            if (exist == null) {
                return "Account does not exist or wrong password!";
            }
            return "";
        }
        catch (Exception e) {
            e.printStackTrace();
            return "Find account failed!";
        }
    }
}
