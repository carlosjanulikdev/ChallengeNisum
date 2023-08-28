package com.challenge.nisum.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class UserDTO {

    @Column(name="name")
    @NotNull(message = "El nombre es obligatorio")
    private String name;

    @Column(name="email")
    @
    private String email;

    @Column(name="password")
    @NotNull(message = "La password es obligatoria")
    private String password;

    private List<PhoneDTO> phones = new ArrayList<>();

}
