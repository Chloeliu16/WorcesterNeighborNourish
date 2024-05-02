package com.worcester.neighbor.nourish.service;

import com.worcester.neighbor.nourish.model.Supplier.Supplier;
import com.worcester.neighbor.nourish.model.restaurant.Restaurant;
import com.worcester.neighbor.nourish.repository.restaurant.RestaurantRepository;
import com.worcester.neighbor.nourish.repository.supplier.SupplierRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.anyString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

public class SupplierAddServiceTest {

    @Mock
    private SupplierRepository supplierRepository;
    @Mock
    private RestaurantRepository restaurantRepository;

    @InjectMocks
    private SupplierAddService supplierAddService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAdd_NewSupplier_Success() {
        String restUsername = "restUser";
        String foodSafetyCertification = "CERT123";
        String type = "Food";
        String name = "Supplier Name";
        String email = "supplier@example.com";
        String phone = "1234567890";

        Restaurant restaurant = new Restaurant();
        restaurant.setSuppliers(new ArrayList<>());

        when(supplierRepository.findByFoodSafetyCertification(foodSafetyCertification)).thenReturn(null);
        when(restaurantRepository.findByRestusername(restUsername)).thenReturn(restaurant);
        when(restaurantRepository.saveAndFlush(any(Restaurant.class))).thenReturn(restaurant);

        String result = supplierAddService.add(restUsername, foodSafetyCertification, type, name, email, phone);

        assertEquals("", result);
        verify(restaurantRepository).saveAndFlush(any(Restaurant.class));
    }

    @Test
    public void testAdd_SupplierExists_Failure() {
        String foodSafetyCertification = "CERT123";

        when(supplierRepository.findByFoodSafetyCertification(foodSafetyCertification)).thenReturn(new Supplier());

        String result = supplierAddService.add("restUser", foodSafetyCertification, "Food", "Supplier Name", "supplier@example.com", "1234567890");

        assertEquals("Supplier with the certificate has already been added!", result);
        verify(restaurantRepository, never()).saveAndFlush(any(Restaurant.class));
    }
}
