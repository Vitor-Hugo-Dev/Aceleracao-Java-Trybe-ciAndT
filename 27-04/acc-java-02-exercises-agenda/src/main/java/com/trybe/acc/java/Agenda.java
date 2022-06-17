package com.trybe.acc.java;

import java.util.ArrayList;
import java.util.List;

public class Agenda {
  private List<String> contatos = new ArrayList<>();

  /**
   * incluirContato - add new name in this list.
   * 
   * @param nome - the name for add in this list.
   */
  public void incluirContato(String nome) {

    contatos.add(nome);
  }

  /**
   * excluirContato - remove a name from this list.
   * 
   * @param nome - the name for remove to this list.
   */
  public void excluirContato(String nome) {
    contatos.remove(nome);
  }

  /**
   * verificaContato - verify if a name exists in this list.
   * 
   * @param nome - the name for verify if exist in this list.
   * @return exist or not exist.
   */
  public boolean verificaContato(String nome) {
    return contatos.contains(nome);
  }

  /**
   * tamanhoAgenda - return the length of this list.
   * 
   * @return length of list.
   */
  public int tamanhoAgenda() {
    return contatos.size();
  }
}
