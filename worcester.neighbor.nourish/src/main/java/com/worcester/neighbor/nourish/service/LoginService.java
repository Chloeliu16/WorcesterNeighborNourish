package com.worcester.neighbor.nourish.service;

import com.worcester.neighbor.nourish.model.Organization;
import com.worcester.neighbor.nourish.model.Restaurant;
import com.worcester.neighbor.nourish.model.Customer;
import com.worcester.neighbor.nourish.repository.OrganizationRepository;
import com.worcester.neighbor.nourish.repository.RestaurantRepository;
import com.worcester.neighbor.nourish.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    private final RestaurantRepository restaurantRepository;
    private final CustomerRepository customerRepository;
    private final OrganizationRepository organizationRepository;

    @Autowired
    public LoginService(RestaurantRepository restaurantRepository, CustomerRepository customerRepository, OrganizationRepository organizationRepository) {
        this.restaurantRepository = restaurantRepository;
        this.customerRepository = customerRepository;
        this.organizationRepository = organizationRepository;
    }

    public String loginRestaurant(
            String restUserName,
            String password
    ) {
        try {

            Restaurant exist = restaurantRepository.findByRestusernameAndPassword(restUserName, password);
            if (exist == null) {
                return "Account does not exist or wrong password!";
            }
            return "";
        }
        catch (Exception e) {
            e.printStackTrace();
            return "Find account failed!";
        }
    }

    public String loginCustomer(
            String cusUserName,
            String password
    ) {
        try {

            Customer exist = customerRepository.findByCususernameAndPassword(cusUserName, password);

            if (exist == null) {
                return "Account does not exist or wrong password!";
            }
            return "";
        }
        catch (Exception e) {
            e.printStackTrace();
            return "Find account failed!";
        }
    }

    public String loginOrgnization(
            String orgUserName,
            String password
    ) {
        try {
            Organization exist = organizationRepository.findByOrgusernameAndPassword(orgUserName, password);
            if (exist == null) {
                return "Account does not exist or wrong password!";
            }
            return "";
        }
        catch (Exception e) {
            e.printStackTrace();
            return "Find account failed!";
        }
    }
}
