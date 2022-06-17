package com.trybe.acc.java;

import java.util.Scanner;

public class Main {

  /**
   * Main.
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Scanner scan = new Scanner(System.in);
    System.out.println("Qual é o seu nome?");
    String nome = scan.next();

    double[] notas = new double[4];
    int index = 0;

    System.out.println("Entre com as notas:");
    while (index < 4) {
      System.out.println("Prova " + (index + 1) + ":");
      notas[index] = Double.parseDouble(scan.next());
      index++;
    }

    Nota nota = new Nota();
    double media = nota.calcularMedia(notas[0], notas[1], notas[2], notas[3]);

    System.out.println("Olá, " + nome + ", sua média é " + media);
    scan.close();
  }

}
