package com.trybe.contapoupanca;

public class ContaPoupanca {
  private double saldo;
  private String titular;

  public ContaPoupanca(String titular, double saldo) {
    this.titular = titular;
    this.saldo = saldo;
  }

  public void depositar(double valor) {
    this.saldo += valor;
  }

  public void sacar(double valor) {
    this.saldo -= valor;
  }

  public double mostrarSaldo() {
    return this.saldo;
  }

  public String mostrarTitularConta() {
    return this.titular;
  }

}
