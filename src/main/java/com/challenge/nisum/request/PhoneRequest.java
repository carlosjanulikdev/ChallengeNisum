package com.challenge.nisum.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PhoneRequest {

    @Column(name="number")
    @NotNull(message = "El numero es obligatorio")
    @Schema(description = "Número", example = "+54 1112123232")
    private String number;

    @Column(name="city_code")
    @JsonProperty("city_code")
    @NotNull(message = "El city_code es obligatorio")
    @Schema(description = "Código de ciudad", example = "1")
    private String cityCode;

    @Column(name="country_code")
    @JsonProperty("country_code")
    @NotNull(message = "El country_code es obligatorio")
    @Schema(description = "Código de país", example = "1")
    private String countryCode;

    public PhoneRequest() {
    }

    public PhoneRequest(String number, String cityCode, String countryCode) {
        this.number = number;
        this.cityCode = cityCode;
        this.countryCode = countryCode;
    }
}
