package com.trybe.acc.java.caixaeletronico;

import java.util.ArrayList;

public class PessoaCliente {
  private String nomeCompleto;
  private String cpf;
  private String senha;
  private ArrayList<Conta> contas = new ArrayList<Conta>();

  /**
   * PessoaCliente - Contrutor da classe PessoaCliente.
   * 
   * @param nome  - nome completo.
   * @param cpf   - cpf.
   * @param senha - senha.
   */
  public PessoaCliente(String nome, String cpf, String senha) {
    this.nomeCompleto = nome;
    this.cpf = cpf;
    this.senha = senha;
    System.out.println(
        "Nova Pessoa " + this.nomeCompleto + " com CPF: " + this.cpf + " criada com sucesso!");
  }

  public void adicionarConta(Conta conta) {
    this.contas.add(conta);
  }

  /**
   * retornarNumeroDeContas.
   * 
   * @return - retorna o número de contas.
   */
  public int retornarNumeroDeContas() {
    return this.contas.size();
  }

  public double retornarSaldoContaEspecifica(int indice) {
    return this.contas.get(indice).retornarSaldo();
  }

  public String retornarIdContaEspecifica(int indice) {
    return this.contas.get(indice).getIdConta();
  }

  public void retornarExtratoContaEspecifica(int indice) {
    this.contas.get(indice).retornarExtrato();
  }

  public void adicionarTransacaoContaEspecifica(int indice, double quantia, String descricao) {
    this.contas.get(indice).adicionarTransacao(quantia, descricao);
  }

  /**
   * validarSenha.
   * 
   * @param senha - senha.
   * @return - retorna true se a senha for válida.
   */
  public boolean validarSenha(String senha) {
    if (this.senha == senha) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * retornarResumoContas.
   * 
   */
  public void retornarResumoContas() {
    for (int i = 0; i < this.contas.size(); i++) {
      System.out.println(this.contas.get(i).retornarResumoConta());
    }
  }

  public String getCpf() {
    return this.cpf;
  }
}
