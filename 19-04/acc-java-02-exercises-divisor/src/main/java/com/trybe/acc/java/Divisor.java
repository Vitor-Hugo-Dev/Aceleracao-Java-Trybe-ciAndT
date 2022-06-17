package com.trybe.acc.java;

public class Divisor {

  /**
   * return a number int.
   * 
   */
  public static int dividir(int dividendo, int divisor) {
    try {
      int divisao = dividendo / divisor;
      System.out.println("Divisão realizada com sucesso!");
      return divisao;
    } catch (ArithmeticException e) {
      System.out.println("Divisão por zero não é permitida!");
      return 0;
    }
  }

}
