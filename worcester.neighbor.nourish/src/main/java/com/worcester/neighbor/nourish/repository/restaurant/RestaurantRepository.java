package com.worcester.neighbor.nourish.repository.restaurant;

import com.worcester.neighbor.nourish.model.restaurant.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    // check if restaurantId is used
    Restaurant findByRestusername(String restusername);
    // for login
    Restaurant findByRestusernameAndPassword(String restusername, String password);
    Restaurant saveAndFlush(Restaurant restaurant);
}
