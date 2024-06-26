package com.worcester.neighbor.nourish.dto.request;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SupplierAddRequest {
    String restUsername;
    String foodSafetyCertification;
    String type;
    String name;
    String email;
    String phone;
}

