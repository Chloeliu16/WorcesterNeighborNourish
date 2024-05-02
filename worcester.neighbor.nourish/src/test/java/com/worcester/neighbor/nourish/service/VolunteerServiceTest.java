package com.worcester.neighbor.nourish.service;

import com.worcester.neighbor.nourish.model.Volunteer.Volunteer;
import com.worcester.neighbor.nourish.repository.Volunteer.VolunteerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class VolunteerServiceTest {

    @Mock
    private VolunteerRepository volunteerRepository;

    @InjectMocks
    private VolunteerService volunteerService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testVolunteerAdd_Success() {
        String name = "John";
        String age = "30";
        String career = "Teacher";
        String email = "johndoe@example.com";
        String phone = "1234567890";
        String city = "Anytown";
        String zipcode = "12345";
        String availability = "Weekends";

        Volunteer volunteer = new Volunteer();
        volunteer.setName(name);
        volunteer.setAge(age);
        volunteer.setCareer(career);
        volunteer.setEmail(email);
        volunteer.setPhone(phone);
        volunteer.setCity(city);
        volunteer.setZipcode(zipcode);
        volunteer.setAvailability(availability);

        when(volunteerRepository.saveAndFlush(any(Volunteer.class))).thenReturn(volunteer);

        String result = volunteerService.volunteerAdd(name, age, career, email, phone, city, zipcode, availability);

        assertEquals("", result);
        verify(volunteerRepository).saveAndFlush(any(Volunteer.class));
    }

    @Test
    public void testVolunteerAdd_Failure() {
        String name = "Jane";
        String age = "28";
        String career = "Engineer";
        String email = "janedoe@example.com";
        String phone = "0987654321";
        String city = "Othertown";
        String zipcode = "54321";
        String availability = "Weekdays";

        when(volunteerRepository.saveAndFlush(any(Volunteer.class))).thenThrow(new RuntimeException("Database Error"));

        String result = volunteerService.volunteerAdd(name, age, career, email, phone, city, zipcode, availability);

        assertEquals("Donor Register Failed!", result);
    }
}
