package com.worcester.neighbor.nourish.service;

import com.worcester.neighbor.nourish.dto.base.FaqInfo;
import com.worcester.neighbor.nourish.model.faqs.Faq;
import com.worcester.neighbor.nourish.repository.faqs.FaqRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.util.Arrays;
import java.util.List;

public class FaqServiceTest {

    @Mock
    private FaqRepository faqRepository;

    @InjectMocks
    private FaqService faqService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testShowFAQs() {
        Faq faq1 = new Faq();
        faq1.setId(1L);
        faq1.setQuestion("What is the return policy?");
        faq1.setAnswer("You can return the product within 30 days.");

        Faq faq2 = new Faq();
        faq2.setId(2L);
        faq2.setQuestion("How do I make a warranty claim?");
        faq2.setAnswer("Please contact customer service for warranty claims.");

        when(faqRepository.findAll()).thenReturn(Arrays.asList(faq1, faq2));

        List<FaqInfo> result = faqService.showFAQs();

        assertNotNull(result, "The result should not be null");
        assertEquals(2, result.size(), "There should be two FAQs");
        assertEquals("What is the return policy?", result.get(0).getQuestion(), "The question should match");
        assertEquals("You can return the product within 30 days.", result.get(0).getAnswer(), "The answer should match");
        assertEquals("How do I make a warranty claim?", result.get(1).getQuestion(), "The question should match");
        assertEquals("Please contact customer service for warranty claims.", result.get(1).getAnswer(), "The answer should match");
    }
}
