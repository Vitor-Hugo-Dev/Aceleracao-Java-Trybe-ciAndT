package com.trybe.acc.java.caixaeletronico;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

@DisplayName("Testes dos métodos da classe Transacao")
class TransacaoTest {
  private Transacao transacao;
  private double quantia = 100.00;
  private String descricao = "Depósito";

  @BeforeEach
  void beforeEach() {
    transacao = new Transacao(quantia, descricao);
  }

  @Test
  @DisplayName("21 - Testa o método construtor da classe Transacao.")
  void construtorTest() {
    assertNotNull(transacao);
  }

  @Test
  @DisplayName("22 - Testa o método Getter do atributo quantia.")
  void getQuantiaTest() {
    assertEquals(quantia, transacao.getQuantia());
  }

  @Test
  @DisplayName("23 - Testa o método retornar resumo transacao.")
  void retornarResumoTransacaoTest() {
    String resumo = new StringBuilder()
        .append("Descrição: " + descricao + " ")
        .append("Quantia: " + quantia + " ")
        .append("Instante: " + transacao.retornarInstante() + "\n")

        .toString();
    assertEquals(resumo, transacao.retornarResumoTransacao());
  }

  @Test
  @DisplayName("24 - Testa o método instante está gerando o instante corretamente.")
  void retornarInstanteTest() {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    LocalDateTime instante = LocalDateTime.now();
    String instanteFormatado = instante.format(formatter);
    assertEquals(instanteFormatado, transacao.retornarInstante());

  }

}
