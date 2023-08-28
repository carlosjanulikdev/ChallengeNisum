package com.challenge.nisum.service;

import com.challenge.nisum.dto.UserDTO;
import com.challenge.nisum.model.User;

import java.util.List;

public interface IUserService {

    User create(UserDTO userDTO);
    User findById(Long id);
    void deleteById(Long id);
    List<User> findAll();
}
