package com.trybe.agenda;

import java.util.HashMap;

public class AgendaMapa {

  public HashMap<String, String> agenda = new HashMap<String, String>();

  /**
   * incluirContato - Adiciona um contato na agenda.
   * 
   * @param nome     - Nome do contato.
   * @param telefone - Telefone do contato.
   */
  public void incluirContato(String nome, String telefone) {
    agenda.put(nome, telefone);
  }

  /**
   * excluirContato - Remove um contato da agenda.
   * 
   * @param nome - Nome do contato.
   */
  public void excluirContato(String nome) {
    agenda.remove(nome);
  }

  /**
   * verificaContato - Verifica se um contato está na agenda.
   * 
   * @param nome - name of contact.
   * @return - return a boolean value.
   */
  public boolean verificaContato(String nome) {
    return agenda.containsKey(nome);
  }

  /**
   * tamanhoAgenda - return the length of agenda.
   * 
   * @return - return a integer value.
   */
  public int tamanhoAgenda() {
    return agenda.size();
  }

  /**
   * atualizarTelefone - replace the phone number of a contact.
   * 
   * @param nome     - name of contact.
   * @param telefone - new phone number.
   * @return - return the last contact.
   */
  public String atualizarTelefone(String nome, String telefone) {
    return agenda.replace(nome, telefone);
  }

  /**
   * obterTelefone - return the phone number of a contact.
   * 
   * @param nome - name of contact.
   * @return - return the phone number of a contact.
   */
  public String obterTelefone(String nome) {
    return agenda.get(nome);
  }
}
