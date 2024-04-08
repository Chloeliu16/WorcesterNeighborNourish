package com.worcester.neighbor.nourish.model.organization;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.IDENTITY;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Contact {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    String name;
    String email;
    String phone;

    @OneToOne(mappedBy = "contact")
    Activity activity;
}
