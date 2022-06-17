package com.trybe.acc.java;

import java.util.Locale;
import java.util.Scanner;

public class ConverteBytes {

  /**
   * ConverteBytes.
   */
  public static void main(String[] args) {
    // Ler a entrada de um número pelo console
    Scanner scan = new Scanner(System.in).useLocale(Locale.US);

    System.out.println("Digite um número:");
    byte valor = scan.nextByte();
    scan.close();

    int qtdBits = valor * 8;


    // Imprime a saída no console. OBS: descomente a próxima linha
    System.out.println(valor + " bytes correspodem a " + qtdBits + " bits");
  }
}
