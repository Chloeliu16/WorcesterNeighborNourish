package com.worcester.neighbor.nourish.dto.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MaintenanceInfo {
    String name;
    String email;
    String phone;
    String responsibility;
}
