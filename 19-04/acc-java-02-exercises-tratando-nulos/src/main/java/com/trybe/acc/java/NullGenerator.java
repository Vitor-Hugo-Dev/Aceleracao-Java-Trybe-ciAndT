package com.trybe.acc.java;

public class NullGenerator {
  
  /**
   * retorna um nome.
   * 
   */
  public String getNome(int numero) {
    if (numero % 2 == 0) {
      return "BOB";
    } else {
      throw new NullPointerException();
    }
  }
}
