package com.trybe.camadas.projeto.spring.persistence.repository;

import com.trybe.camadas.projeto.spring.persistence.entity.Estudante;
import java.util.ArrayList;
import java.util.List;


public class EstudanteRepositoryImpl implements EstudanteRepository {

  List<Estudante> estudantes = new ArrayList<Estudante>();

  @Override
  public Estudante criarEstudante(Estudante estudante) {
    estudantes.add(estudante);

    return estudante;
  }

  @Override
  public Estudante buscaEstudantepeloId(String id) {
    return estudantes.stream().filter(e -> e.getId().equals(id)).findFirst().orElse(null);
  }

  @Override
  public Estudante atualizaEstudantepeloId(String id, Estudante estudante) {
    for (Estudante est : estudantes) {
      if (est.getId() == id) {
        estudantes.set(estudantes.indexOf(est), estudante);
      }
    }
    
    return estudante;
  }

  @Override
  public void excluiEstudantepeloId(String id) {
    Estudante estudante = buscaEstudantepeloId(id);

    estudantes.remove(estudante);
    
  }
  
}
