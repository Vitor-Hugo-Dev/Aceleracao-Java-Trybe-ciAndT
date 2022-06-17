package com.trybe.acc.java;

public class Nota {

  /**
   * Nota.
   * 
   * @param n1 - nota 1
   * @param n2 - nota 2
   * @param n3 - nota 3
   * @param n4 - nota 4
   */
  public double calcularMedia(double n1, double n2, double n3, double n4) {

    double media = (n1 + n2 + n3 + n4) / 4;

    return media;
  }
}
