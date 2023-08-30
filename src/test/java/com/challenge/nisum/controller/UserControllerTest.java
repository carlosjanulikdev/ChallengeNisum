package com.challenge.nisum.controller;

import com.challenge.nisum.request.UserRequest;
import com.challenge.nisum.response.UserResponse;
import com.challenge.nisum.service.IUserService;
import com.challenge.nisum.util.JsonFileUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.IOException;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {

    @Mock
    IUserService userServiceMock;
    @InjectMocks
    private UserController userController;

    UserRequest userRequest;
    UserResponse userResponse;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Before
    public void setUp() throws IOException {
        objectMapper.registerModule(new JavaTimeModule()); //to convert LocalDateTime from json file

        userRequest = objectMapper.readValue(JsonFileUtils.readFileFromClasspath("UserRequest.json"), UserRequest.class);
        userResponse = objectMapper.readValue(JsonFileUtils.readFileFromClasspath("UserResponse.json"), UserResponse.class);
    }

    @Test
    public void registerOK(){
        when(userServiceMock.register(userRequest)).thenReturn(userResponse);

        ResponseEntity<UserResponse> responseEntity = userController.register(userRequest);

        Assert.assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        Assert.assertNotNull(responseEntity.getBody().getCreated());
        Assert.assertTrue(responseEntity.getBody().getIsActive());
    }

}
