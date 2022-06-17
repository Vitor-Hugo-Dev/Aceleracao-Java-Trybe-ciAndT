package com.trybe.acc.java;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OperacoesVeiculos {

  /**
   * numVeiculosDiferentesVendidos - count the number of different vehicles sold.
   * 
   * @param <T>              - generic type of the stream
   * @param veiculosVendidos - stream of vehicles
   * @return - (int) number of different vehicles sold
   */
  public <T> int numVeiculosDiferentesVendidos(Stream<T> veiculosVendidos) {
    return (int) veiculosVendidos.distinct().count();
  }

  /**
   * obterRepresentacao - return a stream of strings representing the vehicles.
   * 
   * @param <T>      - generic type of the stream
   * @param veiculos - stream of vehicles
   * @return - (Stream of strings) stream of strings representing the vehicles .
   */
  public <T> Stream<String> obterRepresentacao(Stream<T> veiculos) {
    return veiculos.map(veiculo -> veiculo.toString());
  }

  /**
   * obterLista - return a list of vehicles.
   * 
   * @param <T>      - generic type of the stream
   * @param veiculos - stream of vehicles
   * @return - (List) list of vehicles
   */
  public <T> List<T> obterLista(Stream<T> veiculos) {
    return veiculos.collect(Collectors.toList());
  }
}
