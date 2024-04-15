package com.worcester.neighbor.nourish.service;

import com.worcester.neighbor.nourish.model.Supplier.Supplier;
import com.worcester.neighbor.nourish.model.restaurant.Restaurant;
import com.worcester.neighbor.nourish.repository.restaurant.RestaurantRepository;
import com.worcester.neighbor.nourish.repository.supplier.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierAddService {
    private final SupplierRepository supplierRepository;
    private final RestaurantRepository restaurantRepository;

    @Autowired
    public SupplierAddService(SupplierRepository supplierRepository, RestaurantRepository restaurantRepository) {
        this.supplierRepository = supplierRepository;
        this.restaurantRepository = restaurantRepository;
    }

    public String add(
            String restUsername,
            String foodSafetyCertification,
            String type,
            String name,
            String email,
            String phone
    ) {
        try {
            Supplier exist = supplierRepository.findByFoodSafetyCertification(foodSafetyCertification);
            if (exist != null) {
                return "Supplier with the certificate has already been added!";
            }
            Restaurant rest = restaurantRepository.findByRestusername(restUsername);
            Supplier supplier = new Supplier();
            supplier.setFoodSafetyCertification(foodSafetyCertification);
            supplier.setType(type);
            supplier.setName(name);
            supplier.setEmail(email);
            supplier.setPhone(phone);
            supplier.setRestaurant(rest);
            List<Supplier> allSuppliers = rest.getSuppliers();
            allSuppliers.add(supplier);
            rest.setSuppliers(allSuppliers);
            restaurantRepository.saveAndFlush(rest);
            return "";
        } catch (Exception e) {
            e.printStackTrace();
            return "Supplier Information input failed.";
        }
    }
}

