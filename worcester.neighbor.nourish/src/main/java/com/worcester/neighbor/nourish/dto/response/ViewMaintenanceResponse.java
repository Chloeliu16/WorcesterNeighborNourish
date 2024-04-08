package com.worcester.neighbor.nourish.dto.response;

import com.worcester.neighbor.nourish.dto.base.MaintenanceInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ViewMaintenanceResponse {
    boolean success = true;
    List<MaintenanceInfo> maintenances;
}
