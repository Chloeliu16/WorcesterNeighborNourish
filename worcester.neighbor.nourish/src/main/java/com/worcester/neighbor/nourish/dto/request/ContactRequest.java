package com.worcester.neighbor.nourish.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactRequest {

        String type;
        String email;
        String name;
        String detail;
}
