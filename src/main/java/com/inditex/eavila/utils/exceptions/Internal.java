package com.inditex.eavila.utils.exceptions;

import java.io.Serializable;
import java.util.Map;

import com.inditex.eavila.config.swagger.OpenApiDocs;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@JsonPropertyOrder({"code", "details", "message", "service", "status"})
@Data
public class Internal implements Serializable {

    private HttpStatus status;
    private OpenApiDocs.ReturnCode code;
    private String message;
    private String service;
    private Map<String, String> detalis;

    @JsonCreator
    public Internal(HttpStatus status, OpenApiDocs.ReturnCode code, String message, String service, Map<String, String> detalis) {
        this.status = status;
        this.code = code;
        this.message = message;
        this.service = service;
        this.detalis = detalis;
    }
}
