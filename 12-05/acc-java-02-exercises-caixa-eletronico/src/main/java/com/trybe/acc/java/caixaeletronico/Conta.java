package com.trybe.acc.java.caixaeletronico;

import java.util.ArrayList;

public class Conta {

  private String tipoConta;
  private String idConta;
  private PessoaCliente pessoaCliente;
  private ArrayList<Transacao> transacoes = new ArrayList<Transacao>();

  /**
   * Conta - Contrutor da classe Conta.
   * 
   * @param tipoConta     - conta Corrente ou Poupança.
   * @param pessoaCliente - pessoa Cliente.
   * @param banco         - banco.
   */
  public Conta(String tipoConta, PessoaCliente pessoaCliente, Banco banco) {
    this.tipoConta = tipoConta;
    this.pessoaCliente = pessoaCliente;
    this.idConta = banco.gerarNumeroNovaConta();
  }

  public void adicionarTransacao(double quantia, String descricao) {
    Transacao novaTransacao = new Transacao(quantia, descricao);
    this.transacoes.add(novaTransacao);
  }

  /**
   * retornarSaldo.
   * 
   * @return - retorna o saldo da conta.
   */
  public double retornarSaldo() {
    double saldo = 0;
    for (int i = 0; i < this.transacoes.size(); i++) {
      saldo += this.transacoes.get(i).getQuantia();
    }
    return saldo;
  }

  /**
   * retornarResumoConta.
   * 
   * @return - retorna o resumo da conta.
   */
  public String retornarResumoConta() {
    String resumo = new StringBuilder()
        .append("ID da conta: " + this.idConta + "\n")
        .append("Tipo da conta: " + this.tipoConta + "\n")
        .append("Saldo: " + this.retornarSaldo() + "\n")
        .toString();

    return resumo;
  }

  /**
   * retornarExtrato.
   */
  public void retornarExtrato() {
    for (int i = 0; i < this.transacoes.size(); i++) {
      System.out.println(this.transacoes.get(i).retornarResumoTransacao());
    }
  }

  public String getIdConta() {
    return this.idConta;
  }

  public PessoaCliente getPessoaCliente() {
    return this.pessoaCliente;
  }
}
