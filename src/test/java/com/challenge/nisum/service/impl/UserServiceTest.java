package com.challenge.nisum.service.impl;

import com.challenge.nisum.model.City;
import com.challenge.nisum.model.Country;
import com.challenge.nisum.model.User;
import com.challenge.nisum.repository.CityRepository;
import com.challenge.nisum.repository.UserRepository;
import com.challenge.nisum.request.UserRequest;
import com.challenge.nisum.response.UserResponse;
import com.challenge.nisum.util.JsonFileUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
    @Mock
    private CityRepository cityRepository;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    private City cityMock;

    private User userMock;

    UserRequest userRequest;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Before
    public void setup() throws IOException {
        objectMapper.registerModule(new JavaTimeModule()); //to convert LocalDateTime from json file

        cityMock = new City(3L, "Santiago de Chile", new Country(3L, "Chile"));
        userMock = new User("Juan Perez", "juan.perez@gmail.com", "perezjuan1", null);
        userRequest = objectMapper.readValue(JsonFileUtils.readFileFromClasspath("UserRequest1.json"), UserRequest.class);

        when(cityRepository.findByIdAndCountryId(3L, 3L)).thenReturn(Optional.of(cityMock));
    }

    @Test
    public void registerOK(){
        when(userRepository.save(any())).thenReturn(userMock);
        when(cityRepository.findByIdAndCountryId(3L, 3L)).thenReturn(Optional.of(cityMock));

        UserResponse userResponse = userService.register(userRequest);

        Assert.assertNotNull(userResponse.getCreated());
        Assert.assertTrue(userResponse.getIsActive());
    }

    @Test
    public void findUserByEmailOK(){
        when(userRepository.findByEmail(Mockito.anyString())).thenReturn(Optional.ofNullable(userMock));

        Optional<User> foundUser = userRepository.findByEmail("juan.perez@gmail.com");

        assertTrue(foundUser.isPresent());
        assertEquals("juan.perez@gmail.com", foundUser.get().getEmail());
    }

    @Test
    public void findUserByEmailNotFound(){
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

}
