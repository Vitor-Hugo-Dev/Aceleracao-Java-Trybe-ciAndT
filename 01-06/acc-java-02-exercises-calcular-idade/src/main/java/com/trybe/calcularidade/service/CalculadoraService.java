package com.trybe.calcularidade.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.trybe.calcularidade.domain.Idade;

/**
 * Classe CalculadoraService.
 **/
@Service
public class CalculadoraService {

  private Idade idade = new Idade();


  @CircuitBreaker(name = "estudantes", fallbackMethod = "fallback")
  public Map<String, Integer> calcularIdade(String data) {
    
    
  }

}
