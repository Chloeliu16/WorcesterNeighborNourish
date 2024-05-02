package com.worcester.neighbor.nourish.controller;

import com.worcester.neighbor.nourish.dto.request.VolunteerRequest;
import com.worcester.neighbor.nourish.dto.response.VolunteerResponse;
import com.worcester.neighbor.nourish.service.VolunteerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class VolunteerTest {

    @Mock
    private VolunteerService volunteerService;

    @InjectMocks
    private Volunteer volunteerController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testVolunteerRegister() {
        VolunteerRequest volunteerRequest = new VolunteerRequest();
        volunteerRequest.setName("John Doe");
        volunteerRequest.setAge("30");
        volunteerRequest.setCareer("Engineer");
        volunteerRequest.setEmail("john.doe@example.com");
        volunteerRequest.setPhone("1234567890");
        volunteerRequest.setCity("Springfield");
        volunteerRequest.setZipcode("12345");
        volunteerRequest.setAvailability("Weekends");

        String expectedServiceOutput = "Volunteer registered successfully";

        when(volunteerService.volunteerAdd("John Doe", "30", "Engineer", "john.doe@example.com", "1234567890", "Springfield", "12345", "Weekends"))
                .thenReturn(expectedServiceOutput);

        VolunteerResponse volunteerResponse = volunteerController.volunteerRegister(volunteerRequest);

        assertFalse(volunteerResponse.isSuccess());
        assertEquals(expectedServiceOutput, volunteerResponse.getFailureReason(), "The failure reason should match the service output");
    }
}
