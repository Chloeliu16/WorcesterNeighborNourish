package com.worcester.neighbor.nourish.controller;

import com.worcester.neighbor.nourish.dto.request.ContactRequest;
import com.worcester.neighbor.nourish.dto.response.ContactResponse;
import com.worcester.neighbor.nourish.service.ContactService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContactTest {

    @Mock
    private ContactService contactService;

    @InjectMocks
    private Contact contact;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testContact() {
        ContactRequest contactRequest = new ContactRequest();
        contactRequest.setType("Query");
        contactRequest.setEmail("user@example.com");
        contactRequest.setName("John Doe");
        contactRequest.setDetail("I need help");

        when(contactService.contactAdd("Query", "user@example.com", "John Doe", "I need help")).thenReturn("Success");

        ContactResponse contactResponse = contact.contact(contactRequest);

        assertEquals(false, contactResponse.isSuccess());
        assertEquals("Success", contactResponse.getFailureReason());
    }
}
