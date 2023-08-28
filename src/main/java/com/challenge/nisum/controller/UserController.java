package com.challenge.nisum.controller;

import com.challenge.nisum.dto.RegisteredUserDTO;
import com.challenge.nisum.dto.UserDTO;
import com.challenge.nisum.model.User;
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

    @DeleteMapping(value = "/delete/{id}")
    public void deleteById(@PathVariable(required = true) Long id){
        logger.info("User id to delete:{}", id);

        userService.deleteById(id);
    }


    @PostMapping(value = "/register")
    public ResponseEntity<RegisteredUserDTO> register(@Valid @RequestBody UserDTO userDTO) {
        logger.info("Create user:{}", userDTO);
        RegisteredUserDTO newUser = userService.register(userDTO);

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
