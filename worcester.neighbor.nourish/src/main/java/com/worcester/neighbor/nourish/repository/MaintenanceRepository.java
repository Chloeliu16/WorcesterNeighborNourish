package com.worcester.neighbor.nourish.repository;

import com.worcester.neighbor.nourish.model.Maintenance.Maintenance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaintenanceRepository extends JpaRepository<Maintenance, Long> {
    List<Maintenance> findAll();
}
