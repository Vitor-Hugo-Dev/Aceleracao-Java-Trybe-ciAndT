package com.trybe.acc.java.iocdi.sistemapagamentos.model;

public class Auth {
  
  private String usuario;
  private String senha;
  private String nivelDeAcesso;

  public String getUsuario() {
    return this.usuario;
  }

  public void setUsuario(String usuario) {
    this.usuario = usuario;
  }

  public String getSenha() {
    return this.senha;
  }

  public void setSenha(String senha) {
    this.senha = senha;
  }

  public String getNivelDeAcesso() {
    return this.nivelDeAcesso;
  }

  public void setNivelDeAcesso(String nivelDeAcesso) {
    this.nivelDeAcesso = nivelDeAcesso;
  }

}
