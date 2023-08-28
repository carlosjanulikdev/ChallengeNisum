package com.challenge.nisum.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class UserDTO {

    @Column(name="name")
    @NotNull(message = "El nombre es obligatorio")
    private String name;

    @Column(name="email")
    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "El email no tiene un formato válido (ejemplo:aaaaaaa@dominio.cl)")
    private String email;

    @Column(name="password")
    @NotNull(message = "La password es obligatoria")
    private String password;

    private List<PhoneDTO> phones = new ArrayList<>();

}
