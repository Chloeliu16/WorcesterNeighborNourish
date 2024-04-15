package com.worcester.neighbor.nourish.model.organization;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import static jakarta.persistence.FetchType.LAZY;
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

        @OneToMany(mappedBy = "organization", fetch = LAZY, cascade = CascadeType.ALL)
        List<Activity> activities;

        @OneToMany(mappedBy = "organization", fetch = LAZY, cascade = CascadeType.ALL)
        List<PostActivity> posts;
}
