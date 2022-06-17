package com.trybe.acc.java.datacenter.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Datacenter {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String nome;

  private String localidade;

  @OneToMany(mappedBy = "datacenter", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Servidor> servidores;

  public Datacenter() {
    super();
    this.servidores = new ArrayList<Servidor>();
  }

  public void addServidor(Servidor servidor) {
    this.servidores.add(servidor);
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNome() {
    return this.nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getLocalidade() {
    return this.localidade;
  }

  public void setLocalidade(String localidade) {
    this.localidade = localidade;
  }

}
