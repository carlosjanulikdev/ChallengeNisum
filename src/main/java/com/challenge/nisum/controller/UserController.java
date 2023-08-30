package com.challenge.nisum.controller;

import com.challenge.nisum.model.User;
import com.challenge.nisum.request.UserRequest;
import com.challenge.nisum.response.UserResponse;
import com.challenge.nisum.service.IUserService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private IUserService userService;

    /**
     *
     * @param id
     * @return a user by id
     */
    @GetMapping(value = "/get/{id}")
    public User findById(@PathVariable(required = true) Long id){
        logger.info("Id:{}", id);

        return userService.findById(id);
    }

    @PostMapping(value = "/register")
    public ResponseEntity<UserResponse> register(@Valid @RequestBody UserRequest userRequest) {
        logger.info("Create user:{}", userRequest);
        UserResponse newUser = userService.register(userRequest);

        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    /**
     *
     * @return a JSON with all users
     */
    @GetMapping(value = "/findAll")
    public @ResponseBody Iterable<User> findAll() {
        return userService.findAll();
    }
}
