package com.worcester.neighbor.nourish.repository.donation;


import com.worcester.neighbor.nourish.model.donation.Donation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonationRepository extends JpaRepository<Donation, Long> {
    Donation saveAndFlush(Donation donation);
}

