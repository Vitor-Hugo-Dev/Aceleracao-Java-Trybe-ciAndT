package com.betrybe.acc.java.bankaccount;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * A class.
 */
public class Application {
  /**
   * A simple get method.
   */
  public static void main(String[] args) {
    AccountNumberFormatter accountNumberFormatter = new AccountNumberFormatter();
    Scanner scan = new Scanner(System.in);

    try {
      System.out.println("Informe o número da conta:");
      int numero = scan.nextInt();
      System.out.println("Numero da conta: " + accountNumberFormatter.formatAccountNumber(numero));
    } catch (InputMismatchException e) {
      System.out.println("Numero da conta inválido!");
    }
    scan.close();
  }

}
