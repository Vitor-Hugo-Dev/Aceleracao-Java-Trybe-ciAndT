package com.trybe.acc.java.controledeacesso;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

  /**
   * Método principal.
   */
  public static void main(String[] args) {
    // ESCREVA SEU CÓDIGO AQUI

    Scanner scan = new Scanner(System.in);
    ArrayList<Short> peopleAge = new ArrayList<Short>();
    boolean access = true;
    while (access == true) {
      System.out.println("Entre com o número correspondente à opção desejada:\n"
          + "1 - Acessar o estabelecimento\n" + "2 - Finalizar sistema e mostrar relatório");
      short response = scan.nextShort();


      if (response == 1) {
        access = true;

        System.out.println("Entre com sua idade:");
        short age = scan.nextShort();

        if (age < 18) {
          System.out.println("Pessoa cliente menor de idade, catraca liberada!");
        } else if (age >= 18 && age < 50) {
          System.out.println("Pessoa adulta, catraca liberada!");
        } else {
          System.out.println("Pessoa adulta a partir de 50, catraca liberada!");
        }
        // System.out.println(age);
        peopleAge.add(age);
      } else if (response == 2) {
        access = false;
      } else {
        System.out.println("Entre com uma opção válida!");
      }
    }
    scan.close();

    double adolescent = 0;
    double adult = 0;
    double oldMan = 0;
    double total = peopleAge.size();
    for (int index = 0; index < peopleAge.size(); index++) {
      if (peopleAge.get(index) < 18) {
        adolescent++;
      } else if (peopleAge.get(index) >= 18 && peopleAge.get(index) < 50) {
        adult++;
      } else {
        oldMan++;
      }
    }
    DecimalFormat df = new DecimalFormat("0.0%");
    Principal calc = new Principal();

    String adolescentPercentage =
        df.format(calc.calcPercentage(adolescent, total)).replace(',', '.');;
    String adultPercentage = df.format(calc.calcPercentage(adult, total)).replace(',', '.');
    String oldManPercentage = df.format(calc.calcPercentage(oldMan, total)).replace(',', '.');

    StringBuilder stringBuilder = new StringBuilder();
    String relatorio =
        stringBuilder.append("----- Quantidade -----\n").append("menores: " + adolescent + "\n")
            .append("adultas: " + adult + "\n").append("a partir de 50: " + oldMan + "\n")
            .append("\n----- Percentual -----\n").append("menores: " + adolescentPercentage + "\n")
            .append("adultas: " + adultPercentage + "\n")
            .append("a partir de 50: " + oldManPercentage + "\n").append("\nTOTAL: " + total)
            .toString();

    System.out.println(relatorio);
  }

  /**
   * calcPercentage.
   */
  public double calcPercentage(double peoples, double total) {

    if (peoples == 0) {
      return 0;
    }
    return (peoples / total) * 1;
  }
}
