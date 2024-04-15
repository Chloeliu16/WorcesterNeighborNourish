package com.worcester.neighbor.nourish.model.customer;

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
public class PostFeedback {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    Timestamp timestamp;
    String status;

    @OneToOne(fetch = LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "feedback_id")
    Feedback feedback;

    @ManyToOne
    @JoinColumn(name="customer_id")
    Customer customer;
}
