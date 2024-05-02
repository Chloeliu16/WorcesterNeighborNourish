package com.worcester.neighbor.nourish.service;

import com.worcester.neighbor.nourish.model.faqs.FaqContact;
import com.worcester.neighbor.nourish.repository.faqs.FaqContactRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ContactServiceTest {

    @Mock
    private FaqContactRepository faqContactRepository;

    @InjectMocks
    private ContactService contactService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testContactAddSuccess() {
        String type = "Query";
        String email = "user@example.com";
        String name = "John Doe";
        String detail = "More information needed.";

        FaqContact mockFaqContact = new FaqContact();
        mockFaqContact.setType(type);
        mockFaqContact.setEmail(email);
        mockFaqContact.setName(name);
        mockFaqContact.setDetail(detail);

        when(faqContactRepository.saveAndFlush(org.mockito.ArgumentMatchers.any(FaqContact.class))).thenReturn(mockFaqContact);

        String result = contactService.contactAdd(type, email, name, detail);

        assertEquals("", result, "The result should be an empty string indicating success.");
        verify(faqContactRepository).saveAndFlush(org.mockito.ArgumentMatchers.any(FaqContact.class));
    }


    @Test
    public void testContactAddFailure() {
        String type = "Query";
        String email = "user@example.com";
        String name = "John Doe";
        String detail = "More information needed.";

        doThrow(new RuntimeException("Database error")).when(faqContactRepository).saveAndFlush(org.mockito.ArgumentMatchers.any(FaqContact.class));

        String result = contactService.contactAdd(type, email, name, detail);

        assertEquals("Information input failed.", result, "The result should indicate a failure to input information.");
    }
}
