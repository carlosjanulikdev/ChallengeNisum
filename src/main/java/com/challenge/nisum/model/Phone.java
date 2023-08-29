package com.challenge.nisum.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Data
@Table(name="phones")
public class Phone {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO,generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private Long id;

    @Column(name="number")
    @NotNull(message = "El numero es obligatorio")
    private String number;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="city_code", nullable=false)
    private City city;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Override
    public String toString() {
        return "Phone{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", city=" + city +
                ", user=" + user +
                '}';
    }

    public Phone() {
    }

    public Phone(String number, City city) {
        this.number = number;
        this.city = city;
    }
}
