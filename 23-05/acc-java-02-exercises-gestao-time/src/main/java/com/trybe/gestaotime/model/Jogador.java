package com.trybe.gestaotime.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 * Classe Jogador.
 **/
@Entity
public class Jogador {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String nome;

  private String posicao;

  @OneToOne(mappedBy = "jogador", cascade = {
      CascadeType.ALL }, orphanRemoval = true, fetch = FetchType.LAZY)
  private Documento documento;

  @ManyToOne
  @JoinColumn(name = "time_id")
  private Time time;

  public Time getTime() {
    return this.time;
  }

  public void setTime(Time time) {
    this.time = time;
  }

  public Documento getDocumento() {
    return this.documento;
  }

  public void setDocumento(Documento documento) {
    this.documento = documento;
  }

  public Integer getId() {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getNome() {
    return this.nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getPosicao() {
    return this.posicao;
  }

  public void setPosicao(String posicao) {
    this.posicao = posicao;
  }

}
