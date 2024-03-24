package com.worcester.neighbor.nourish.repository;

import com.worcester.neighbor.nourish.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    // check if userId is used
    Customer findByCususername(String cususername);
    // for login
    Customer findByCususernameAndPassword(String cususername, String password);
    // for register
    Customer saveAndFlush(Customer customer);
}
