package com.eavila.endpoint.utils.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;



@AllArgsConstructor
@Data
@Builder
public class Error implements Serializable {

    private String status = "hola";
    private String code;
    private String message;

    public Error() {
        this.status = "BAD_REQUEST";
        this.code = "400";
        this.message = "The record does not exist in price";
    }

    /*public Error(String status, String code, String message) {
        this(status, code, message);
    }*/

    /*Error(String status, String code, String message) {
        if (timestamp == null) {
            throw new IllegalArgumentException("Timestamp cannot be null");
        } else {
            this.timestamp = timestamp;
            if (internal != null && internal.getCode() != null) {
                this.internal = internal;
            } else {
                throw new IllegalArgumentException("Return code cannot be null");
            }
        }
    }*/

}
