package com.challenge.nisum.model;


import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Data
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO,generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private Long id;

    @Column(name="name")
    @NotNull(message = "El nombre es obligatorio")
    private String name;

    @Column(name="email")
    private String email;

    @Column(name="password")
    @NotNull(message = "La password es obligatoria")
    private String password;

    @Column(name="created")
    private LocalDateTime created;

    @Column(name="modified")
    private LocalDateTime modified;

    @Column(name="last_login")
    @JsonProperty("last_login")
    private LocalDateTime lastLogin;

    @Column(name="token")
    private String token;

    @Column(name="is_active")
    @JsonProperty("is_active")
    private Boolean isActive;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Phone> phones = new ArrayList<>();

    public void addPhone(Phone phone) {
        phones.add(phone);
        phone.setUser(this);
    }

    public void removePhone(Phone phone) {
        phones.remove(phone);
        phone.setUser(null);
    }

    public User(){

    }

    public User(String name, String email, String password, List<Phone> phones) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.created = LocalDateTime.now();
        this.isActive = true;

        phones.stream().forEach( p -> this.addPhone(p));
    }

    public LocalDateTime getLastLogin(){
        return lastLogin != null ? lastLogin : created;
    }
}
