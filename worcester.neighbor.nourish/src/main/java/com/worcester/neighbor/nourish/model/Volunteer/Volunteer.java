package com.worcester.neighbor.nourish.model.Volunteer;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
public class Volunteer {
        @Id
        @GeneratedValue(strategy = IDENTITY)
        private Long id;
        private String name;
        private String age;
        private String career;
        private String email;
        private String phone;
        private String city;
        private String zipcode;
        private String availability;
}
