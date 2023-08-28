package com.challenge.nisum.dto;

import com.challenge.nisum.model.Phone;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PhoneDTO {

    @Column(name="number")
    @NotNull(message = "El numero es obligatorio")
    private String number;

    @Column(name="citycode")
    @NotNull(message = "El citycode es obligatorio")
    private String cityCode;

    @Column(name="contrycode")
    @NotNull(message = "El contrycode es obligatorio")
    private String contryCode;

    public PhoneDTO() {
    }

    public PhoneDTO(String number, String cityCode, String contryCode) {
        this.number = number;
        this.cityCode = cityCode;
        this.contryCode = contryCode;
    }
}
