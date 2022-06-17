package com.trybe.gerarpessoausuaria;

public class Usuario extends Pessoa {

  public Usuario(String nome, String sobrenome) {
    this.nome = nome;
    this.sobrenome = sobrenome;
  }

  /**
   * Método para pegar o nome e sobrenome do usuário.
   *
   */
  public String getUsuario() {
    String erroMsg = "Usuário inválido";

    if (super.nome == null || super.nome.isEmpty() || super.sobrenome == null
        || this.sobrenome.isEmpty()) {
      return erroMsg;
    } else {
      return super.nome + "." + super.sobrenome;
    }
  }
}
