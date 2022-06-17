package com.trybe.acc.java.planejamentodeviagem;

public class Voo {
  private int tempoVoo;

  /**
   * Método para retornar tempo de Voo.
   * 
   */
  public int retornarTempoVoo(double distanciaKm) {

    Double duracaoDouble = distanciaKm / 700.0;

    tempoVoo = duracaoDouble.intValue();

    return tempoVoo;
  }

  /**
   * Método para retornar informaçao do Voo.
   * 
   */
  public String retornarInformacaoVoo(String embarque, String origem, String desembarque,
      String destino) {
    StringBuilder informacaoVoo = new StringBuilder();
    return informacaoVoo
        .append("EMBARQUE: " + embarque)
        .append("\nORIGEM: " + origem)
        .append("\nDESEMBARQUE: " + desembarque)
        .append("\nDESTINO: " + destino)
        .toString();
  }
}
