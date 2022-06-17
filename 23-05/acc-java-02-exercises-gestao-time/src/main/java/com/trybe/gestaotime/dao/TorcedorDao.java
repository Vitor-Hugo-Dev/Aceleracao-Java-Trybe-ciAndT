package com.trybe.gestaotime.dao;

import com.trybe.gestaotime.model.Torcedor;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class TorcedorDao extends GenericDao<Torcedor, Integer> {

  @Override
  public void salvar(Torcedor torcedor) {
    EntityManager em = emf.createEntityManager();

    em.getTransaction().begin();
    em.persist(torcedor);
    em.getTransaction().commit();
    em.close();
  }

  @Override
  public void editar(Torcedor torcedor) {
    EntityManager em = emf.createEntityManager();

    em.getTransaction().begin();
    em.merge(torcedor);
    em.getTransaction().commit();
    em.close();
  }

  @Override
  public void deletar(Integer id) {
    EntityManager em = emf.createEntityManager();

    em.getTransaction().begin();
    Torcedor torcedor = em.find(Torcedor.class, id);
    em.remove(torcedor);
    em.getTransaction().commit();
    em.close();
  }

  @Override
  public List<Torcedor> listar() {
    EntityManager em = emf.createEntityManager();

    Query query = em.createQuery("from Torcedor");

    return query.getResultList();
  }
}
