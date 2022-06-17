package com.trybe.gerarpessoausuaria;

public class Principal {
  public static void main(String[] args) {
    Usuario usuario = new Usuario("bruce", "wayne");

    System.out.println(usuario.getUsuario());

    Usuario usuarioSemNome = new Usuario("", "wayne");
    System.out.println(usuarioSemNome.getUsuario());

    Usuario usuarioSemSobrenome = new Usuario("bruce", "");
    System.out.println(usuarioSemSobrenome.getUsuario());

    Usuario usuarioNomeNull = new Usuario(null, "wayne");
    System.out.println(usuarioNomeNull.getUsuario());

    Usuario usuarioSobrenomeNull = new Usuario(null, "");
    System.out.println(usuarioSobrenomeNull.getUsuario());

  }
}
