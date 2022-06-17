package com.trybe.acc.java.anobissexto;

import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;

public class AnoBissexto {

  /**
   * identificarAnoBissexto.
   * 
   * @param ano um ano (yyyy).
   * @return true se o ano for bissexto, false caso contrário.
   */
  public boolean identificarAnoBissexto(int ano) {
    Year year = Year.of(ano);
    return year.isLeap();
  }

  /**
   * identificarProximoAnoBissexto.
   * 
   * @param data - uma data qualquer ("dd/MM/yyyy").
   * @return - o proximo ano bissexto.
   */
  public int identificarProximoAnoBissexto(String data) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // formato da data
    int localDate = LocalDate.parse(data, formatter).getYear(); // pega o ano da data

    while (!identificarAnoBissexto(localDate)) { // enquanto o ano não for bissexto
      localDate++; // incrementa o ano
    }

    return localDate; // retorna o proximo ano bissexto
  }
}
