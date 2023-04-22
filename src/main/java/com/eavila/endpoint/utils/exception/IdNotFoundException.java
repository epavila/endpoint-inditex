package com.eavila.endpoint.utils.exception;

public class IdNotFoundException extends RuntimeException {

    private static final String ERROR_MESSAGE = "The record does not exist in %s";

    public IdNotFoundException(String tableName) {
        super(String.format(ERROR_MESSAGE, tableName));
    }

}
