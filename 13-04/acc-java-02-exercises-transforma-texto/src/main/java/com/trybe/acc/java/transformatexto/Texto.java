package com.trybe.acc.java.transformatexto;

public class Texto {

  /**
   * transformaTexto.
   */
  public String transformaTexto(String frase) {

    String format = frase.replace("+", " ");

    String[] arrayString = format.split(" ");

    int indA = format.indexOf("a");

    if (indA % 2 == 0) {
      return format.toUpperCase();
    } else {
      return arrayString[0];
    }
  }
}
