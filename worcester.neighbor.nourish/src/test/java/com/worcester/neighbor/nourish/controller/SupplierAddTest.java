package com.worcester.neighbor.nourish.controller;

import com.worcester.neighbor.nourish.dto.request.SupplierAddRequest;
import com.worcester.neighbor.nourish.dto.response.SupplierAddResponse;
import com.worcester.neighbor.nourish.service.SupplierAddService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class SupplierAddTest {

    @Mock
    private SupplierAddService supplierAddService;

    @InjectMocks
    private SupplierAdd supplierAddController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSupplierAdd() {
        SupplierAddRequest supplierAddRequest = new SupplierAddRequest();
        supplierAddRequest.setRestUsername("restaurant123");
        supplierAddRequest.setFoodSafetyCertification("Cert123");
        supplierAddRequest.setType("Meat Supplier");
        supplierAddRequest.setName("Best Meats");
        supplierAddRequest.setEmail("contact@bestmeats.com");
        supplierAddRequest.setPhone("1234567890");

        when(supplierAddService.add("restaurant123", "Cert123", "Meat Supplier", "Best Meats", "contact@bestmeats.com", "1234567890"))
                .thenReturn("Supplier added successfully");

        SupplierAddResponse supplierAddResponse = supplierAddController.supplierAdd(supplierAddRequest);

        assertFalse(supplierAddResponse.isSuccess());
        assertEquals("Supplier added successfully", supplierAddResponse.getFailureReason());
    }
}
