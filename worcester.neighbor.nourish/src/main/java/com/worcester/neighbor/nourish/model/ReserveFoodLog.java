package com.worcester.neighbor.nourish.model;

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
public class ReserveFoodLog {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    String userName;
    String restName;
    String foodType;
    String foodName;
    int amount;
    boolean success;
    String status = "waiting";
}
