package com.trybe.acc.java.excecaomaioridade;

public class PessoaMenorDeIdadeException extends Exception {

  public PessoaMenorDeIdadeException() {
    super("pessoa menor de 18 anos!");
  }
}
