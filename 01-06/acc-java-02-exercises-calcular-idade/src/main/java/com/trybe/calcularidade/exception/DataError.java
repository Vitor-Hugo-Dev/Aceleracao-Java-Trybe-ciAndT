package com.trybe.calcularidade.exception;

import java.util.Map;

/**
 * Classe DataError.
 **/

public class DataError {

  private Map<String, String> error;

  public DataError(String message) {
    this.error = Map.of("message", message);
  }

  public Map<String, String> getError() {
    return error;
  }

  public void setError(Map<String, String> error) {
    this.error = error;
  }
}
