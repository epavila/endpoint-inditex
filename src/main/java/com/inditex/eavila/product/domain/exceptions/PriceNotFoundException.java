package com.inditex.eavila.product.domain.exceptions;

public class PriceNotFoundException extends RuntimeException {

  public PriceNotFoundException(String message) {
    super(message);
  }

  public PriceNotFoundException(String message, Throwable cause) {
    super(message, cause);
  }
}
