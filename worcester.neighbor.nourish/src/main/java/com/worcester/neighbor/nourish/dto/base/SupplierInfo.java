package com.worcester.neighbor.nourish.dto.base;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SupplierInfo {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    String id;

    String foodSafetyCertification;
    String type;
    String name;
    String email;
    String phone;
}
