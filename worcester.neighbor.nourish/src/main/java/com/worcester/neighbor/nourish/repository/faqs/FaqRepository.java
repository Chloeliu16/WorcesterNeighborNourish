package com.worcester.neighbor.nourish.repository.faqs;

import com.worcester.neighbor.nourish.model.faqs.Faq;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FaqRepository extends JpaRepository<Faq, Long> {

}

