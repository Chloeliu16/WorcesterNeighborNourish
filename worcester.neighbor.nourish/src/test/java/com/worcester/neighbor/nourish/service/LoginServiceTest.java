package com.worcester.neighbor.nourish.service;

import com.worcester.neighbor.nourish.model.organization.Organization;
import com.worcester.neighbor.nourish.model.restaurant.Restaurant;
import com.worcester.neighbor.nourish.model.customer.Customer;
import com.worcester.neighbor.nourish.repository.organization.OrganizationRepository;
import com.worcester.neighbor.nourish.repository.restaurant.RestaurantRepository;
import com.worcester.neighbor.nourish.repository.customer.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginServiceTest {

    @Mock
    private RestaurantRepository restaurantRepository;
    @Mock
    private CustomerRepository customerRepository;
    @Mock
    private OrganizationRepository organizationRepository;

    @InjectMocks
    private LoginService loginService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testLoginRestaurantSuccess() {
        when(restaurantRepository.findByRestusernameAndPassword("restUser", "pass123")).thenReturn(new Restaurant());
        assertEquals("", loginService.loginRestaurant("restUser", "pass123"));
    }

    @Test
    public void testLoginRestaurantFailure() {
        when(restaurantRepository.findByRestusernameAndPassword("restUser", "wrongPass")).thenReturn(null);
        assertEquals("Account does not exist or wrong password!", loginService.loginRestaurant("restUser", "wrongPass"));
    }

    @Test
    public void testLoginCustomerSuccess() {
        when(customerRepository.findByCususernameAndPassword("cusUser", "pass123")).thenReturn(new Customer());
        assertEquals("", loginService.loginCustomer("cusUser", "pass123"));
    }

    @Test
    public void testLoginCustomerFailure() {
        when(customerRepository.findByCususernameAndPassword("cusUser", "wrongPass")).thenReturn(null);
        assertEquals("Account does not exist or wrong password!", loginService.loginCustomer("cusUser", "wrongPass"));
    }

    @Test
    public void testLoginOrganizationSuccess() {
        when(organizationRepository.findByOrgusernameAndPassword("orgUser", "pass123")).thenReturn(new Organization());
        assertEquals("", loginService.loginOrgnization("orgUser", "pass123"));
    }

    @Test
    public void testLoginOrganizationFailure() {
        when(organizationRepository.findByOrgusernameAndPassword("orgUser", "wrongPass")).thenReturn(null);
        assertEquals("Account does not exist or wrong password!", loginService.loginOrgnization("orgUser", "wrongPass"));
    }
}
