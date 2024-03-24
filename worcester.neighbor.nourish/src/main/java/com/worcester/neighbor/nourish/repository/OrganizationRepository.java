package com.worcester.neighbor.nourish.repository;

import com.worcester.neighbor.nourish.model.Organization;
import com.worcester.neighbor.nourish.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationRepository extends JpaRepository<Organization, Long> {
    Organization findByOrgusername(String orgusername);
    // for login
    Organization findByOrgusernameAndPassword(String orgusername, String password);
    // for register
    Organization saveAndFlush(Organization organization);
}
