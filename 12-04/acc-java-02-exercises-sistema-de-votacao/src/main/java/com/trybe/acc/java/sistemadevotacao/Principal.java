package com.trybe.acc.java.sistemadevotacao;

import java.util.Scanner;

public class Principal {

  /**
   * Principal.
   */
  public static void main(String[] args) {

    GerenciamentoVotacao gerenciamentoVotacao = new GerenciamentoVotacao();
    Scanner scan = new Scanner(System.in);
    boolean loop1 = true;
    System.out.println("----------- Bem-vindo ao Sistema de Votação -----------\n");
    while (loop1) {
      StringBuilder message1 =
          new StringBuilder().append("Cadastrar pessoa candidata?\n").append("1 - Sim\n")
              .append("2 - Não\n").append("Entre com o número correspondente à opção desejada:");
      System.out.println(message1);
      short response = scan.nextShort();
      if (response == 1) {
        System.out.println("Entre com o nome da pessoa candidata:");
        String nome = scan.next();

        System.out.println("Entre com o número da pessoa candidata:");
        int numero = scan.nextInt();

        gerenciamentoVotacao.cadastrarPessoaCandidata(nome, numero);

      } else if (response == 2) {
        loop1 = false;
      }

    }

    boolean loop2 = true;
    while (loop2) {
      StringBuilder message2 =
          new StringBuilder().append("Cadastrar pessoa eleitora?\n").append("1 - Sim\n")
              .append("2 - Não\n").append("Entre com o número correspondente à opção desejada:");
      System.out.println(message2);
      short response = scan.nextShort();
      if (response == 1) {
        System.out.println("Entre com o nome da pessoa eleitora:");
        String nome = scan.next();
        System.out.println("Entre com o cpf da pessoa eleitora:");
        String cpf = scan.next();
        gerenciamentoVotacao.cadastrarPessoaEleitora(nome, cpf);
      } else if (response == 2) {
        loop2 = false;
      }
    }

    boolean loop3 = true;
    while (loop3) {
      StringBuilder message3 = new StringBuilder()
          .append("Entre com o número correspondente à opção desejada:\n").append("1 - Votar\n")
          .append("2 - Resultado Parcial\n").append("3 - Finalizar Votação");
      System.out.println(message3);
      short response = scan.nextShort();
      if (response == 1) {
        System.out.println("Entre com o cpf da pessoa eleitora:");
        String cpf = scan.next();

        System.out.println("Entre com o número da pessoa candidata:");
        int numero = scan.nextInt();
        gerenciamentoVotacao.votar(cpf, numero);

      } else if (response == 2) {
        gerenciamentoVotacao.mostrarResultado();
      } else if (response == 3) {
        gerenciamentoVotacao.mostrarResultado();
        loop3 = false;
      }
    }
    scan.close();
  }

}
