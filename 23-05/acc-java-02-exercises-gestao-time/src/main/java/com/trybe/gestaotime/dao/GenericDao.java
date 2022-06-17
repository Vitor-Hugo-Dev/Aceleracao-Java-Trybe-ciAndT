package com.trybe.gestaotime.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Classe abstrata GenericDao.
 **/

public abstract class GenericDao<T, I extends Serializable> {

  EntityManagerFactory emf = Persistence.createEntityManagerFactory("crudHibernatePU");

  public void salvar(T entity) {

  }

  public void editar(T entity) {

  }

  public void deletar(I id) {

  }

  public List<T> listar() {

    return null;
  }

}
