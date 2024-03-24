package com.worcester.neighbor.nourish.repository;

import com.worcester.neighbor.nourish.model.Food;
import com.worcester.neighbor.nourish.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    // check if restaurantId is used
    Restaurant findByRestusername(String restusername);
    // for login

    Restaurant findByRestusernameAndPassword(String restusername, String password);
    // for register
    Restaurant findByRestname(String restname);
    Restaurant saveAndFlush(Restaurant restaurant);
}
