package com.worcester.neighbor.nourish.repository.supplier;

import com.worcester.neighbor.nourish.model.Supplier.Supplier;
import com.worcester.neighbor.nourish.model.Volunteer.Volunteer;
import com.worcester.neighbor.nourish.model.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, String>{
    Supplier findByFoodSafetyCertification(String foodSafetyCertification);
    Supplier saveAndFlush(Supplier supplier);
}
