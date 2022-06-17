package com.trybe.calcularidade.exception;

/**
 * Classe ArgumentoIlegalException.
 **/

@SuppressWarnings("serial")
public class ArgumentoIlegalException extends RuntimeException {

  public ArgumentoIlegalException() {
    super("Data não é número");
  }
}
