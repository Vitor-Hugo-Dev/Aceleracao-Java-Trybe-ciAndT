package com.trybe.gestaotime.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 * Classe Time.
 **/
@Entity
public class Time {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String nome;

  @OneToMany(mappedBy = "time", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Jogador> jogadores = new ArrayList<>();

  @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
  @JoinTable(name = "relacionamento_time_torcedor", joinColumns = {
      @JoinColumn(name = "time_id") }, inverseJoinColumns = {
          @JoinColumn(name = "torcedor_id") })
  private List<Torcedor> torcedores = new ArrayList<>();

  public void addTorcedor(Torcedor torcedor) {
    torcedores.add(torcedor);
  }

  public void addJogador(Jogador jogador) {
    jogadores.add(jogador);
  }

  public List<Torcedor> getTorcedores() {
    return this.torcedores;
  }

  public void setTorcedores(List<Torcedor> torcedores) {
    this.torcedores = torcedores;
  }

  public List<Jogador> getJogadores() {
    return this.jogadores;
  }

  public void setJogadores(List<Jogador> jogadores) {
    this.jogadores = jogadores;
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

}
