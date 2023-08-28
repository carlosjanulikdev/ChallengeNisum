package com.challenge.nisum.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class RegisteredUserDTO {

    private Long id;

    private String name;

    private LocalDateTime created;

    private LocalDateTime modified;

    @JsonProperty("last_login")
    private LocalDateTime lastLogin;

    private String token;

    @JsonProperty("is_active")
    private Boolean isActive;

    public RegisteredUserDTO(Long id, String name, LocalDateTime created, LocalDateTime modified, LocalDateTime lastLogin, String token, Boolean isActive) {
        this.id = id;
        this.name = name;
        this.created = created;
        this.modified = modified;
        this.lastLogin = lastLogin;
        this.token = token;
        this.isActive = isActive;
    }

    public LocalDateTime getLastLogin() {
        return lastLogin != null ? lastLogin : created;
    }
}
