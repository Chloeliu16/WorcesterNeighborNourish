package com.worcester.neighbor.nourish.model.restaurant;

import com.worcester.neighbor.nourish.model.customer.Customer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

import static jakarta.persistence.FetchType.LAZY;
import static jakarta.persistence.GenerationType.IDENTITY;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReserveFood {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    String orderNum;
    String cusUsername;
    String restUsername;
    String foodName;
    int amount;
    Timestamp timstamp;

    @OneToOne(fetch = LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "status_id")
    Status status;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    Restaurant restaurant;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    Customer customer;
}
