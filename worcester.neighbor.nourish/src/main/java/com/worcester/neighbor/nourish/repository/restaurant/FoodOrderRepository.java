package com.worcester.neighbor.nourish.repository.restaurant;

import com.worcester.neighbor.nourish.model.restaurant.Food;
import com.worcester.neighbor.nourish.model.restaurant.FoodOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodOrderRepository extends JpaRepository<FoodOrder, Long> {
    List<FoodOrder> findAll();
    List<FoodOrder> findByRestUsername(String restUsername);
    List<FoodOrder> findByCusUsername(String cusUsername);
    FoodOrder saveAndFlush(FoodOrder foodOrder);
}
