package com.worcester.neighbor.nourish.repository.faqs;

import com.worcester.neighbor.nourish.model.faqs.FaqContact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FaqContactRepository extends JpaRepository<FaqContact, Long>{
        FaqContact saveAndFlush(FaqContact faqContact);
}
