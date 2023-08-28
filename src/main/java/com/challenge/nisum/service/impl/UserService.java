package com.challenge.nisum.service.impl;

import com.challenge.nisum.dto.UserDTO;
import com.challenge.nisum.model.Phone;
import com.challenge.nisum.model.User;
import com.challenge.nisum.repository.UserRepository;
import com.challenge.nisum.service.IUserService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @SneakyThrows
    public User create(UserDTO userDTO) {
        User user = new User(userDTO.getName(),
                                   userDTO.getEmail(),
                                   userDTO.getPassword(),
                                   userDTO.getPhones().stream().map(phoneDTO ->
                                           new Phone(phoneDTO.getNumber(), phoneDTO.getCityCode(), phoneDTO.getContryCode()))
                                                .collect(Collectors.toList()));

        return userRepository.save(user);
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
