package com.worcester.neighbor.nourish.model.organization;

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
public class Detail {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    String address;
    String startTime;
    String endTime;

    @OneToOne(mappedBy = "detail")
    Activity activity;
}
