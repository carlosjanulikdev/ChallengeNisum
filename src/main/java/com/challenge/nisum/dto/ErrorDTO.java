package com.challenge.nisum.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorDTO {

    @JsonProperty("mensaje")
    private String message;
}
