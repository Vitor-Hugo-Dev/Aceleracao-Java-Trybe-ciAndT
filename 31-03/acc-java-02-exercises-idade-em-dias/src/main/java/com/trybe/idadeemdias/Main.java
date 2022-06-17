package com.trybe.idadeemdias;

import java.util.Scanner;

public class Main {

  /** Main. */
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    System.out.println("Qual é o seu nome?");
    String nome = scan.next();

    System.out.println("Qual é sua idade em anos, meses e dias?");
    System.out.println("anos");
    int anos = Integer.parseInt(scan.next());

    System.out.println("meses:");
    int meses = Integer.parseInt(scan.next());

    System.out.println("dias");
    int dias = Integer.parseInt(scan.next());

    Pessoa pessoa = new Pessoa();
    int resposta = pessoa.calcularIdadeEmDias(anos, meses, dias);
    System.out.println("Olá " + nome + ", sua idade em dias é " + resposta);
    scan.close();
  }

}
