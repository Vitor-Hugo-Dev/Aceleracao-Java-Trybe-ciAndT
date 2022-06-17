package com.trybe.acc.java.caixaeletronico;

import java.util.ArrayList;
import java.util.Random;

public class Banco {
  ArrayList<Conta> contas = new ArrayList<Conta>();
  ArrayList<PessoaCliente> pessoasClientes = new ArrayList<PessoaCliente>();

  /**
   * gerarNumeroNovaConta - Gera um número de conta novo.
   * 
   * @return - retorna o número de conta.
   */
  public String gerarNumeroNovaConta() {
    String numeroNovaConta = "";
    while (numeroNovaConta.length() < 10) {
      Random gerador = new Random();
      int numero = gerador.nextInt(10);
      numeroNovaConta += numero;
    }

    return numeroNovaConta;
  }

  /**
   * adicionarPessoaCliente - Adiciona uma pessoa cliente.
   * 
   * @param nome      - nome completo.
   * @param cpf       - cpf.
   * @param senha     - senha.
   * @param tipoConta - tipo de conta.
   * @return - retorna uma nova pessoa.
   */
  public PessoaCliente adicionarPessoaCliente(
      String nome,
      String tipoConta,
      String cpf,
      String senha) {
    PessoaCliente novaPessoaCliente = new PessoaCliente(nome, cpf, senha);
    Conta novaConta = new Conta(tipoConta, novaPessoaCliente, new Banco());
    novaPessoaCliente.adicionarConta(novaConta);
    this.contas.add(novaConta);
    pessoasClientes.add(novaPessoaCliente);

    return novaPessoaCliente;
  }

  public PessoaCliente getPessoa(int indice) {
    return pessoasClientes.get(indice);
  }

  /**
   * adicionarConta - Adiciona uma conta.
   * 
   * @param tipo   - tipo de conta.
   * @param pessoa - pessoa cliente.
   */
  public void adicionarConta(String tipo, PessoaCliente pessoa) {
    Conta novaConta = new Conta(tipo, pessoa, this);
    pessoa.adicionarConta(novaConta);
    this.contas.add(novaConta);
  }

  /**
   * pessoaClienteLogin - Verifica se a pessoa cliente está logada.
   * 
   * @param cpf   - cpf.
   * @param senha - senha.
   * @return - retorna a pessoa logada.
   */
  public PessoaCliente pessoaClienteLogin(String cpf, String senha) {
    PessoaCliente pessoaCliente = null;
    for (int i = 0; i < pessoasClientes.size(); i++) {
      if (pessoasClientes.get(i).getCpf() == cpf && pessoasClientes.get(i).validarSenha(senha)) {
        pessoaCliente = pessoasClientes.get(i);
      }
    }
    return pessoaCliente;
  }

  public void depositar(PessoaCliente pessoa, int indice, double quantia) {
    pessoa.adicionarTransacaoContaEspecifica(indice, quantia, "Depósito");
  }

  public void sacar(PessoaCliente pessoa, int indice, double quantia) {
    pessoa.adicionarTransacaoContaEspecifica(indice, -quantia, "Saque");
  }

  /**
   * transferirFundos - Transfere fundos entre contas.
   * 
   * @param pessoaCliente - pessoa cliente.
   * @param daConta       - conta de origem.
   * @param paraConta     - conta de destino.
   * @param quantia       - quantia a ser transferida.
   */
  public void transferirFundos(
      PessoaCliente pessoaCliente,
      int daConta,
      int paraConta,
      double quantia) {
    pessoaCliente.adicionarTransacaoContaEspecifica(daConta, -quantia,
        "Transferência para conta " + pessoaCliente.retornarIdContaEspecifica(paraConta));

    pessoaCliente.adicionarTransacaoContaEspecifica(paraConta, quantia,
        "Recebimento de transferência " + pessoaCliente.retornarIdContaEspecifica(daConta));

  }

  public void mostrarExtrato(PessoaCliente pessoaCliente, int conta) {
    pessoaCliente.retornarExtratoContaEspecifica(conta);
  }
}
