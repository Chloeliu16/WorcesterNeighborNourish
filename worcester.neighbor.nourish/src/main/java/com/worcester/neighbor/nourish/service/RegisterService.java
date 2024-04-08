package com.worcester.neighbor.nourish.service;

import com.worcester.neighbor.nourish.model.organization.Organization;
import com.worcester.neighbor.nourish.model.restaurant.Restaurant;
import com.worcester.neighbor.nourish.model.customer.Customer;
import com.worcester.neighbor.nourish.repository.organization.OrganizationRepository;
import com.worcester.neighbor.nourish.repository.restaurant.RestaurantRepository;
import com.worcester.neighbor.nourish.repository.customer.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {
    private final RestaurantRepository restaurantRepository;
    private final CustomerRepository customerRepository;

    private final OrganizationRepository organizationRepository;

    @Autowired
    public RegisterService(RestaurantRepository restaurantRepository, CustomerRepository customerRepository, OrganizationRepository organizationRepository) {
        this.restaurantRepository = restaurantRepository;
        this.customerRepository = customerRepository;
        this.organizationRepository = organizationRepository;
    }

    public String registerRestaurant(
            String restUserName,
            String restName,
            String password,
            String phone,
            String email,
            String address,
            String certificate
    ) {
        try {
            Restaurant exist = restaurantRepository.findByRestusername(restUserName);
            if (exist != null) {
                return "Not unique username!";
            }
            Restaurant account = new Restaurant();
            account.setRestusername(restUserName);
            account.setRestname(restName);
            account.setPassword(password);
            account.setPhone(phone);
            account.setEmail(email);
            account.setAddress(address);
            account.setCertificate(certificate);
            restaurantRepository.saveAndFlush(account);
            return "";
        }
        catch (Exception e) {
            e.printStackTrace();
            return "Register Failed!";
        }
    }

    public String registerCustomer(
            String cusUserName,
            String cusName,
            String password,
            String phone,
            String email
    ) {
        try {
            Customer exist = customerRepository.findByCususername(cusUserName);
            if (exist != null) {
                return "Not unique register id!";
            }
            Customer account = new Customer();
            account.setCususername(cusUserName);
            account.setCusname(cusName);
            account.setPassword(password);
            account.setPhone(phone);
            account.setEmail(email);
            customerRepository.saveAndFlush(account);
            return "";
        }
        catch (Exception e) {
            e.printStackTrace();
            return "Register Failed!";
        }

    }
    public String registerOrganization(
            String orgUserName,
            String orgName,
            String password,
            String phone,
            String email,
            String address
    ) {
        try {
            Organization exist = organizationRepository.findByOrgusername(orgUserName);
            if (exist != null) {
                return "Not unique register id!";
            }
            Organization account = new Organization();
            account.setOrgusername(orgUserName);
            account.setOrgname(orgName);
            account.setPassword(password);
            account.setEmail(email);
            account.setPhone(phone);
            account.setAddress(address);
            organizationRepository.saveAndFlush(account);
            return "";
        }
        catch (Exception e) {
            e.printStackTrace();
            return "Register Failed!";
        }
    }
}
