package com.worcester.neighbor.nourish.model.customer;

import com.worcester.neighbor.nourish.model.restaurant.ReserveFood;
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
public class Customer {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    String cususername;
    String cusname;
    String password;
    String email;
    String phone;

    @OneToMany(mappedBy = "customer", fetch = LAZY, cascade = CascadeType.ALL)
    List<ReserveFood> reserveFoods;

    @OneToMany(mappedBy = "customer", fetch = LAZY, cascade = CascadeType.ALL)
    List<Feedback> feedbacks;

    @OneToMany(mappedBy = "customer", fetch = LAZY, cascade = CascadeType.ALL)
    List<PostFeedback> posts;
}
