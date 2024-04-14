package com.worcester.neighbor.nourish.dto.response;

import com.worcester.neighbor.nourish.dto.base.SupplierInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SupplierAddResponse {
    boolean success = true;
    String FailureReason;
    SupplierInfo supplierInfo;
}
