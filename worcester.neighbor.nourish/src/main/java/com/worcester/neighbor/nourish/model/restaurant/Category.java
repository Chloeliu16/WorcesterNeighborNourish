package com.worcester.neighbor.nourish.model.restaurant;

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
public class Category {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    String foodtype;
    String foodingredients;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    List<Food> foods;
}
