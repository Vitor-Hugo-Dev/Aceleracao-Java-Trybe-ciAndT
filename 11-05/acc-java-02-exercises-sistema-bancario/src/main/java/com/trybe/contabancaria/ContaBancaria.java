package com.trybe.contabancaria;

/**
 * Classe ContaBancaria.
 **/

public class ContaBancaria {

  int saldo;
  Cliente cliente;

  public ContaBancaria() {
    this.saldo = 0;
    this.cliente = new Cliente();
  }

  public void setNomeCliente(String nome) {
    this.cliente.setNome(nome);
  }

  public String getNomeCliente() {
    return this.cliente.getNome();
  }

  public void setCpfCliente(String cpf) {
    this.cliente.setCpf(cpf);
  }

  public String getCpfCliente() {
    return this.cliente.getCpf();
  }

  public int depositar(int valor) {
    this.saldo += valor;
    return this.saldo;
  }

  /**
   * Retorna o saldo da conta.
   */
  public int sacar(int valor) {
    if (this.saldo >= valor) {
      this.saldo -= valor;
      return this.saldo;
    } else {
      return -1;
    }
  }

  public int verSaldo() {
    return this.saldo;
  }

}
