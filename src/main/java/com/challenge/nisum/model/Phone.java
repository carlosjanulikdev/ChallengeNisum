package com.challenge.nisum.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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

    @Column(name="citycode")
    @NotNull(message = "El citycode es obligatorio")
    private String cityCode;

    @Column(name="contrycode")
    @NotNull(message = "El contrycode es obligatorio")
    private String contryCode;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Override
    public String toString() {
        return "Phone{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", cityCode='" + cityCode + '\'' +
                ", contryCode='" + contryCode + '\'' +
                '}';
    }

    public Phone() {
    }

    public Phone(String number, String cityCode, String contryCode) {
        this.number = number;
        this.cityCode = cityCode;
        this.contryCode = contryCode;
    }
}
