package com.worcester.neighbor.nourish.model.customer;

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
public class Feedback {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    String type;
    String info;
    String cusUsername;

    @ManyToOne
    @JoinColumn(name="customer_id")
    Customer customer;
}
