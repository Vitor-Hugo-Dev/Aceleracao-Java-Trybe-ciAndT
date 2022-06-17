package com.trybe.acc.java;

import java.time.LocalDateTime;

public class SimuladorRendimento {

  /**
   * validação.
   * 
   * @param args não utilizado
   */
  public static void main(String[] args) {
    SimuladorRendimento obj = new SimuladorRendimento();
    double inicial = 500;
    double objetivo = 5000;
    System.out.println("Com " + inicial + " seu rendimento será " + objetivo
        + " no ano " + obj.simularRendimentoAnos(inicial, objetivo));
  }

  /**
   * simulação de rendimento.
   * 
   * @param valorInicial valor inicial.
   * @param objetivo     objetivo.
   * @return ano de simulação.
   */
  public int simularRendimentoAnos(double valorInicial, double objetivo) {
    LocalDateTime dataAtual = LocalDateTime.now();

    double valorAtual = valorInicial;
    int anos = 0;

    while (valorAtual <= objetivo) {
      valorAtual = valorAtual * 1.1;
      anos++;
    }
    return dataAtual.plusYears(anos).getYear();
  }
}
