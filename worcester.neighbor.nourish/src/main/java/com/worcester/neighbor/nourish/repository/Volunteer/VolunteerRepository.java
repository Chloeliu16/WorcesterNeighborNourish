package com.worcester.neighbor.nourish.repository.Volunteer;

import com.worcester.neighbor.nourish.model.Volunteer.Volunteer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VolunteerRepository extends JpaRepository<Volunteer, Long>{
    Volunteer saveAndFlush(Volunteer volunteer);
}
