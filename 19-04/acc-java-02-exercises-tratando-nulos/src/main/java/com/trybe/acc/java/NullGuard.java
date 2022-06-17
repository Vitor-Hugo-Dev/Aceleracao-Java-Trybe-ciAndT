package com.trybe.acc.java;

public class NullGuard {

  /**
   * printa um nome.
   */
  public String printName(int divisor) {
    NullGenerator nullGenerator = new NullGenerator();
    try {
      String bob = nullGenerator.getNome(divisor);
      return bob;
    } catch (NullPointerException e) {
      return "Nome nulo";
    }
  }
}
