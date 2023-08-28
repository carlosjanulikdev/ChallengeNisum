package com.challenge.nisum.service.impl;

import com.challenge.nisum.controller.UserController;
import com.challenge.nisum.dto.RegisteredUserDTO;
import com.challenge.nisum.dto.UserDTO;
import com.challenge.nisum.exception.UserExistingException;
import com.challenge.nisum.model.Phone;
import com.challenge.nisum.model.User;
import com.challenge.nisum.repository.UserRepository;
import com.challenge.nisum.service.IUserService;
import com.challenge.nisum.util.Constants;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {

    Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    @SneakyThrows
    public RegisteredUserDTO register(UserDTO userDTO) {
        logger.info("Validating if exists email :{}", userDTO.getEmail());

        this.validateIfUserExist(userDTO.getEmail());

        User user = new User(userDTO.getName(),
                                   userDTO.getEmail(),
                                   userDTO.getPassword(),
                                   userDTO.getPhones().stream().map(phoneDTO ->
                                           new Phone(phoneDTO.getNumber(), phoneDTO.getCityCode(), phoneDTO.getCountryCode()))
                                                .collect(Collectors.toList()));

        userRepository.save(user);

        return new RegisteredUserDTO(user.getId(), user.getName(), user.getCreated(), user.getModified(), user.getLastLogin(),
            user.getToken(), user.getIsActive());
    }

    private void validateIfUserExist(String email) {
        userRepository.findByEmail(email)
                .ifPresent( p -> {
                    throw new UserExistingException(Constants.MESSAGE_EMAIL_EXISTING);
                });;
    }

    public User findById(Long id){
        return userRepository.findById(id).get();
    }

    public void deleteById(Long id){
        userRepository.deleteById(id);
    }

    public List<User> findAll(){
        return (List<User>) userRepository.findAll();
    }
}
