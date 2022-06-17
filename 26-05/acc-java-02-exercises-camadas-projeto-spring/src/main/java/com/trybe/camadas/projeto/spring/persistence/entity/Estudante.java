package com.trybe.camadas.projeto.spring.persistence.entity;

/**
 * Classe Estudante.
 **/

public class Estudante {

  private String id;
  private String nomeEstudante;
  private String stackFavorita;
  private String cidade;

  /**
   * Construtor.
   */
  public Estudante(String id, String nomeEstudante, String stackFavorita, String cidade) {
    this.id = id;
    this.nomeEstudante = nomeEstudante;
    this.stackFavorita = stackFavorita;
    this.cidade = cidade;
  }

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getNomeEstudante() {
    return this.nomeEstudante;
  }

  public void setNomeEstudante(String nomeEstudante) {
    this.nomeEstudante = nomeEstudante;
  }

  public String getStackFavorita() {
    return this.stackFavorita;
  }

  public void setStackFavorita(String stackFavorita) {
    this.stackFavorita = stackFavorita;
  }

  public String getCidade() {
    return this.cidade;
  }

  public void setCidade(String cidade) {
    this.cidade = cidade;
  }


}
