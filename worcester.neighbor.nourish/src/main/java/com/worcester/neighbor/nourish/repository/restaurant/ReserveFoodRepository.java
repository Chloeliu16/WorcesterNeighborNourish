package com.worcester.neighbor.nourish.repository.restaurant;

import com.worcester.neighbor.nourish.model.restaurant.ReserveFood;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReserveFoodRepository extends JpaRepository<ReserveFood, Long> {
    List<ReserveFood> findAll();
    List<ReserveFood> findByRestUsername(String restUsername);
    List<ReserveFood> findByCusUsername(String cusUsername);
    ReserveFood saveAndFlush(ReserveFood reserveFood);
}
