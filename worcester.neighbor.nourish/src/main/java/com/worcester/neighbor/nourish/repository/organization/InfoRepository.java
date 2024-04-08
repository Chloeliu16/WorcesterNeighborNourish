package com.worcester.neighbor.nourish.repository.organization;

import com.worcester.neighbor.nourish.model.organization.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InfoRepository extends JpaRepository<Activity, Long> {
    List<Activity> findAll();
    List<Activity> findByOrgUsername(String orgUsername);
    Activity saveAndFlush(Activity activity);
}
