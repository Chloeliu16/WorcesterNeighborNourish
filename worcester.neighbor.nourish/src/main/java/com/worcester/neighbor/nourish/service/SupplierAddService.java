package com.worcester.neighbor.nourish.service;

import com.worcester.neighbor.nourish.model.Supplier.Supplier;
import com.worcester.neighbor.nourish.model.customer.Customer;
import com.worcester.neighbor.nourish.model.faqs.ContactHistory;
import com.worcester.neighbor.nourish.repository.faqs.ContactRepository;
import com.worcester.neighbor.nourish.repository.supplier.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupplierAddService {
    private final SupplierRepository supplierRepository;

    @Autowired
    public SupplierAddService(SupplierRepository supplierRepository) {this.supplierRepository = supplierRepository;}

    public String add(
        String foodSafetyCertification,
        String type,
        String name,
        String email,
        String phone)
    {
        try {
            Supplier exist = supplierRepository.findByFoodSafetyCertification(foodSafetyCertification);
            if (exist != null) {
                return "The supplier already exists and can be directly added to the supplier list.";
            }
            Supplier supplier = new Supplier();
            supplier.setFoodSafetyCertification(foodSafetyCertification);
            supplier.setType(type);
            supplier.setName(name);
            supplier.setEmail(email);
            supplier.setPhone(phone);
            supplierRepository.saveAndFlush(supplier);
            return "";
        } catch (Exception e) {
            e.printStackTrace();
            return "Supplier Information input failed.";
        }
    }
}

