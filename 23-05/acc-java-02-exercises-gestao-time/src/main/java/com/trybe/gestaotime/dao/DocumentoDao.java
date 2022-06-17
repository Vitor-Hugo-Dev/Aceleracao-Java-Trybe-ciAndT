package com.trybe.gestaotime.dao;

import com.trybe.gestaotime.model.Documento;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class DocumentoDao extends GenericDao<Documento, Integer> {

  @Override
  public void salvar(Documento documento) {
    EntityManager em = emf.createEntityManager();

    em.getTransaction().begin();
    em.persist(documento);
    em.getTransaction().commit();
    em.close();
  }

  @Override
  public void editar(Documento documento) {
    EntityManager em = emf.createEntityManager();

    em.getTransaction().begin();
    em.merge(documento);
    em.getTransaction().commit();
    em.close();
  }

  @Override
  public void deletar(Integer id) {
    EntityManager em = emf.createEntityManager();

    em.getTransaction().begin();
    Documento documento = em.find(Documento.class, id);
    em.remove(documento);
    em.getTransaction().commit();
    em.close();
  }

  @Override
  public List<Documento> listar() {
    EntityManager em = emf.createEntityManager();

    Query query = em.createQuery("from Documento");

    return query.getResultList();
  }

}
