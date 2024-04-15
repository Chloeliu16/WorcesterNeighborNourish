package com.worcester.neighbor.nourish.model.restaurant;

import com.worcester.neighbor.nourish.model.Supplier.Supplier;
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
public class Restaurant {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    String restusername;
    String restname;
    String password;
    String email;
    String phone;
    String address;
    String certificate;

    @OneToMany(mappedBy = "restaurant", fetch = LAZY, cascade = CascadeType.ALL)
    List<Food> foods;

    @OneToMany(mappedBy = "restaurant", fetch = LAZY, cascade = CascadeType.ALL)
    List<ReserveFood> reserveFoods;

    @OneToMany(mappedBy = "restaurant", fetch = LAZY, cascade = CascadeType.ALL)
    List<PostFood> posts;

    @OneToMany(mappedBy = "restaurant", fetch = LAZY, cascade = CascadeType.ALL)
    List<Supplier> suppliers;
}
