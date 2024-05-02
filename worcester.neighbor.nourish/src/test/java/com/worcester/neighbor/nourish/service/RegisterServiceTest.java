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
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.never;
import static org.mockito.ArgumentMatchers.any;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegisterServiceTest {

    @Mock
    private RestaurantRepository restaurantRepository;
    @Mock
    private CustomerRepository customerRepository;
    @Mock
    private OrganizationRepository organizationRepository;

    @InjectMocks
    private RegisterService registerService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testRegisterRestaurantSuccess() {
        when(restaurantRepository.findByRestusername("restUser")).thenReturn(null);
        when(restaurantRepository.saveAndFlush(any(Restaurant.class))).thenReturn(new Restaurant());
        assertEquals("", registerService.registerRestaurant("restUser", "Resto", "pass123", "1234567890", "email@resto.com", "123 Main St", "Cert123"));
    }

    @Test
    public void testRegisterRestaurantFailure() {
        when(restaurantRepository.findByRestusername("restUser")).thenReturn(new Restaurant());
        assertEquals("Not unique username!", registerService.registerRestaurant("restUser", "Resto", "pass123", "1234567890", "email@resto.com", "123 Main St", "Cert123"));
        verify(restaurantRepository, never()).saveAndFlush(any(Restaurant.class));
    }

    @Test
    public void testRegisterCustomerSuccess() {
        when(customerRepository.findByCususername("cusUser")).thenReturn(null);
        when(customerRepository.saveAndFlush(any(Customer.class))).thenReturn(new Customer());
        assertEquals("", registerService.registerCustomer("cusUser", "Customer Name", "pass123", "0987654321", "customer@example.com"));
    }

    @Test
    public void testRegisterCustomerFailure() {
        when(customerRepository.findByCususername("cusUser")).thenReturn(new Customer());
        assertEquals("Not unique register id!", registerService.registerCustomer("cusUser", "Customer Name", "pass123", "0987654321", "customer@example.com"));
        verify(customerRepository, never()).saveAndFlush(any(Customer.class));
    }

    @Test
    public void testRegisterOrganizationSuccess() {
        when(organizationRepository.findByOrgusername("orgUser")).thenReturn(null);
        when(organizationRepository.saveAndFlush(any(Organization.class))).thenReturn(new Organization());
        assertEquals("", registerService.registerOrganization("orgUser", "Org Name", "pass123", "1234567890", "org@example.com", "456 Main St"));
    }

    @Test
    public void testRegisterOrganizationFailure() {
        when(organizationRepository.findByOrgusername("orgUser")).thenReturn(new Organization());
        assertEquals("Not unique register id!", registerService.registerOrganization("orgUser", "Org Name", "pass123", "1234567890", "org@example.com", "456 Main St"));
        verify(organizationRepository, never()).saveAndFlush(any(Organization.class));
    }
}
