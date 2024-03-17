package com.worcester.neighbor.nourish.repository;

import com.worcester.neighbor.nourish.model.Food;
import com.worcester.neighbor.nourish.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    // check if restaurantId is used
    Restaurant findByRestaurantId(String restaurantId);
    // for login
    Restaurant findByRestaurantIdAndPassword(String restaurantId, String password);
    // for register
    Restaurant saveAndFlush(Restaurant restaurant);
}
