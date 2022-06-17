package com.trybe.acc.java.iocdi.sistemapagamentos.interceptor;

public enum Verificacao {

  ADMINISTRADORA("trybe");

  String valor;

  Verificacao(String valor) {
    this.valor = valor;
  }

  public String getValor() {
    return valor;
  }
}