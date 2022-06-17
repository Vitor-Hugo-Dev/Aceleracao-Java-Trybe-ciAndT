package com.trybe.acc.java;

public class Fatorial {

  /**
   * Fatorial.
   */
  public static void main(String[] args) {
    long numero18 = 18;
    long fatorial18 = numero18;

    while (numero18 > 1) {
      fatorial18 *= (numero18 - 1);
      numero18--;
    }


    // Imprime a saída no console. OBS: descomente a próxima linha
    System.out.println("O fatorial de 18 é igual a " + fatorial18);

  }

}
