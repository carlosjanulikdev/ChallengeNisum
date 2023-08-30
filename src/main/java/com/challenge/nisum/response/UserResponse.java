package com.challenge.nisum.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserResponse {

    private Long id;

    private String name;

    private LocalDateTime created;

    private LocalDateTime modified;

    @JsonProperty("last_login")
    private LocalDateTime lastLogin;

    private String token;

    @JsonProperty("is_active")
    private Boolean isActive;

    public UserResponse(){

    }

    public UserResponse(Long id, String name, LocalDateTime created, LocalDateTime modified, LocalDateTime lastLogin, String token, Boolean isActive) {
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
