package com.challenge.nisum.service.impl;

import com.challenge.nisum.exception.CityNotFoundException;
import com.challenge.nisum.exception.CountryNotFoundException;
import com.challenge.nisum.exception.UserExistingException;
import com.challenge.nisum.model.City;
import com.challenge.nisum.model.Country;
import com.challenge.nisum.model.Phone;
import com.challenge.nisum.model.User;
import com.challenge.nisum.repository.CityRepository;
import com.challenge.nisum.repository.CountryRepository;
import com.challenge.nisum.repository.UserRepository;
import com.challenge.nisum.request.PhoneRequest;
import com.challenge.nisum.request.UserRequest;
import com.challenge.nisum.response.UserResponse;
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
    private CityRepository cityRepository;
    @Autowired
    private CountryRepository countryRepository;
    @Autowired
    private UserRepository userRepository;

    @SneakyThrows
    public UserResponse register(UserRequest userRequest) {
        logger.info("Validating if exists email :{}", userRequest.getEmail());
        this.validateIfUserExist(userRequest.getEmail());

        User user = new User(userRequest.getName(),
                                   userRequest.getEmail(),
                                   userRequest.getPassword(),
                                   userRequest.getPhones().stream().map(phoneRequest ->
                                           fromPhoneRequestToPhone(phoneRequest))
                                                   .collect(Collectors.toList()));
        userRepository.save(user);

        return new UserResponse(user.getId(), user.getName(), user.getCreated(), user.getModified(), user.getLastLogin(),
            user.getToken(), user.getIsActive());
    }

    private void validateIfUserExist(String email) {
        userRepository.findByEmail(email)
                .ifPresent( p -> {
                    logger.error("The email: {} already exists", email );
                    throw new UserExistingException(Constants.MESSAGE_EMAIL_EXISTING);
                });;
    }

    private Phone fromPhoneRequestToPhone(PhoneRequest phoneRequest) {
        Country country = countryRepository.findById(Long.parseLong(phoneRequest.getCountryCode()))
                .orElseThrow(() ->
                        new CountryNotFoundException("No existe el pais con id: "+phoneRequest.getCountryCode()));

        City city = cityRepository.findById(Long.parseLong(phoneRequest.getCityCode()))
                .orElseThrow(() ->
                        new CityNotFoundException("No existe la ciudad con id: "+phoneRequest.getCityCode()));

        return new Phone(phoneRequest.getNumber(), city, country);
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
