package com.worcester.neighbor.nourish.model.Supplier;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Supplier {

    @Id
    private String foodSafetyCertification;

    private String type;
    private String name;
    private String email;
    private String phone;
}
