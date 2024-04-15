package com.worcester.neighbor.nourish.controller;

import ch.qos.logback.core.util.SystemInfo;
import com.worcester.neighbor.nourish.dto.request.SupplierAddRequest;
import com.worcester.neighbor.nourish.dto.request.VolunteerRequest;
import com.worcester.neighbor.nourish.dto.response.SupplierAddResponse;
import com.worcester.neighbor.nourish.dto.response.VolunteerResponse;
import com.worcester.neighbor.nourish.service.SupplierAddService;
import com.worcester.neighbor.nourish.service.VolunteerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/supplier")
@CrossOrigin(origins = "*")
public class SupplierAdd {
    private final SupplierAddService supplierAddService;
    public SupplierAdd(SupplierAddService supplierAddService) { this.supplierAddService = supplierAddService;}
    @PostMapping
    public SupplierAddResponse supplierAdd(@RequestBody SupplierAddRequest supplierAddRequest) {
        SupplierAddResponse supplierAddResponse = new SupplierAddResponse();
        System.out.println(supplierAddRequest);
        String supplierAddOutput = "No supplier info";

        if(supplierAddRequest != null) {
            supplierAddOutput = supplierAddService.add(
                    supplierAddRequest.getRestUsername(),
                    supplierAddRequest.getFoodSafetyCertification(),
                    supplierAddRequest.getType(),
                    supplierAddRequest.getName(),
                    supplierAddRequest.getEmail(),
                    supplierAddRequest.getPhone()
            );
        }
        if (supplierAddOutput !="") {
            supplierAddResponse.setSuccess(false);
            supplierAddResponse.setFailureReason(supplierAddOutput);
        }
        return supplierAddResponse;
    }
}
