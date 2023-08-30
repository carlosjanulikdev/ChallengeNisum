package com.challenge.nisum.service;

import com.challenge.nisum.model.User;
import com.challenge.nisum.request.UserRequest;
import com.challenge.nisum.response.UserResponse;

import java.util.List;

public interface IUserService {

    UserResponse register(UserRequest userRequest);
    User findById(Long id);
    List<User> findAll();
}
