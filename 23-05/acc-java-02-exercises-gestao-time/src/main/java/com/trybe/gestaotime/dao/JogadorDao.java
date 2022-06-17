package com.trybe.gestaotime.dao;

import com.trybe.gestaotime.model.Jogador;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class JogadorDao extends GenericDao<Jogador, Integer> {

  @Override
  public void salvar(Jogador jogador) {
    EntityManager em = emf.createEntityManager();

    em.getTransaction().begin();
    em.persist(jogador);
    em.getTransaction().commit();
    em.close();
  }

  @Override
  public void editar(Jogador jogador) {
    EntityManager em = emf.createEntityManager();

    em.getTransaction().begin();
    em.merge(jogador);
    em.getTransaction().commit();
    em.close();
  }

  @Override
  public void deletar(Integer id) {
    EntityManager em = emf.createEntityManager();

    em.getTransaction().begin();
    Jogador jogador = em.find(Jogador.class, id);
    em.remove(jogador);
    em.getTransaction().commit();
    em.close();
  }

  @Override
  public List<Jogador> listar() {
    EntityManager em = emf.createEntityManager();

    Query query = em.createQuery("from Jogador");

    return query.getResultList();
  }
}
