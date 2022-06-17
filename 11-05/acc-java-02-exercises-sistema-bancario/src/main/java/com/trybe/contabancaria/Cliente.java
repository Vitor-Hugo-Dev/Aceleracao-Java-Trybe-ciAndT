package com.trybe.contabancaria;

/**
 * Classe Cliente.
 **/

public class Cliente {

  private String nome;
  
  private String cpf;
  
  public void setNome(String nome) {
    this.nome = nome;
  }
  
  public String getNome() {
    return this.nome;
  }
  
  /**
   * Retorna o nome do cliente.
   */
  public void setCpf(String cpf) {
    boolean validCpf = ValidaCpf.validarCpf(cpf);

    if (validCpf) {
      this.cpf = cpf;
    } else {
      this.cpf = null;
    }
  }

  public String getCpf() {
    return this.cpf;
  }
}
