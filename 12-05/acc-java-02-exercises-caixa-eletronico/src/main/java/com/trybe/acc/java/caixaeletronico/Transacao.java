package com.trybe.acc.java.caixaeletronico;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transacao {

  private double quantia;
  private String instante;
  private String descricao;
  public Conta conta;

  /**
   * Transacao - Contrutor da classe Transacao.
   * 
   * @param quantia   - quantia.
   * @param descricao - descricao.
   */
  public Transacao(double quantia, String descricao) {
    this.quantia = quantia;
    this.descricao = descricao;
    this.instante = retornarInstante();
  }

  public double getQuantia() {
    return this.quantia;
  }

  /**
   * retornarResumoTransacao.
   * 
   * @return - retorna o resumo da transação.
   */
  public String retornarResumoTransacao() {
    String resumo = new StringBuilder()
        .append("Descrição: " + this.descricao + " ")
        .append("Quantia: " + this.quantia + " ")
        .append("Instante: " + this.instante + "\n")
        .toString();

    return resumo;
  }

  /**
   * retornarInstante.
   * 
   * @return - retorna o instante da transação.
   */
  public String retornarInstante() {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    LocalDateTime instante = LocalDateTime.now();
    String instanteFormatado = instante.format(formatter);
    return instanteFormatado;
  }
}
