package com.challenge.nisum.request;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class UserRequest {

    @Column(name="name")
    @NotNull(message = "El nombre es obligatorio")
    @Schema(description = "Nombre", example = "Nombre completo")
    private String name;

    @Column(name="email")
    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "El email no tiene un formato válido (ejemplo:aaaaaaa@dominio.cl)")
    @Schema(description = "Correo electrónico", example = "aaaaaaa@dominio.cl")
    private String email;

    @Column(name="password")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{7,}$", message = "La password debe tener mínimo 7 caracteres, al menos una letra y un número")
    @Schema(description = "clave", example = "La password debe tener mínimo 7 caracteres, al menos una letra y un número")
    private String password;

    private List<PhoneRequest> phones = new ArrayList<>();

}
