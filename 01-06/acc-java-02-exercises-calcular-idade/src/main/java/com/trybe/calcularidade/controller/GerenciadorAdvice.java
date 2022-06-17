package com.trybe.calcularidade.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.trybe.calcularidade.exception.ArgumentoIlegalException;
import com.trybe.calcularidade.exception.DataError;
import com.trybe.calcularidade.exception.DataFuturaException;
import com.trybe.calcularidade.exception.DataInvalidaException;

/**
 * Classe GerenciadorAdvice.
 **/
@ControllerAdvice
public class GerenciadorAdvice {

  @ExceptionHandler({
      DataFuturaException.class,
      DataInvalidaException.class,
  })
  public ResponseEntity<Map<String, String>> handleException(
      RuntimeException error) {
    DataError dataError = new DataError(error.getMessage());

    return ResponseEntity.badRequest().body(dataError.getError());
  }

  @ExceptionHandler(ArgumentoIlegalException.class)
  public ResponseEntity<Map<String, String>> handlerInternalServerError(
      RuntimeException error) {

    DataError dataError = new DataError(error.getMessage());

    return ResponseEntity.internalServerError().body(dataError.getError());
  }
}