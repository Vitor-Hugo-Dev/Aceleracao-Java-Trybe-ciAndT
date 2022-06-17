package com.trybe.acc.java.planejamentodeviagem;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Tempo {
  private LocalDateTime embarque;
  private String origem;
  private String destino;
  private int duracao;

  private static final String formato = "dd/MM/yyyy HH:mm:ss";

  /**
   * Método construtor da classe.
   * 
   */
  public Tempo(String embarque, String origem, String destino, int duracao) {
    this.embarque = LocalDateTime.parse(embarque, DateTimeFormatter.ofPattern(formato));
    this.origem = origem;
    this.destino = destino;
    this.duracao = duracao;
  }

  /**
   * retonarDesembarqueHorarioLocalDestino.
   * Transforma todos os fusos horarios disponíveis na classe ZoneId em um array
   * de Strings, onde
   * nos percorremos em busca do identificador do fuso horario do nosso destino,
   * uma vez com esse
   * fuso horario, podemos recuperar o horario local de desembarque no nosso
   * destino
   */
  public String retonarDesembarqueHorarioLocalDestino() {
    // cria um array de strings com o tamanho de todos os fusos horarios disponiveis
    String[] fusosHorarios = new String[ZoneId.getAvailableZoneIds().size()];
    // transforma o set(.getAvailableZoneIds()) com todos os fusos horarios
    // disponiveis em um array
    ZoneId.getAvailableZoneIds().toArray(fusosHorarios);

    int indiceFusoHorarioOrigem = 0; // indice do fuso horario de origem

    for (int i = 0; i < fusosHorarios.length; i++) { // percorre todos os fusos horarios disponiveis
      // se o fuso horario for igual ao fuso horario de origem
      if (fusosHorarios[i].contains(this.origem)) {
        indiceFusoHorarioOrigem = i; // guarda o indice do fuso horario de origem
      }
    }
    // guarda o fuso horario de origem
    String fusoHorarioOrigem = fusosHorarios[indiceFusoHorarioOrigem];
    // cria um objeto do fuso horario de origem
    ZoneId fusoHorarioIdOrigem = ZoneId.of(fusoHorarioOrigem);

    ZonedDateTime origemHorarioLocal = this.embarque.atZone(fusoHorarioIdOrigem);

    int indiceFusoHorarioDestino = 0;

    for (int i = 0; i < fusosHorarios.length; i++) { // percorre todos os fusos horarios disponiveis
      // se o fuso horario for igual ao fuso horario de destino
      if (fusosHorarios[i].contains(this.destino)) {
        indiceFusoHorarioDestino = i; // guarda o indice do fuso horario de destino
      }
    }
    // guarda o fuso horario de destino
    String fusoHorarioDestino = fusosHorarios[indiceFusoHorarioDestino];

    // cria um objeto do fuso horario local
    ZonedDateTime destinoHorarioLocal = origemHorarioLocal
        .withZoneSameInstant(ZoneId.of(fusoHorarioDestino));

    // retorna o horario local de desembarque no destino
    return destinoHorarioLocal.plusHours(this.duracao).format(DateTimeFormatter.ofPattern(formato));
  }

  /**
   * retonarDesembarqueHorarioLocalOrigem.
   * 
   */
  public String retonarDesembarqueHorarioLocalOrigem() {
    // cria um array de strings com o tamanho de todos os fusos horarios disponiveis
    String[] fusosHorarios = new String[ZoneId.getAvailableZoneIds().size()];

    // transforma o set(.getAvailableZoneIds()) com todos os fusos horarios
    // disponiveis em um array
    ZoneId.getAvailableZoneIds().toArray(fusosHorarios);

    int indiceFusoHorarioOrigem = 0; // indice do fuso horario de origem

    for (int i = 0; i < fusosHorarios.length; i++) { // percorre todos os fusos horarios disponiveis
      // se o fuso horario for igual ao fuso horario de origem
      if (fusosHorarios[i].contains(this.origem)) {
        indiceFusoHorarioOrigem = i; // guarda o indice do fuso horario de origem
      }
    }
    // guarda o fuso horario de origem
    String fusoHorarioOrigem = fusosHorarios[indiceFusoHorarioOrigem];
    // cria um objeto do fuso horario de origem
    ZoneId fusoHorarioIdOrigem = ZoneId.of(fusoHorarioOrigem);

    // cria um objeto do fuso horario local de origem
    ZonedDateTime origemHorarioLocal = this.embarque.atZone(fusoHorarioIdOrigem);

    // retorna o horario local de desembarque no destino
    return origemHorarioLocal.plusHours(this.duracao).format(DateTimeFormatter.ofPattern(formato));
  }
}
