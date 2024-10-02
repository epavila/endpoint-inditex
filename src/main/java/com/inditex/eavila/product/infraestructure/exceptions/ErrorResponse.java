package com.inditex.eavila.product.infraestructure.exceptions;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class ErrorResponse implements Serializable {

    private String status;
    private String code;
    private String message;

    private List<String> errors;

    public ErrorResponse() {
        this.status = "BAD_REQUEST";
        this.code = "400";
        this.message = "The record does not exist in price";
    }

    public ErrorResponse(String message, List<String> errors) {
        this.message = message;
        this.errors = errors;
    }

}
