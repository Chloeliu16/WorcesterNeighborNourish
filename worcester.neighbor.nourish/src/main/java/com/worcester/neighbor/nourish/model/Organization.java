package com.worcester.neighbor.nourish.model;

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
public class Organization {
        @Id
        @GeneratedValue(strategy = IDENTITY)
        private Long id;

        String orgusername;
        String orgname;
        String password;
        String email;
        String phone;
        String address;
}
