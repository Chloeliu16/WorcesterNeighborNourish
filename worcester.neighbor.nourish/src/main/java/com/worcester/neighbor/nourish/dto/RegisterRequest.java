package com.worcester.neighbor.nourish.dto;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RegisterRequest {
    String password;
    String phone;
    String email;

    // Fields just for user
    String cusUserName;
    String cusName;

    // Fields just for restaurant
    String restUserName;
    String restName;
    String address;

    //Fields just for organization
    String orgUserName;
    String orgName;
    String type;
    String certificateNum;


    // Constructor just for user
    public RegisterRequest(
            String cusUserName,
            String cusName,
            String password,
            String phone,
            String email
    ) {
        this.cusUserName = cusUserName;
        this.cusName= cusName;
        this.password = password;
        this.phone = phone;
        this.email = email;
    }

    public RegisterRequest(
            String restUserName,
            String restName,
            String email,
            String password,
            String phone,
            String address

    ) {
        this.restUserName = restUserName;
        this.restName = restName;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.address = address;
    }

    public RegisterRequest(
            String orgUserName,
            String orgName,
            String email,
            String password,
            String address,
            String type,
            String certificateNum
    ) {
        this.orgUserName = orgUserName;
        this.orgName = orgName;
        this.email = email;
        this.password = password;
        this.address = address;
        this.type = type;
        this.certificateNum = certificateNum;
    }

//    private RegisterRequest(
//            String userName,
//            String name,
//            String password,
//            String phone,
//            String fifthParameter,
//            String email,
//            boolean isOrganization
//    ) {
//        if (isOrganization) {
//            this.orgUserName = userName;
//            this.orgName = name;
//            this.type = fifthParameter;
//        } else {
//            this.rUserName = userName;
//            this.rName = name;
//            this.address = fifthParameter;
//        }
//        this.password = password;
//        this.phone = phone;
//        this.email = email;
//    }

//    // 静态工厂方法 for organization
//    public static RegisterRequest forOrganization(String orgUserName, String orgName, String password, String phone, String type, String email) {
//        return new RegisterRequest(orgUserName, orgName, password, phone, type, email, true);
//    }
//
//    // 静态工厂方法 for restaurant
//    public static RegisterRequest forRestaurant(String rUserName, String rName, String password, String phone, String address, String email) {
//        return new RegisterRequest(rUserName, rName, password, phone, address, email,false);
//    }


//不能用可改回之前的
//    // Constructor just for restaurant
//    public RegisterRequest(
//            String organizationId,
//            String organizationName,
//            String password,
//            String phone,
//            String organizationType
//    ) {
//        this.organizationId = organizationId;
//        this.organizationName = organizationName;
//        this.password = password;
//        this.phone = phone;
//        this.organizationType = organizationType;
//    }
//
//    // Constructor just for organization
//    public RegisterRequest(
//            String restaurantId,
//            String restaurantName,
//            String password,
//            String phone,
//            String address
//    ) {
//        this.restaurantId = restaurantId;
//        this.restaurantName = restaurantName;
//        this.password = password;
//        this.phone = phone;
//        this.address = address;
//    }
}

