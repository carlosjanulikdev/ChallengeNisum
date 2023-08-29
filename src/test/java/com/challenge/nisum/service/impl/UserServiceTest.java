package com.challenge.nisum.service.impl;

import com.challenge.nisum.model.City;
import com.challenge.nisum.model.Country;
import com.challenge.nisum.model.User;
import com.challenge.nisum.repository.CityRepository;
import com.challenge.nisum.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@TestPropertySource(locations = "classpath:application-test.properties")
@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    private CityRepository cityRepository;

    private City cityMock;

    private User userMock;

    @Autowired
    private UserRepository userRepository;

    @Before
    public void setup() {
        cityMock = new City(3L, "Santiago de Chile", new Country(3L, "Chile"));
        userMock = new User("Carlos Janulik", "jancaan@gmail.com", "pass1234", null);

        when(cityRepository.findByIdAndCountryId(3L, 3L)).thenReturn(Optional.of(cityMock));
    }

    @Test
    public void findUserByEmailOK(){
        Mockito.when(userRepository.findByEmail(Mockito.anyString())).thenReturn(Optional.ofNullable(userMock));

        Optional<User> foundUser = userRepository.findByEmail("jancaan@gmail.com");

        assertTrue(foundUser.isPresent());
        assertEquals("jancaan@gmail.com", foundUser.get().getEmail());
    }

    @Test
    public void findUserByEmailNotFound(){
        Mockito.when(userRepository.findByEmail("jancaan@gmail.com")).thenReturn(Optional.ofNullable(userMock));

        Optional<User> foundUser = userRepository.findByEmail("mirtha.lopez@gmail.com");

        assertEquals(Optional.empty(), foundUser);
    }

    @Test
    public void findCityByIdAndCountryIdOK() {
        Optional<City> foundCity = cityRepository.findByIdAndCountryId(3L, 3L);

        assertTrue(foundCity.isPresent());
        assertEquals("Chile", foundCity.get().getCountry().getName());
    }

    @Test
    public void findCityByIdAndCountryIdNotFound() {
        Optional<City> foundCity = cityRepository.findByIdAndCountryId(1L, 57L);

        assertEquals(Optional.empty(), foundCity);
    }

    @TestConfiguration
    public static class UserServiceTestConfiguration {
        @Bean
        UserRepository userRepository() {
            return mock(UserRepository.class);
        }

    }

}
