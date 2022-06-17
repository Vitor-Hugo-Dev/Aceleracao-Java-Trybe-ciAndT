package com.trybe.acc.java.caixaeletronico;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Teste da classe Conta")
class ContaTest {
  private Conta conta;
  private PessoaCliente pessoaCliente;
  private Banco banco;
  private final String nome = "Dino o sauro";
  private final String cpf = "123.456.789-00";
  private final String senha = "40028922";
  private final String tipoConta = "Corrente";

  private final ByteArrayOutputStream testeConsole = new ByteArrayOutputStream(); // https://www.tutorialspoint.com/java/java_bytearrayoutputstream.htm

  private final PrintStream consolePadrao = System.out; // https://www.devmedia.com.br/destrinchando-a-classe-java-lang-system/29808

  @BeforeEach
  void beforeEach() {

    pessoaCliente = new PessoaCliente(nome, cpf, senha);
    banco = new Banco();
    conta = new Conta(tipoConta, pessoaCliente, banco);

    System.setOut(new PrintStream(testeConsole)); // muda a saida do console para poder testar as transaçoes.
    conta.adicionarTransacao(100.00, "Depósito");
    conta.adicionarTransacao(-100.00, "Saque");
  }

  @AfterEach
  void afterEach() {
    System.setOut(consolePadrao); // restaura para a saida padrão.
  }

  @Test
  @DisplayName("6 - Testa o construtor da classe conta.")
  void construtorTest() {
    assertNotNull(conta);
  }

  @Test
  @DisplayName("7 - Testa o método adicionar transação e retornar saldo da conta.")
  void adicionarTransacaoTestRetornarSaldoTest() {

    assertEquals(0.00, conta.retornarSaldo());
  }

  @Test
  @DisplayName("8 - Testa o método retornar resumo está retornando uma string com os valores corretamente.")
  void retornarResumoContaTest() {
    String resumo = new StringBuilder()
        .append("ID da conta: " + conta.getIdConta() + "\n")
        .append("Tipo da conta: " + tipoConta + "\n")
        .append("Saldo: " + conta.retornarSaldo() + "\n")
        .toString();
    assertEquals(resumo, conta.retornarResumoConta());
  }

  @Test
  @DisplayName("9 - Testa o método retornar extrato está imprimindo os valores corretamente.")
  void retornarExtratoTest() {
    String extrato1 = new StringBuilder()
        .append("Descrição: " + "Depósito")
        .toString();
    conta.retornarExtrato();
    // assertEquals(extrato1, testeConsole);
    assertTrue(testeConsole.toString().contains(extrato1));

    String extrato2 = new StringBuilder()
        .append("Descrição: " + "Saque")
        .toString();
    assertTrue(testeConsole.toString().contains(extrato2));

  }

  @Test
  @DisplayName("10 - Testa o método Getter do atributo idConta está retornando.")
  void getIdContaTest() {
    assertNotNull(conta.getIdConta());

  }

  @Test
  @DisplayName("11 - Testa o método método Getter do atributo pessoaCliente está retornando.")
  void getPessoaClienteTest() {
    assertEquals(pessoaCliente, conta.getPessoaCliente());
  }

}
