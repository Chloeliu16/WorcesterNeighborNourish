package com.worcester.neighbor.nourish.repository.faqs;

import com.worcester.neighbor.nourish.model.faqs.ContactHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<ContactHistory, Long>{
        ContactHistory saveAndFlush(ContactHistory contactHistory);
}
