package com.trybe.gestaotime.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * Classe Documento.
 */
@Entity
public class Documento {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String cpf;

  private String numeroCarteiraTrabalho;

  private String numeroCbf;

  @OneToOne(fetch = FetchType.LAZY)
  private Jogador jogador;

  public Jogador getJogador() {
    return this.jogador;
  }

  public void setJogador(Jogador jogador) {
    this.jogador = jogador;
  }

  public Integer getId() {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getCpf() {
    return this.cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public String getNumeroCarteiraTrabalho() {
    return this.numeroCarteiraTrabalho;
  }

  public void setNumeroCarteiraTrabalho(String numeroCarteiraTrabalho) {
    this.numeroCarteiraTrabalho = numeroCarteiraTrabalho;
  }

  public String getNumeroCbf() {
    return this.numeroCbf;
  }

  public void setNumeroCbf(String numeroCbf) {
    this.numeroCbf = numeroCbf;
  }

}
