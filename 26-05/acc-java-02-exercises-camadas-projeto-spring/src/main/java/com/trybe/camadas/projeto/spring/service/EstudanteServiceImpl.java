package com.trybe.camadas.projeto.spring.service;

import com.trybe.camadas.projeto.spring.persistence.entity.Estudante;
import com.trybe.camadas.projeto.spring.persistence.repository.EstudanteRepository;

public class EstudanteServiceImpl implements EstudanteService {

  EstudanteRepository estudanteRepository;

  @Override
  public Estudante criarEstudante(Estudante estudante) {
    return estudanteRepository.criarEstudante(estudante);
  }

  @Override
  public Estudante buscaEstudantepeloId(String id) {
    return estudanteRepository.buscaEstudantepeloId(id);
  }

  @Override
  public Estudante atualizaEstudantepeloId(String id, Estudante estudante) {
    return estudanteRepository.atualizaEstudantepeloId(id, estudante);
  }

  @Override
  public void excluiEstudantepeloId(String id) {

    estudanteRepository.excluiEstudantepeloId(id);
    
  }

}
